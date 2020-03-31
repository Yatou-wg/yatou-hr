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
        host: 'localhost',
        port: 80,
        proxy: proxyObj,
    },
}