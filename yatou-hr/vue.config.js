let proxyObj = {};

proxyObj['/'] = {
    target: 'http://localhost:8080/',
    ws: true,
    changeOrigin: true,
    pathRewrite: {
        '^/': ''
    }
}
module.exports = {
    devServer: {
        /* 自动打开浏览器 */
        open: true,
        /* 设置为0.0.0.0则所有的地址均能访问 */
        host: 'localhost',
        port: 80,
        disableHostCheck: true, //部署到服务器访问
        proxy: proxyObj,
    },
}