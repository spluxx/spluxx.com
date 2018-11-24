<template>
  <div id="app">
    <div id="header">
      <img id="logo" src="../assets/logo.png">
      <div id="logo-text">
        <h1> PokeSearch </h1>
        <p style="display: inline"> Double-click for sound </p>
        <a href="https://github.com/spluxx/spluxx.com">(Github)</a>
      </div>
    </div>

    <div id="body">

      <div id="controls">
        <div id="sliders">
          <vue-slider class="slider" v-model="logWeight" :width="sliderWidth"
                      :min="-1" :max="3" :interval="0.00001" :clickable="false"
                      :formatter="weightStr" @drag-end="updateWeight"/>
          <vue-slider class="slider" v-model="logHeight" :width="sliderWidth"
                      :min="-1" :max="1.5" :interval="0.00001" :clickable="false"
                      :formatter="heightStr" @drag-end="updateHeight"/>
        </div>
      </div>

      <div id="flickity-slave-wrapper">
        <flickity v-if="pokeData.length > 0" class="flickity-slave" :options="flickitySlaveOptions">
          <div class="carousel-cell-slave" v-for="poke in pokeData">
            <img class="poke-image-slave" v-bind:src="poke.img_url">
          </div>
        </flickity>
      </div>

      <div id="flickity-wrapper">
        <flickity v-if="pokeData.length > 0" class="flickity" :options="flickityOptions"
                  v-on:init="registerMainFlickity">
          <div class="carousel-cell" v-for="poke in pokeData">
            <audio-image :sources="[poke.cry_url]" :img_url="poke.img_url"></audio-image>
            <p> {{poke.name.replace(/^\w/, c => c.toUpperCase())}}, {{poke.weight}}kg, {{poke.height}}m </p>
            <p> {{poke.description}} </p>
          </div>
        </flickity>
      </div>
    </div>
  </div>
</template>

<script>
  import vueSlider from 'vue-slider-component';
  import Switches from 'vue-switches';
  import Flickity from 'vue-flickity';
  import AudioImage from './AudioImage.vue';
  import 'flickity-as-nav-for';
  import * as DataFetcher from '../dataFetcher';
  import $ from 'jquery';

  export default {
    name: 'PokePage',
    components: {
      vueSlider,
      Flickity,
      Switches,
      AudioImage
    },
    data () {
      return {
        adjustWeight: true,
        switchTheme: "bootstrap",
        switchColor: "info",
        sliderWidth: Math.min($(window).width() * 0.9, 500),
        mainFlickity : null,
        flickityOptions: {
          initialIndex: 0,
          prevNextButtons: false,
          pageDots: false,
          wrapAround: true,
          adaptiveHeight: true
        },
        flickitySlaveOptions: {
          asNavFor: ".flickity",
          prevNextButtons: false,
          pageDots: false,
          draggable: false
        },
        logWeight: 1,
        logHeight: 1,
        pokeData: []
      }
    },
    methods: {
      weightStr(val) {
        return `Weight: ${Math.round(Math.pow(10, val)*10)/10}kg`;
      },
      heightStr(val) {
        return `Height: ${Math.round(Math.pow(10, val)*10)/10}m`;
      },
      registerMainFlickity(that) {
        this.mainFlickity = that;
      },
      updateWeight() {
        this.pokeData = [];
        DataFetcher.pokemonsWithWeight(Math.pow(10, this.logWeight))
          .then(res => {
            this.pokeData = res.data.pokemonsWithWeight;
            this.adjustControllers(0);
          })
      },
      updateHeight() {
        this.pokeData = [];
        DataFetcher.pokemonsWithHeight(Math.pow(10, this.logHeight))
          .then(res => {
            this.pokeData = res.data.pokemonsWithHeight;
            this.adjustControllers(0);
          })
      },
      adjustControllers(idx) {
        this.logWeight = Math.log10(this.pokeData[idx].weight);
        this.logHeight = Math.log10(this.pokeData[idx].height);
      }
    },
    watch: {
      "mainFlickity.selectedIndex": function(newVal, oldVal) {
        this.adjustControllers(newVal);
      }
    },
    mounted() {
      this.updateWeight();
    }
  }
</script>

<style scoped>
  html body {
    margin: 0;
  }

  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin: 5%;
    width: 90%;
    height: 100%;
  }

  #header {
    display: inline-flex;
    justify-content: center;
    align-items: center;
    height: auto;
    width: 100%;
    padding-top: 30px;
  }

  #logo {
    width: 10%;
    height: auto;
    margin-right: 10px;
  }

  #logo-text h1 {
    font-weight: normal;
    font-size: 48px;
    margin-top: 0;
    margin-bottom: 0;
  }

  #logo-text p {
    margin-top: -10px;
    margin-bottom: 0;
    text-align: left;
  }

  #body {
    display: flex;
    flex-flow: column nowrap;
    justify-content: space-around;
    align-content: center;
    align-items: center;
    width: 100%;
  }

  #controls {
    display: flex;
    flex-flow: row nowrap;
    justify-content: space-between;
    align-items: center;
    margin-top: 10px;
  }

  .slider {
    margin-top: 40px;
  }

  #flickity-wrapper {
    border: grey solid 1pt;
    width: 90%;
    height: 100%;
  }

  .carousel-cell {
    background-color: lightgrey;
    width: 100%;
  }

  .carousel-cell p {
    margin-top: 0;
    font-weight: bold;
    padding-left: 5%;
    padding-right: 5%;
  }

  #flickity-slave-wrapper {
    border: grey solid 1pt;
    border-bottom: none;
    margin-top: 5%;
    margin-bottom: 0;
    width: 90%;
  }

  .flickity-slave {
    width: 100%;
  }

  .poke-image-slave {
    opacity: 0.6;
    margin-top: 5px;
    width: 90px;
    height: 90px;
    user-drag: none;
    user-select: none;
    -moz-user-select: none;
    -webkit-user-drag: none;
    -webkit-user-select: none;
    -ms-user-select: none;
  }

  @media screen and (min-width: 720px) {
    #app {
      width: 600px;
      margin: auto;
    }

    #flickity-wrapper {
      margin-top: 10px;
      margin-bottom: 0;
      order: 1;
    }

    #flickity-slave-wrapper {
      margin-top: 0;
      margin-bottom: 0;
      border-top: none;
      border-bottom: grey solid 1pt;
      order: 2;
    }
  }

</style>
