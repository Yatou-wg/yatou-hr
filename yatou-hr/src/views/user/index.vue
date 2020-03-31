<template>
  <el-card class="box-card">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>员工资料</el-breadcrumb-item>
      <el-breadcrumb-item>基本资料</el-breadcrumb-item>
    </el-breadcrumb>
    <el-row class="serarchRow">
      <el-col>
        <el-input placeholder="请输入内容" v-model="queryParams.username" class="inputSerach">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
        <el-button type="success">添加用户</el-button>
      </el-col>
    </el-row>
    <el-table :data="userList" style="width: 100%">
    <el-table-column type="index" label="#" width="60"></el-table-column>
      <el-table-column prop="username" label="用户名" width="180"></el-table-column>
      <el-table-column prop="realname" label="真实姓名" width="180"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column prop="address" label="操作"></el-table-column>
    </el-table>
  </el-card>
</template>

<script>
import { listUser } from '@/api/user.js'
export default {
  data() {
    return {
      //查询参数
      queryParams: {
        username: '',
      },
      userList: [],
    }
  },
  mounted() {
      this.getUserList()
  },
  methods: {
      getUserList(){
          listUser().then(response => {
              if(response.status === 200){
                  console.log(response)
                  this.userList = response.data.content
              }
          })
      }
  }
}
</script>

<style lang="scss" scoped>
.box-card {
  height: 100%;
  .serarchRow {
    margin-top: 20px;
    .inputSerach {
      width: 300px;
    }
  }
}
</style>
