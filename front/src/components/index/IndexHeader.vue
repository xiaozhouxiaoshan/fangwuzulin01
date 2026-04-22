<template>
  <div
    class="navbar"
    :style="{
      backgroundColor: heads.headBgColor,
      height: heads.headHeight,
      boxShadow: heads.headBoxShadow,
      lineHeight: heads.headHeight
    }"
  >
    <div class="title-menu" :style="{ justifyContent: heads.headTitleStyle == '1' ? 'flex-start' : 'center' }">
      <el-image
        v-if="heads.headTitleImg"
        class="title-img"
        :style="{
          width: heads.headTitleImgWidth,
          height: heads.headTitleImgHeight,
          boxShadow: heads.headTitleImgBoxShadow,
          borderRadius: heads.headTitleImgBorderRadius
        }"
        :src="heads.headTitleImgUrl"
        fit="cover"
      />
      <div class="title-name" :style="{ color: heads.headFontColor, fontSize: heads.headFontSize }">
        {{ this.$project.projectName }}
      </div>
    </div>

    <div class="right-menu">
      <div class="assistant-entry">
        <el-button
          size="mini"
          type="primary"
          plain
          icon="el-icon-chat-dot-round"
          @click="assistantVisible = true"
        >
          智能助手
        </el-button>
      </div>
      <div class="user-info" :style="{ color: heads.headUserInfoFontColor, fontSize: heads.headUserInfoFontSize }">
        {{ this.$storage.get('role') }} {{ this.$storage.get('adminName') }}
      </div>
      <div class="logout" :style="{ color: heads.headLogoutFontColor, fontSize: heads.headLogoutFontSize }" @click="onIndexTap">
        退出到前台
      </div>
      <div class="logout" :style="{ color: heads.headLogoutFontColor, fontSize: heads.headLogoutFontSize }" @click="onLogout">
        退出登录
      </div>
    </div>

    <el-drawer
      title=""
      :visible.sync="assistantVisible"
      direction="rtl"
      size="420px"
      append-to-body
      :with-header="false"
      custom-class="assistant-drawer"
    >
      <div class="assistant-drawer-body">
        <assistant-panel :show-header="false" :compact="true" @navigate="assistantVisible = false" />
      </div>
    </el-drawer>
  </div>
</template>

<script>
import AssistantPanel from "@/components/common/AssistantPanel";

export default {
  components: {
    AssistantPanel
  },
  data() {
    return {
      dialogVisible: false,
      ruleForm: {},
      user: {},
      assistantVisible: false,
      heads: {
        headLogoutFontHoverColor: "rgba(22, 119, 255, 1)",
        headFontSize: "18px",
        headUserInfoFontColor: "rgba(96, 106, 123, 1)",
        headBoxShadow: "0 1px 4px rgba(0,0,0,0.08)",
        headTitleImgHeight: "44px",
        headLogoutFontHoverBgColor: "rgba(22, 119, 255, 0.08)",
        headFontColor: "rgba(31, 35, 40, 1)",
        headTitleImg: false,
        headHeight: "56px",
        headTitleImgBorderRadius: "12px",
        headTitleImgUrl: "",
        headBgColor: "#ffffff",
        headTitleImgBoxShadow: "0 1px 4px rgba(0,0,0,0.08)",
        headLogoutFontColor: "rgba(22, 119, 255, 1)",
        headUserInfoFontSize: "14px",
        headTitleImgWidth: "44px",
        headTitleStyle: "1",
        headLogoutFontSize: "14px"
      }
    };
  },
  created() {
    this.setHeaderStyle();
  },
  mounted() {
    let sessionTable = this.$storage.get("sessionTable");
    this.$http({
      url: sessionTable + "/session",
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.user = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
  },
  methods: {
    onLogout() {
      let storage = this.$storage;
      let router = this.$router;
      storage.remove("Token");
      router.replace({
        name: "login"
      });
    },
    onIndexTap() {
      window.location.href = `${this.$base.indexUrl}`;
    },
    setHeaderStyle() {
      this.$nextTick(() => {
        document.querySelectorAll(".navbar .right-menu .logout").forEach(el => {
          el.addEventListener("mouseenter", e => {
            e.stopPropagation();
            el.style.backgroundColor = this.heads.headLogoutFontHoverBgColor;
            el.style.color = this.heads.headLogoutFontHoverColor;
          });
          el.addEventListener("mouseleave", e => {
            e.stopPropagation();
            el.style.backgroundColor = "transparent";
            el.style.color = this.heads.headLogoutFontColor;
          });
        });
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.navbar {
  height: 60px;
  line-height: 60px;
  width: 100%;
  padding: 0 34px;
  box-sizing: border-box;
  background-color: #ffffff;
  position: relative;
  z-index: 111;

  .right-menu {
    position: absolute;
    right: 34px;
    top: 0;
    height: 100%;
    display: flex;
    justify-content: flex-end;
    align-items: center;
    z-index: 111;

    .assistant-entry {
      padding-right: 8px;
    }

    .user-info {
      font-size: 16px;
      color: inherit;
      padding: 0 12px;
    }

    .logout {
      font-size: 16px;
      color: inherit;
      padding: 0 12px;
      cursor: pointer;
    }
  }

  .title-menu {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    width: 100%;
    height: 100%;

    .title-img {
      width: 44px;
      height: 44px;
      border-radius: 22px;
      box-shadow: 0 1px 6px #444;
      margin-right: 16px;
    }

    .title-name {
      font-size: 24px;
      color: #fff;
      font-weight: 700;
    }
  }
}

.assistant-drawer-body {
  padding: 16px;
  box-sizing: border-box;
  height: 100%;
  background: #fff;
}
</style>
