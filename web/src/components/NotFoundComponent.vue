<template>
   <div id="app">
     <h1> OOPS </h1>
     <h2> You're on a wrong page ...</h2>
     <img src="../assets/error.svg" v-on:click="routeToHome">
   </div>
</template>

<script>
  export default {
    name: "NotFoundComponent",
    methods: {
      routeToHome() {
        this.$router.push('/')
      }
    }
  }
</script>

<style>
  h1 {
    font-weight: normal;
    font-size: 72pt;
  }
</style>
