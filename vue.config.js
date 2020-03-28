let proxyObj = {};

proxyObj['/'] = {
    ws: false,
    target: 'http://localhost:8080',
    changeOrigin: true,
    pathRewrite: {
        '^/': ''
    }
}
module.exports = {
    // presets: [
    //     '@vue/cli-plugin-babel/preset'
    // ]
}
