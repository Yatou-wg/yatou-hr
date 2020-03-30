1、安装ElementUI
    npm i element-ui -S
2、在Vue中使用SCSS
    npm install node-sass --save-dev
    npm install sass-loader --save-dev
3、安装axios
    npm install axios   
4、安装Nprogress
    npm install --save nprogress
5、Vue配置代理
    let proxyObj = {};

    proxyObj['/'] = {
        target: 'http://127.0.0.1:8080/',
        ws: true,
        changeOrigin: true,
        pathRewrite: {
            '^/': ''
        }
    }
    module.exports = {
        devServer: {
            host: '127.0.0.1',
            port: 80,
            proxy: proxyObj
        },
    }
6、记录错误 错误的配置axios导致无法跨域