<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                              <el-col :span="12">
        <el-form-item   v-if="flag=='tenant'"  label="用户名" prop="tenantUsername">
          <el-input v-model="ruleForm.tenantUsername" readonly              placeholder="用户名" clearable></el-input>
        </el-form-item>
      </el-col>
                                          <el-col :span="12">
        <el-form-item   v-if="flag=='tenant'"  label="姓名" prop="fullName">
          <el-input v-model="ruleForm.fullName"               placeholder="姓名" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="flag=='tenant'" label="头像" prop="avatar">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.avatar?ruleForm.avatar:''"
          @change="tenantavatarUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='tenant'"  label="性别" prop="gender">
          <el-select v-model="ruleForm.gender" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in tenantgenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='tenant'"  label="职业" prop="occupation">
          <el-input v-model="ruleForm.occupation"               placeholder="职业" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='tenant'"  label="联系电话" prop="contactPhone">
          <el-input v-model="ruleForm.contactPhone"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='tenant'"  label="身份证" prop="idCardNumber">
          <el-input v-model="ruleForm.idCardNumber"               placeholder="身份证" clearable></el-input>
        </el-form-item>
      </el-col>
                                                <el-col :span="12">
        <el-form-item   v-if="flag=='landlord'"  label="房主账号" prop="landlordAccount">
          <el-input v-model="ruleForm.landlordAccount" readonly              placeholder="房主账号" clearable></el-input>
        </el-form-item>
      </el-col>
                                          <el-col :span="12">
        <el-form-item   v-if="flag=='landlord'"  label="房主姓名" prop="landlordName">
          <el-input v-model="ruleForm.landlordName"               placeholder="房主姓名" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='landlord'"  label="性别" prop="gender">
          <el-select v-model="ruleForm.gender" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in landlordgenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="flag=='landlord'" label="头像" prop="avatar">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.avatar?ruleForm.avatar:''"
          @change="landlordavatarUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='landlord'"  label="手机" prop="phoneNumber">
          <el-input v-model="ruleForm.phoneNumber"               placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='landlord'"  label="身份证" prop="idCardNumber">
          <el-input v-model="ruleForm.idCardNumber"               placeholder="身份证" clearable></el-input>
        </el-form-item>
      </el-col>
                                                                                                                                                                                          <el-form-item v-if="flag=='adminUser'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
                                                                              tenantgenderOptions: [],
                                                                                                                        landlordgenderOptions: [],
                                                                                                                                                                                                                            };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                                                    this.tenantgenderOptions = "男,女".split(',')
                                                                                this.landlordgenderOptions = "男,女".split(',')
                                                                                                                                                  },
  methods: {
                                                                                                                                                                                                                                                                                                                tenantavatarUploadChange(fileUrls) {
        this.ruleForm.avatar = fileUrls;
    },
                                                                                                landlordavatarUploadChange(fileUrls) {
        this.ruleForm.avatar = fileUrls;
    },
                                                                                                                                            onUpdateHandler() {
                              if((!this.ruleForm.tenantUsername)&& 'tenant'==this.flag){
        this.$message.error('用户名不能为空');
        return
      }
                                                                  if((!this.ruleForm.password)&& 'tenant'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
                                                                                                                                                                                                                                                                                                                  if( 'tenant' ==this.flag && this.ruleForm.contactPhone&&(!isMobile(this.ruleForm.contactPhone))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
                                                                              if( 'tenant' ==this.flag && this.ruleForm.idCardNumber&&(!checkIdCard(this.ruleForm.idCardNumber))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
                                                      if((!this.ruleForm.landlordAccount)&& 'landlord'==this.flag){
        this.$message.error('房主账号不能为空');
        return
      }
                                                                  if((!this.ruleForm.password)&& 'landlord'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
                                                                  if((!this.ruleForm.landlordName)&& 'landlord'==this.flag){
        this.$message.error('房主姓名不能为空');
        return
      }
                                                                                                                                                                                                      if( 'landlord' ==this.flag && this.ruleForm.phoneNumber&&(!isMobile(this.ruleForm.phoneNumber))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
                                                                              if( 'landlord' ==this.flag && this.ruleForm.idCardNumber&&(!checkIdCard(this.ruleForm.idCardNumber))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
                                                                                                                                                                                                this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
