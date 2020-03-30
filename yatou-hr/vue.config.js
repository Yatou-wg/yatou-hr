let proxyObj = {};

proxyObj['/'] = {
    target: 'http://localhost:8080/',
    changeOrigin: true,
    pathRewrite: {
        '^/': ''
    }
}
module.exports = {
    // presets: [
    //     '@vue/cli-plugin-babel/preset'
    // ]
    devServer: {
        host: '127.0.0.1',
        port: 80,
        https: false,
        hotOnly: false,
    },
}