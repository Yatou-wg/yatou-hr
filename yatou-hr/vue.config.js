let proxyObj = {};

proxyObj['/'] = {
    target: 'http://localhost:8081/',
    ws: true,
    changeOrigin: true,
    pathRewrite: {
        '^/': ''
    }
}
module.exports = {
    devServer: {
        host: 'localhost',
        port: 8080,
        proxy: proxyObj
    },
}