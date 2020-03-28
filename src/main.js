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

Vue.use(ElementUI);

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
