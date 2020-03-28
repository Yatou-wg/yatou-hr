<template>
  <el-container class="container">
    <el-header class="header">
      <div class="title">丫头</div>
      <div>
        <el-dropdown class="userInfo" @command="commandHandler" trigger="click">
          <span class="el-dropdown-link">
            <span>系统管理员</span>
            <el-avatar src="https://q1.qlogo.cn/g?b=qq&s=100&nk=1659039054" class="avatar"></el-avatar>
          </span>

          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="userinfo">个人中心</el-dropdown-item>
            <el-dropdown-item command="setting">设置</el-dropdown-item>
            <el-dropdown-item command="logout" divided>注销登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px" class="aside">aside</el-aside>
      <el-main class="main">main</el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data() {
    return {};
  },
  beforeCreate() {
    //获取用户Token
    const token = localStorage.getItem("token");
    if (!token) {
      //如果没有Token,跳转登录
      this.$router.push({ path: "/login" });
    }
  },
  methods: {}
};
</script>

<style scoped lang="scss">
.container {
  height: 100%;
  .header {
    background-color: #e8e7e3;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0px 15px;
    box-sizing: border-box;
    .title {
      font-size: 30px;
      font-family: 华文行楷;
      color: #3f3f3f;
    }
    .userInfo {
      cursor: pointer;
      .el-dropdown-link {
        display: flex;
        align-items: center;
      }
      .avatar {
        margin-left: 8px;
      }
    }
  }
}
.aside {
  background-color: white;
}
.main {
  background-color: white;
  height: 100%;
}
</style>
