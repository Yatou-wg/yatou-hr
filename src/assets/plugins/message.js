const Message = {}

Message.install = (Vue) => {

  Vue.prototype.msgSuccess = function (msg) {
    this.$message({
      showClose: true,
      message: msg,
      type: "success",
      duration: 1000,
    });
  }

  Vue.prototype.msgWarning = function (msg) {
    this.$message({
      showClose: true,
      message: msg,
      type: 'warning'
    });
  }

  Vue.prototype.msgError = function (msg) {
    this.$message({
      showClose: true,
      message: msg,
      type: "error",
      duration: 1000,
    });
  }

  Vue.prototype.msgInfo = function (msg) {
    this.$message({
      showClose: true,
      message: msg,
      center: true,
      duration: 1000,
    })
  }

}

export default Message
