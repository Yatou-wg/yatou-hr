<template>
  <el-container class="container">
    <el-header class="header">
      <div class="brand">丫头</div>
      <span class="title">人力资源管理系统</span>
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
      <el-aside width="200px" class="aside">
        <el-menu class="el-menu-vertical" :unique-opened="true" :router="true">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">导航一</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="user">选项1</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main class="main">
        <el-breadcrumb>
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
           <el-breadcrumb-item>活动管理</el-breadcrumb-item>
        </el-breadcrumb>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import { logout } from "@/api/login.js";
import { listUser } from "@/api/user.js";
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
  methods: {
    commandHandler(cmd) {
      if (cmd === "logout") {
        this.$confirm("此操作将注销登录, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
            localStorage.clear()
            logout().then(response => {
              if(response.data.status === 200){
                  this.msgSuccess("注销成功")
                  this.$router.replace("/login")
              }
            })
          })
          .catch(() => {
            this.msgInfo("已取消操作")
          });
      }else if(cmd === "userinfo") {
        this.$router.push({path:'/user/info'})
      }else if(cmd === "setting"){
        listUser.then(response => {
          console.log(response);
        })
      }
    }
  }
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
    .brand {
      font-size: 30px;
      font-family: 华文行楷;
      color: #3f3f3f;
    }
    .title {
      text-align: center;
      font-size: 25px;
      font-family: 华文楷体;
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
  .aside {
    background-color: white;
    .el-menu-vertical:not(.el-menu--collapse) {
      width: 200px;
      min-height: 100%;
    }
  }
  .main {
    background-color: #fafafa;
    height: 100%;
  }
}
</style>
