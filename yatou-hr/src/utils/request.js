import axios from 'axios'

// 创建axios实例
const service = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    baseURL: "http://localhost:80/",
    // 超时
    timeout: 10000,
    headers: {
        'Content-Type': "application/json;charset=utf-8",
    }
})

export default service