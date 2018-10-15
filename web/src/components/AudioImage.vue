<template>
  <div >
    <img class="poke-image" :src="img_url" @dblclick="togglePlayback" @load="bam">
  </div>
</template>

<script>
  import VueHowler from 'vue-howler'
  export default {
    name: 'AudioImage',
    mixins: [VueHowler],
    props: ['img_url'],
    data() {
      return {
        showImg: false
      }
    },
    methods: {
      bam() {
        this.showImg = true;
      }
    }
  }
</script>

<style>
.poke-image {
  margin-top: 10px;
  width: 250px;
  height: 250px;
  user-drag: none;
  user-select: none;
  -moz-user-select: none;
  -webkit-user-drag: none;
  -webkit-user-select: none;
  -ms-user-select: none;
}

@media screen and (min-width: 720px) {
  .poke-image {
    width: 300px;
    height: 300px;
  }
}
</style>
