import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/login.vue'
import Home from '@/views/home.vue'
import Index from '@/views/index.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'index',
    component: Home,
    children: [
      {
        path: '/',
        name: 'index',
        component: Index
      },
      {
        path: '/user/center',
        name: '个人中心',
        component: resolve => require(['../views/user/center/index.vue'], resolve),
      },
      {
        path: '/user',
        name: '用户信息',
        component: resolve => require(['../views/user/index.vue'], resolve),
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  //错误路径重定向到首页
  {
    path: '*',
    redirect: '/'
  }
]

const router = new VueRouter({
  // mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
