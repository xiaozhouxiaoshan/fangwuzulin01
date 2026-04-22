<template>
  <div>
    <div class="container loginIn">
      <div :class="2 == 1 ? 'left' : 2 == 2 ? 'left center' : 'left right'" class="login-card">
        <el-form class="login-form" label-position="left" :label-width="2 == 3 ? '56px' : '0px'">
          <div class="title-container">
            <h3 class="title">智慧房屋租赁系统登录</h3>
            <p class="sub-title">欢迎回来，请选择角色后登录</p>
          </div>

          <el-form-item :label="2 == 3 ? '用户名' : ''" :class="'style' + 2">
            <span v-if="2 != 3" class="svg-container"><svg-icon icon-class="user" /></span>
            <el-input placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username" />
          </el-form-item>

          <el-form-item :label="2 == 3 ? '密码' : ''" :class="'style' + 2">
            <span v-if="2 != 3" class="svg-container"><svg-icon icon-class="password" /></span>
            <el-input placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password" />
          </el-form-item>

          <el-form-item v-if="0 == '1'" class="code" :label="2 == 3 ? '验证码' : ''" :class="'style' + 2">
            <span v-if="2 != 3" class="svg-container"><svg-icon icon-class="code" /></span>
            <el-input placeholder="请输入验证码" name="code" type="text" v-model="rulesForm.code" />
            <div class="getCodeBt" @click="getRandCode(4)">
              <span
                v-for="(item, index) in codes"
                :key="index"
                :style="{ color: item.color, transform: item.rotate, fontSize: item.size }"
              >{{ item.num }}</span>
            </div>
          </el-form-item>

          <el-form-item label="角色" prop="loginInRole" class="role">
            <el-radio
              v-for="item in menus"
              v-if="item.hasBackLogin == '是'"
              :key="item.roleName"
              v-model="rulesForm.role"
              :label="item.roleName"
            >{{ item.roleName }}</el-radio>
          </el-form-item>

          <el-button type="primary" @click="login()" class="loginInBt">登录</el-button>

          <el-form-item class="setting">
            <div class="register" @click="register('fangzhu')">注册房主</div>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import menu from "@/utils/menu";

