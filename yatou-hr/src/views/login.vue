<template>
  <div class="login">
    <el-form
      ref="loginForm"
      :model="loginForm"
      :rules="loginRules"
      class="login-form"
      label-position="top"
    >
      <h3 class="title">人力资源管理系统</h3>
      <el-form-item prop="username" label="用户名">
        <el-input v-model="loginForm.username" type="text" auto-complete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item prop="password" label="密码">
        <el-input
          v-model="loginForm.password"
          type="password"
          placeholder="密码"
          @keyup.enter.native="handleLogin"
        ></el-input>
      </el-form-item>
      <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px;">记住密码</el-checkbox>
      <el-form-item style="width:100%;">
        <el-button
          :loading="loading"
          size="medium"
          type="primary"
          style="width:100%;"
          @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
      </el-form-item>
    </el-form>
    <!-- 底部 -->
    <div class="el-login-footer">
      <span>Copyright © 2019-2020 waggag.vip All Rights Reserved.</span>
    </div>
  </div>
</template>

<script>
import { Login } from "@/api/login.js";

export default {
  data() {
    return {
      loginForm: {
        username: "waggag",
        password: "123456",
        rememberMe: false
      },
      loginRules: {
        username: [
          { required: true, trigger: "blur", message: "用户名不能为空" }
        ],
        password: [{ required: true, trigger: "blur", message: "密码不能为空" }]
      },
      loading: false,
      redirect: undefined
    };
  },
  methods: {
    handleLogin(){
       this.$refs.loginForm.validate(valid => {
        // 校验通过，正常登录，更改登陆状态
        if (valid) {
          this.loading = true;
          Login(this.loginForm.username, this.loginForm.password).then(response => {
              console.log(response)
              if (response.status === 200) {
                this.loading = false;
                this.$router.push({ path: this.redirect || "/" });
                this.msgSuccess("登录成功");
                localStorage.setItem('token', response.data);
              }else{
                this.loading = false;
                this.msgInfo("用户名或密码输入错误，请重新输入！")
              }
            })
            .catch(error => {
              this.msgError("用户名或密码输入错误，请重新输入！");
              this.$router.push({ path: this.redirect || '/' });
              localStorage.setItem('token', 'response.data');
              this.msgSuccess("登录成功");
              this.loading = false;
            });
        }
      });
    }
  }
};
</script>

<style lang="scss" scope>
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("../assets/img/login.jpg");
  background-size: cover;
  .title {
    margin: 0px auto 30px auto;
    text-align: center;
    color: #707070;
  }
  .login-form {
    border-radius: 6px;
    background: #ffffff;
    width: 400px;
    padding: 25px 25px 5px 25px;
    .el-input {
      height: 38px;
      input {
        height: 38px;
      }
    }
  }

  .el-login-footer {
    height: 40px;
    line-height: 40px;
    position: fixed;
    bottom: 0;
    width: 100%;
    text-align: center;
    color: #fff;
    font-family: Arial;
    font-size: 12px;
    letter-spacing: 1px;
  }
}
</style>