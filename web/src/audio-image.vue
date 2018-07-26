<template>
  <div>
    <img class="poke-image" :src="img_url" @dblclick="togglePlayback">
  </div>
</template>

<script>
  import VueHowler from 'vue-howler'
  export default {
    mixins: [VueHowler],
    props: ['img_url']
  }
</script>

<style>
.poke-image {
  width: 300px;
  height: 300px;
  margin: 30px;
  user-drag: none;
  user-select: none;
  -moz-user-select: none;
  -webkit-user-drag: none;
  -webkit-user-select: none;
  -ms-user-select: none;
}
</style>