export default {
  data() {
    return {
      rulesForm: {
        username: "",
        password: "",
        role: "",
        code: ""
      },
      menus: [],
      tableName: "",
      codes: [
        {
          num: 1,
          color: "#000",
          rotate: "10deg",
          size: "16px"
        },
        {
          num: 2,
          color: "#000",
          rotate: "10deg",
          size: "16px"
        },
        {
          num: 3,
          color: "#000",
          rotate: "10deg",
          size: "16px"
        },
        {
          num: 4,
          color: "#000",
          rotate: "10deg",
          size: "16px"
        }
      ]
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;
  },
  created() {
    this.getRandCode();
  },
  methods: {
    register(tableName) {
      this.$storage.set("loginTable", tableName);
      this.$router.push({ path: "/register" });
    },
    login() {
      let code = "";
      for (let i in this.codes) {
        code += this.codes[i].num;
      }

      if ("0" == "1" && !this.rulesForm.code) {
        this.$message.error("请输入验证码");
        return;
      }
      if ("0" == "1" && this.rulesForm.code.toLowerCase() != code.toLowerCase()) {
        this.$message.error("验证码输入有误");
        this.getRandCode();
        return;
      }
      if (!this.rulesForm.username) {
        this.$message.error("请输入用户名");
        return;
      }
      if (!this.rulesForm.password) {
        this.$message.error("请输入密码");
        return;
      }
      if (!this.rulesForm.role) {
        this.$message.error("请选择角色");
        return;
      }

      let menus = this.menus;
      for (let i = 0; i < menus.length; i++) {
        if (menus[i].roleName == this.rulesForm.role) {
          this.tableName = menus[i].tableName;
        }
      }

      this.$http({
        url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
        method: "post"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$storage.set("Token", data.token);
          this.$storage.set("role", this.rulesForm.role);
          this.$storage.set("sessionTable", this.tableName);
          this.$storage.set("adminName", this.rulesForm.username);
          this.$router.replace({ path: "/index/" });
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    getRandCode(len = 4) {
      this.randomString(len);
    },
    randomString(len = 4) {
      let chars = [
        "a",
        "b",
        "c",
        "d",
        "e",
        "f",
        "g",
        "h",
        "i",
        "j",
        "k",
        "l",
        "m",
        "n",
        "o",
        "p",
        "q",
        "r",
        "s",
        "t",
        "u",
        "v",
        "w",
        "x",
        "y",
        "z",
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
        "M",
        "N",
        "O",
        "P",
        "Q",
        "R",
        "S",
        "T",
        "U",
        "V",
        "W",
        "X",
        "Y",
        "Z",
        "0",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9"
      ];
      let colors = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"];
      let sizes = ["14", "15", "16", "17", "18"];

      for (let i = 0; i < len; i++) {
        let key = Math.floor(Math.random() * chars.length);
        this.codes[i].num = chars[key];

        let colorCode = "#";
        for (let j = 0; j < 6; j++) {
          key = Math.floor(Math.random() * colors.length);
          colorCode += colors[key];
        }
        this.codes[i].color = colorCode;

        let rotate = Math.floor(Math.random() * 60);
        let plus = Math.floor(Math.random() * 2);
        if (plus == 1) {
          rotate = "-" + rotate;
        }
        this.codes[i].rotate = `rotate(${rotate}deg)`;

        let size = Math.floor(Math.random() * sizes.length);
        this.codes[i].size = sizes[size] + "px";
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.loginIn {
  min-height: 100vh;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 24px;
  background-image: linear-gradient(135deg, rgba(246, 249, 253, 0.9), rgba(236, 243, 252, 0.85)), url("~@/assets/img/bg.jpg");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;

  .left {
    position: relative;
    width: 460px;
    max-width: 100%;
    height: auto;
    border-radius: 20px;
    background-color: rgba(255, 255, 255, 0.9);
    border: 1px solid rgba(148, 163, 184, 0.25);
    box-shadow: 0 20px 40px rgba(15, 23, 42, 0.12);
    backdrop-filter: blur(4px);
    overflow: hidden;

    .login-form {
      background-color: transparent;
      width: 100%;
      right: inherit;
      padding: 36px 34px 24px;
      box-sizing: border-box;
      display: flex;
      justify-content: center;
      flex-direction: column;
    }

    .title-container {
      text-align: center;
      margin-bottom: 8px;

      .title {
        margin: 0;
        font-size: 30px;
        line-height: 1.2;
        letter-spacing: 2px;
        font-weight: 700;
        color: #1d4d8f;
      }

      .sub-title {
        margin: 8px 0 0;
        font-size: 13px;
        letter-spacing: 1px;
        color: #6b7280;
      }
    }

    .el-form-item {
      position: relative;
      margin-bottom: 20px;

      .svg-container {
        color: #64748b;
        vertical-align: middle;
        display: inline-block;
        position: absolute;
        left: 14px;
        top: 0;
        z-index: 1;
        line-height: 46px;
        width: 22px;
        text-align: center;
      }

      .el-input {
        display: inline-block;
        height: 46px;
        width: 100%;

        ::v-deep input {
          background: rgba(255, 255, 255, 0.95);
          border: 1px solid rgba(148, 163, 184, 0.42);
          -webkit-appearance: none;
          padding: 0 16px 0 42px;
          color: #1f2328;
          height: 46px;
          border-radius: 23px;
          transition: all 0.25s ease;
        }

        ::v-deep input:focus {
          border-color: #409eff;
          box-shadow: 0 0 0 3px rgba(64, 158, 255, 0.16);
        }
      }
    }

    .loginInBt {
      width: 100%;
      margin-top: 2px;
      padding: 0;
      font-size: 16px;
      font-weight: 600;
      border-radius: 23px;
      height: 46px;
      line-height: 46px;
      border: none;
      background: linear-gradient(135deg, #5eabff, #3f8dff);
      box-shadow: 0 10px 20px rgba(64, 158, 255, 0.3);
      transition: all 0.25s ease;

      &:hover,
      &:focus {
        transform: translateY(-1px);
        box-shadow: 0 14px 24px rgba(64, 158, 255, 0.36);
      }
    }

    .role {
      margin-bottom: 18px;
    }

    .role ::v-deep .el-form-item__content {
      display: flex;
      flex-wrap: wrap;
      gap: 8px;
      align-items: center;
    }

    .role ::v-deep .el-radio {
      margin-right: 0;
      padding: 0 12px 0 8px;
      border-radius: 16px;
      height: 32px;
      line-height: 32px;
      border: 1px solid rgba(148, 163, 184, 0.35);
      background-color: rgba(248, 250, 252, 0.95);
      transition: all 0.2s ease;
    }

    .role ::v-deep .el-radio:hover {
      border-color: rgba(64, 158, 255, 0.45);
      color: #2a5aa3;
    }

    .role ::v-deep .el-radio__label {
      padding-left: 6px;
      color: #334155;
    }

    .role ::v-deep .el-radio__input.is-checked + .el-radio__label {
      color: #2f6fd3;
      font-weight: 600;
    }

    .role ::v-deep .el-radio__input.is-checked .el-radio__inner {
      border-color: #3f8dff;
      background-color: #3f8dff;
    }
  }

  .center {
    position: relative;
    left: auto;
    top: auto;
    width: auto;
    transform: none;
    height: auto;
    border-radius: 20px;
  }

  .right {
    position: relative;
    left: auto;
    right: auto;
    top: auto;
    width: auto;
    height: auto;
  }

  .code {
    .el-form-item__content {
      position: relative;

      .getCodeBt {
        position: absolute;
        right: 0;
        top: 0;
        line-height: 46px;
        width: 100px;
        background-color: rgba(51, 51, 51, 0.4);
        color: #fff;
        text-align: center;
        border-radius: 0 23px 23px 0;
        height: 46px;
        overflow: hidden;

        span {
          padding: 0 5px;
          display: inline-block;
          font-size: 16px;
          font-weight: 600;
        }
      }

      .el-input {
        ::v-deep input {
          padding: 0 130px 0 42px;
        }
      }
    }
  }

  .setting {
    margin-top: 8px;

    ::v-deep .el-form-item__content {
      padding: 0 4px;
      box-sizing: border-box;
      line-height: 24px;
      height: 24px;
      font-size: 13px;
      color: #94a3b8;
      margin: 0 !important;
      display: flex;
      justify-content: flex-end;

      .register {
        width: auto;
        cursor: pointer;
        transition: all 0.2s ease;
      }

      .register:hover {
        color: #409eff;
      }

      .reset {
        float: right;
        width: 50%;
        text-align: right;
      }
    }
  }

  .style2 {
    padding-left: 0;

    .svg-container {
      left: 14px !important;
    }

    .el-input {
      ::v-deep input {
        padding: 0 16px 0 42px !important;
      }
    }
  }

  .code.style2,
  .code.style3 {
    .el-input {
      ::v-deep input {
        padding: 0 115px 0 42px;
      }
    }
  }

  .style3 {
    ::v-deep .el-form-item__label {
      padding-right: 6px;
    }

    .el-input {
      ::v-deep input {
        padding: 0 16px !important;
      }
    }
  }

  .role {
    ::v-deep .el-form-item__label {
      width: 56px !important;
    }

    ::v-deep .el-radio {
      margin-right: 0;
    }
  }

  @media (max-width: 768px) {
    padding: 16px;

    .left {
      width: 100%;

      .login-form {
        padding: 28px 22px 20px;
      }

      .title-container .title {
        font-size: 24px;
      }

      .title-container .sub-title {
        font-size: 12px;
      }
    }
  }
}
</style>
