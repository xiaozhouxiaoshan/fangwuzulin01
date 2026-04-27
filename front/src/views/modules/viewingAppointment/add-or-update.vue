<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
                        <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="预约编号" prop="appointmentNumber">
            <el-input v-model="ruleForm.appointmentNumber" 
                placeholder="预约编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.appointmentNumber" label="预约编号" prop="appointmentNumber">
              <el-input v-model="ruleForm.appointmentNumber" 
                placeholder="预约编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房屋名称" prop="houseName">
          <el-input v-model="ruleForm.houseName" 
              placeholder="房屋名称" clearable  :readonly="ro.houseName"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房屋名称" prop="houseName">
              <el-input v-model="ruleForm.houseName" 
                placeholder="房屋名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房屋类型" prop="houseType">
          <el-input v-model="ruleForm.houseType" 
              placeholder="房屋类型" clearable  :readonly="ro.houseType"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房屋类型" prop="houseType">
              <el-input v-model="ruleForm.houseType" 
                placeholder="房屋类型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房屋状态" prop="houseStatus">
          <el-input v-model="ruleForm.houseStatus" 
              placeholder="房屋状态" clearable  :readonly="ro.houseStatus"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房屋状态" prop="houseStatus">
              <el-input v-model="ruleForm.houseStatus" 
                placeholder="房屋状态" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="小区" prop="community">
          <el-input v-model="ruleForm.community" 
              placeholder="小区" clearable  :readonly="ro.community"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="小区" prop="community">
              <el-input v-model="ruleForm.community" 
                placeholder="小区" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="月租价格" prop="monthlyRent">
          <el-input v-model="ruleForm.monthlyRent" 
              placeholder="月租价格" clearable  :readonly="ro.monthlyRent"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="月租价格" prop="monthlyRent">
              <el-input v-model="ruleForm.monthlyRent" 
                placeholder="月租价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="押金" prop="deposit">
          <el-input v-model="ruleForm.deposit" 
              placeholder="押金" clearable  :readonly="ro.deposit"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="押金" prop="deposit">
              <el-input v-model="ruleForm.deposit" 
                placeholder="押金" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="租用月数" prop="rentalMonths">
          <el-input v-model="ruleForm.rentalMonths" 
              placeholder="租用月数" clearable  :readonly="ro.rentalMonths"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="租用月数" prop="rentalMonths">
              <el-input v-model="ruleForm.rentalMonths" 
                placeholder="租用月数" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="租用金额" prop="rentalAmount">
            <el-input v-model="rentalAmount"
                placeholder="租用金额" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.rentalAmount" label="租用金额" prop="rentalAmount">
              <el-input v-model="ruleForm.rentalAmount" 
                placeholder="租用金额" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="预约时间" prop="appointmentTime">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.appointmentTime" 
                type="datetime"
                placeholder="预约时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.appointmentTime" label="预约时间" prop="appointmentTime">
              <el-input v-model="ruleForm.appointmentTime" 
                placeholder="预约时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="用户名" prop="tenantUsername">
          <el-input v-model="ruleForm.tenantUsername" 
              placeholder="用户名" clearable  :readonly="ro.tenantUsername"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="用户名" prop="tenantUsername">
              <el-input v-model="ruleForm.tenantUsername" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="姓名" prop="fullName">
          <el-input v-model="ruleForm.fullName" 
              placeholder="姓名" clearable  :readonly="ro.fullName"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="姓名" prop="fullName">
              <el-input v-model="ruleForm.fullName" 
                placeholder="姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="身份证" prop="idCardNumber">
          <el-input v-model="ruleForm.idCardNumber" 
              placeholder="身份证" clearable  :readonly="ro.idCardNumber"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="身份证" prop="idCardNumber">
              <el-input v-model="ruleForm.idCardNumber" 
                placeholder="身份证" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="联系电话" prop="contactPhone">
          <el-input v-model="ruleForm.contactPhone" 
              placeholder="联系电话" clearable  :readonly="ro.contactPhone"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="联系电话" prop="contactPhone">
              <el-input v-model="ruleForm.contactPhone" 
                placeholder="联系电话" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房主账号" prop="landlordAccount">
          <el-input v-model="ruleForm.landlordAccount" 
              placeholder="房主账号" clearable  :readonly="ro.landlordAccount"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房主账号" prop="landlordAccount">
              <el-input v-model="ruleForm.landlordAccount" 
                placeholder="房主账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房主姓名" prop="landlordName">
          <el-input v-model="ruleForm.landlordName" 
              placeholder="房主姓名" clearable  :readonly="ro.landlordName"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房主姓名" prop="landlordName">
              <el-input v-model="ruleForm.landlordName" 
                placeholder="房主姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                                          </el-row>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"rgba(152, 129, 129, 1)","inputBorderRadius":"22px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"22px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"22px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"rgba(210, 194, 194, 0.29)","dateIconFontSize":"14px","btnSaveBgColor":"#409EFF","uploadIconFontColor":"#8c939d","textareaBorderColor":"rgba(152, 129, 129, 1)","btnCancelBgColor":"rgba(143, 222, 143, 1)","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"22px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"#606266","dateBorderColor":"rgba(152, 129, 129, 1)","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"22px","inputBgColor":"rgba(252, 250, 250, 1)","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"22px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"rgba(152, 129, 129, 1)","inputBorderColor":"rgba(152, 129, 129, 1)","uploadBorderColor":"rgba(152, 129, 129, 1)","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"1px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"22px","selectFontColor":"#606266","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"1px"},
      id: '',
      type: '',
      ro:{
	appointmentNumber : false,
	houseName : false,
	houseType : false,
	houseStatus : false,
	community : false,
	monthlyRent : false,
	deposit : false,
	rentalMonths : false,
	rentalAmount : false,
	appointmentTime : false,
	tenantUsername : false,
	fullName : false,
	idCardNumber : false,
	contactPhone : false,
	landlordAccount : false,
	landlordName : false,
	reviewStatus : false,
	reviewReply : false,
      },
            ruleForm: {
                        appointmentNumber: this.getUUID(),
                        	        houseName: '',
	                        	        houseType: '',
	                        	        houseStatus: '',
	                        	        community: '',
	                        	        monthlyRent: '',
	                        	        deposit: '',
	                        	        rentalMonths: '',
	                        	        rentalAmount: '',
	                        	        appointmentTime: '',
	                        	        tenantUsername: '',
	                        	        fullName: '',
	                        	        idCardNumber: '',
	                        	        contactPhone: '',
	                        	        landlordAccount: '',
	                        	        landlordName: '',
	                        	                        	        reviewReply: '',
	                      },
                                                                                                                                                                                                                                                                        rules: {
                  appointmentNumber: [
                            { required: true, message: '预约编号不能为空', trigger: 'blur' },
                                    	                                                              ],
                  houseName: [
                                    	                                                              ],
                  houseType: [
                                    	                                                              ],
                  houseStatus: [
                                    	                                                              ],
                  community: [
                                    	                                                              ],
                  monthlyRent: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                        	                                                              ],
                  deposit: [
                                    	                                                              ],
                  rentalMonths: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                        	                                                              ],
                  rentalAmount: [
                                    	                                                              ],
                  appointmentTime: [
                            { required: true, message: '预约时间不能为空', trigger: 'blur' },
                                    	                                                              ],
                  tenantUsername: [
                                    	                                                              ],
                  fullName: [
                                    	                                                              ],
                  idCardNumber: [
                                    	                                                              ],
                  contactPhone: [
                                    	                                                              ],
                  landlordAccount: [
                                    	                                                              ],
                  landlordName: [
                                    	                                                              ],
                  reviewStatus: [
                                    	                                                              ],
                  reviewReply: [
                                    	                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                            rentalAmount:{
                                                                                                                                                                                                                                                                                        get: function () {
        return 1*this.ruleForm.monthlyRent*this.ruleForm.rentalMonths
      }
    },
                                                                                                                          },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          	            if(o=='appointmentNumber'){
            this.ruleForm.appointmentNumber = obj[o];
	    this.ro.appointmentNumber = true;
            continue;
          }
	            	            if(o=='houseName'){
            this.ruleForm.houseName = obj[o];
	    this.ro.houseName = true;
            continue;
          }
	            	            if(o=='houseType'){
            this.ruleForm.houseType = obj[o];
	    this.ro.houseType = true;
            continue;
          }
	            	            if(o=='houseStatus'){
            this.ruleForm.houseStatus = obj[o];
	    this.ro.houseStatus = true;
            continue;
          }
	            	            if(o=='community'){
            this.ruleForm.community = obj[o];
	    this.ro.community = true;
            continue;
          }
	            	            if(o=='monthlyRent'){
            this.ruleForm.monthlyRent = obj[o];
	    this.ro.monthlyRent = true;
            continue;
          }
	            	            if(o=='deposit'){
            this.ruleForm.deposit = obj[o];
	    this.ro.deposit = true;
            continue;
          }
	            	            if(o=='rentalMonths'){
            this.ruleForm.rentalMonths = obj[o];
	    this.ro.rentalMonths = true;
            continue;
          }
	            	            if(o=='rentalAmount'){
            this.ruleForm.rentalAmount = obj[o];
	    this.ro.rentalAmount = true;
            continue;
          }
	            	            if(o=='appointmentTime'){
            this.ruleForm.appointmentTime = obj[o];
	    this.ro.appointmentTime = true;
            continue;
          }
	            	            if(o=='tenantUsername'){
            this.ruleForm.tenantUsername = obj[o];
	    this.ro.tenantUsername = true;
            continue;
          }
	            	            if(o=='fullName'){
            this.ruleForm.fullName = obj[o];
	    this.ro.fullName = true;
            continue;
          }
	            	            if(o=='idCardNumber'){
            this.ruleForm.idCardNumber = obj[o];
	    this.ro.idCardNumber = true;
            continue;
          }
	            	            if(o=='contactPhone'){
            this.ruleForm.contactPhone = obj[o];
	    this.ro.contactPhone = true;
            continue;
          }
	            	            if(o=='landlordAccount'){
            this.ruleForm.landlordAccount = obj[o];
	    this.ro.landlordAccount = true;
            continue;
          }
	            	            if(o=='landlordName'){
            this.ruleForm.landlordName = obj[o];
	    this.ro.landlordName = true;
            continue;
          }
	            	            	                    }
                                                                                                                                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                                                                                                                                                  		if(json.tenantUsername!=''&&json.tenantUsername){
              		this.ruleForm.tenantUsername = json.tenantUsername
		}
                                  		if(json.fullName!=''&&json.fullName){
              		this.ruleForm.fullName = json.fullName
		}
                                  		if(json.idCardNumber!=''&&json.idCardNumber){
              		this.ruleForm.idCardNumber = json.idCardNumber
		}
                                  		if(json.contactPhone!=''&&json.contactPhone){
              		this.ruleForm.contactPhone = json.contactPhone
		}
                                                                                                                      } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                                                                                                                                                                                                                  },
                                                                                                                                                        // 多级联动参数
                                                                                                                                                                                                info(id) {
      this.$http({
        url: `viewingAppointment/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
              this.ruleForm.rentalAmount = this.rentalAmount
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                                                                                        this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `viewingAppointment/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.viewingAppointmentCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.viewingAppointmentCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
                                                                                                                                                                                                                            	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  ::v-deep .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
