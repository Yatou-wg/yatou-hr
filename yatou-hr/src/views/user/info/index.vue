<template>
  <div>
    info
    <el-button @click="dianji()">dianji1</el-button>
  </div>
</template>

<script>
import { listUser } from "@/api/user.js";
export default {
  data() {
    return {

    }
  },
  components: {},
  watch: {},
  mounted() {},
  methods: {
    dianji(){
      listUser().then(response => {
          console.log(response);
      })
    }
  }
}
</script>

<style scoped lang="scss">

</style>
