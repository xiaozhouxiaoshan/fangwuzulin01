<template>
  <div>
    <div class="container">
      <div class="login-form register-card">
        <h1 class="h1">智慧房屋租赁系统注册</h1>
		<el-form ref="rgsForm" class="rgs-form" :model="rgsForm" label-width="120px">
															<!-- <div v-if="tableName=='tenant'" class="input-group">
			   <div class="label">用户名</div>
			   <div class="input-container">
			     <input v-model="ruleForm.tenantming" class="input" type="text" placeholder="用户名">
			   </div>
			 </div> -->
			<el-form-item label="用户名" class="input" v-if="tableName=='tenant'">
			  <el-input v-model="ruleForm.tenantming" autocomplete="off" placeholder="用户名" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='tenant'" class="input-group">
			   <div class="label">密码</div>
			   <div class="input-container">
			     <input v-model="ruleForm.mima" class="input" type="text" placeholder="密码">
			   </div>
			 </div> -->
			<el-form-item label="密码" class="input" v-if="tableName=='tenant'">
			  <el-input v-model="ruleForm.mima" autocomplete="off" placeholder="密码" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='tenant'" class="input-group">
			   <div class="label">姓名</div>
			   <div class="input-container">
			     <input v-model="ruleForm.xingming" class="input" type="text" placeholder="姓名">
			   </div>
			 </div> -->
			<el-form-item label="姓名" class="input" v-if="tableName=='tenant'">
			  <el-input v-model="ruleForm.xingming" autocomplete="off" placeholder="姓名" type="text" />
			</el-form-item>
																														<!-- <div v-if="tableName=='tenant'" class="input-group">
			   <div class="label">职业</div>
			   <div class="input-container">
			     <input v-model="ruleForm.zhiye" class="input" type="text" placeholder="职业">
			   </div>
			 </div> -->
			<el-form-item label="职业" class="input" v-if="tableName=='tenant'">
			  <el-input v-model="ruleForm.zhiye" autocomplete="off" placeholder="职业" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='tenant'" class="input-group">
			   <div class="label">联系电话</div>
			   <div class="input-container">
			     <input v-model="ruleForm.lianxidianhua" class="input" type="text" placeholder="联系电话">
			   </div>
			 </div> -->
			<el-form-item label="联系电话" class="input" v-if="tableName=='tenant'">
			  <el-input v-model="ruleForm.lianxidianhua" autocomplete="off" placeholder="联系电话" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='tenant'" class="input-group">
			   <div class="label">身份证</div>
			   <div class="input-container">
			     <input v-model="ruleForm.shenfenzheng" class="input" type="text" placeholder="身份证">
			   </div>
			 </div> -->
			<el-form-item label="身份证" class="input" v-if="tableName=='tenant'">
			  <el-input v-model="ruleForm.shenfenzheng" autocomplete="off" placeholder="身份证" type="text" />
			</el-form-item>
																								<!-- <div v-if="tableName=='landlord'" class="input-group">
			   <div class="label">房主账号</div>
			   <div class="input-container">
			     <input v-model="ruleForm.landlordzhanghao" class="input" type="text" placeholder="房主账号">
			   </div>
			 </div> -->
			<el-form-item label="房主账号" class="input" v-if="tableName=='landlord'">
			  <el-input v-model="ruleForm.landlordzhanghao" autocomplete="off" placeholder="房主账号" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='landlord'" class="input-group">
			   <div class="label">密码</div>
			   <div class="input-container">
			     <input v-model="ruleForm.mima" class="input" type="text" placeholder="密码">
			   </div>
			 </div> -->
			<el-form-item label="密码" class="input" v-if="tableName=='landlord'">
			  <el-input v-model="ruleForm.mima" autocomplete="off" placeholder="密码" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='landlord'" class="input-group">
			   <div class="label">房主姓名</div>
			   <div class="input-container">
			     <input v-model="ruleForm.landlordxingming" class="input" type="text" placeholder="房主姓名">
			   </div>
			 </div> -->
			<el-form-item label="房主姓名" class="input" v-if="tableName=='landlord'">
			  <el-input v-model="ruleForm.landlordxingming" autocomplete="off" placeholder="房主姓名" type="text" />
			</el-form-item>
																														<!-- <div v-if="tableName=='landlord'" class="input-group">
			   <div class="label">手机</div>
			   <div class="input-container">
			     <input v-model="ruleForm.shouji" class="input" type="text" placeholder="手机">
			   </div>
			 </div> -->
			<el-form-item label="手机" class="input" v-if="tableName=='landlord'">
			  <el-input v-model="ruleForm.shouji" autocomplete="off" placeholder="手机" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='landlord'" class="input-group">
			   <div class="label">身份证</div>
			   <div class="input-container">
			     <input v-model="ruleForm.shenfenzheng" class="input" type="text" placeholder="身份证">
			   </div>
			 </div> -->
			<el-form-item label="身份证" class="input" v-if="tableName=='landlord'">
			  <el-input v-model="ruleForm.shenfenzheng" autocomplete="off" placeholder="身份证" type="text" />
			</el-form-item>
																																																																																													<div class="action-group">
																																																																																													  <el-button class="btn btn-back" @click="goLogin()">返回登录</el-button>
																																																																																													  <el-button class="btn" type="primary" @click="login()">注册</el-button>
																																																																																													</div>
		</el-form>
      </div>
      <!-- <div class="nk-navigation">
        <a href="#">
          <div @click="login()">注册</div>
        </a>
      </div> -->
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
              },
      tableName:"",
      rules: {}
    };
  },
  mounted(){
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 注册
    login() {
                              if((!this.ruleForm.tenantming) && `tenant` == this.tableName){
        this.$message.error(`用户名不能为空`);
        return
      }
                                                                  if((!this.ruleForm.mima) && `tenant` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
                                                                                                                                                                                                                                                                                                                  if(`tenant` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
                                                                              if(`tenant` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
                                                      if((!this.ruleForm.landlordzhanghao) && `landlord` == this.tableName){
        this.$message.error(`房主账号不能为空`);
        return
      }
                                                                  if((!this.ruleForm.mima) && `landlord` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
                                                                  if((!this.ruleForm.landlordxingming) && `landlord` == this.tableName){
        this.$message.error(`房主姓名不能为空`);
        return
      }
                                                                                                                                                                                                      if(`landlord` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
                                                                              if(`landlord` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
                                                                                                                                                                                                this.$http({
        url: `${this.tableName}/register`,
        method: "post",
        data:this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "注册成功",
            type: "success",
            duration: 1500,
            onClose: () => {
              this.$router.replace({ path: "/login" });
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    goLogin() {
      this.$router.replace({ path: "/login" });
    }
  }
};
</script>
<style lang="scss" scoped>
	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.h1 {
		margin-top: 10px;
	}

	body {
		padding: 0;
		margin: 0;
	}

	// .container {
 //    min-height: 100vh;
 //    text-align: center;
 //    // background-color: #00c292;
 //    padding-top: 20vh;
 //    background-image: url(../assets/img/bg.jpg);
 //    background-size: 100% 100%;
 //    opacity: 0.9;
 //  }

	// .login-form:before {
	// 	vertical-align: middle;
	// 	display: inline-block;
	// }

	// .login-form {
	// 	max-width: 500px;
	// 	padding: 20px 0;
	// 	width: 80%;
	// 	position: relative;
	// 	margin: 0 auto;

	// 	.label {
	// 		min-width: 60px;
	// 	}

	// 	.input-group {
	// 		max-width: 500px;
	// 		padding: 20px 0;
	// 		width: 80%;
	// 		position: relative;
	// 		margin: 0 auto;
	// 		display: flex;
	// 		align-items: center;

	// 		.input-container {
	// 			display: inline-block;
	// 			width: 100%;
	// 			text-align: left;
	// 			margin-left: 10px;
	// 		}

	// 		.icon {
	// 			width: 30px;
	// 			height: 30px;
	// 		}

	// 		.input {
	// 			position: relative;
	// 			z-index: 2;
	// 			float: left;
	// 			width: 100%;
	// 			margin-bottom: 0;
	// 			box-shadow: none;
	// 			border-top: 0px solid #ccc;
	// 			border-left: 0px solid #ccc;
	// 			border-right: 0px solid #ccc;
	// 			border-bottom: 1px solid #ccc;
	// 			padding: 0px;
	// 			resize: none;
	// 			border-radius: 0px;
	// 			display: block;
	// 			width: 100%;
	// 			height: 34px;
	// 			padding: 6px 12px;
	// 			font-size: 14px;
	// 			line-height: 1.42857143;
	// 			color: #555;
	// 			background-color: #fff;
	// 		}

	// 	}
	// }

	.nk-navigation {
		margin-top: 15px;

		a {
			display: inline-block;
			color: #fff;
			background: rgba(255, 255, 255, .2);
			width: 100px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;
		}

		.icon {
			margin-left: 10px;
			width: 30px;
			height: 30px;
		}
	}

	.register-container {
		margin-top: 10px;

		a {
			display: inline-block;
			color: #fff;
			max-width: 500px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;

			div {
				margin-left: 10px;
			}
		}
	}
	
	.container {
		min-height: 100vh;
		padding: 24px 16px;
		display: flex;
		align-items: center;
		justify-content: center;
		background-image: linear-gradient(135deg, rgba(246, 249, 253, 0.92), rgba(236, 243, 252, 0.88)), url("~@/assets/img/bg.jpg");
		background-position: center center;
		background-size: cover;
		background-repeat: no-repeat;
	
		.login-form {
			width: 520px;
			max-width: 100%;
			max-height: calc(100vh - 48px);
			padding: 32px 28px 28px;
			overflow-y: auto;
			font-size: 14px;
			font-weight: 500;
			box-sizing: border-box;
			
			&.register-card {
				border-radius: 20px;
				background-color: rgba(255,255,255,.94);
				border: 1px solid rgba(148, 163, 184, 0.25);
				box-shadow: 0 20px 40px rgba(15, 23, 42, 0.12);
				backdrop-filter: blur(4px);
			}
			
			.h1 {
				margin: 0 0 18px;
				text-align: center;
				line-height: 1.4;
			    font-size: 28px;
			    color: #1d4d8f;
				font-weight: 700;
			}
				
			.rgs-form {
				display: flex;
				flex-direction: column;
				align-items: stretch;
				
				.input {
					width: 100%;
					margin-bottom: 18px;
					
					::v-deep .el-form-item__label {
						line-height: 40px;
						color: #334155;
						font-size: 14px;
						font-weight: 500;
					}
					
					::v-deep .el-form-item__content {
						width: auto;
					}
					
					::v-deep .el-input,
					::v-deep .el-input__inner {
						width: 100%;
					}
					
					::v-deep .el-input__inner {
						height: 42px;
						color: #1f2937;
						font-size: 14px;
						border-width: 1px;
						border-style: solid;
						border-color: rgba(148, 163, 184, 0.5);
						border-radius: 21px;
						background-color: #fff;
						transition: all .2s ease;
					}
					
					::v-deep .el-input__inner:focus {
						border-color: #409EFF;
						box-shadow: 0 0 0 3px rgba(64, 158, 255, 0.16);
					}
				}
				
				.btn {
					min-width: 120px;
					height: 44px;
					padding: 0 28px;
					color: #fff;
					font-size: 15px;
					font-weight: 600;
					border-width: 1px;
					border-style: solid;
					border-color: #409EFF;
					border-radius: 22px;
					background-color: #409EFF;
					box-shadow: 0 10px 20px rgba(64, 158, 255, 0.24);
				}

				.action-group {
					margin-top: 10px;
					display: flex;
					justify-content: center;
					gap: 12px;
					flex-wrap: wrap;
				}

				.btn-back {
					color: #409EFF;
					border-color: rgba(64, 158, 255, 0.5);
					background-color: rgba(255, 255, 255, 0.96);
					box-shadow: none;
				}
			}
		}
	}

	@media (max-width: 768px) {
		.container {
			padding: 16px;

			.login-form {
				max-height: calc(100vh - 32px);
				padding: 24px 18px 22px;

				.h1 {
					font-size: 24px;
				}

				.rgs-form {
					.action-group {
						gap: 10px;
					}

					.btn {
						flex: 1 1 140px;
					}

					::v-deep .el-form-item__label {
						width: 88px !important;
					}
				}
			}
		}
	}
</style>
