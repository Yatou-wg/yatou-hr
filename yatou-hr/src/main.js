import Vue from 'vue'
import App from './App.vue'
import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

//引入 项目样式
import '@/assets/css/yatou.css'

//导入自定义的Message
import Message from '@/assets/plugins/message.js'
Vue.use(Message)

//导入NProgress
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'


import {
  parseTime,
} from "@/utils/common";

//全局方法挂载
Vue.prototype.parseTime = parseTime

//全局进度条的配置
NProgress.configure({
  showSpinner: true, //加载微调器设置,默认为true
  //使用缓动（CSS缓动字符串）和速度（以毫秒为单位）调整动画设置。（默认：ease和200）
  easing: 'ease',
  speed: 2000,
  minimum: 0, //更改启动时使用的最小百分比
})

//对路由钩子函数进行设置
//路由进入前
router.beforeEach((to, from, next) => {
  NProgress.start()
  next()
});
//路由进入后
router.afterEach(() => {
  NProgress.done()
  NProgress.remove()
})

Vue.use(ElementUI);

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')