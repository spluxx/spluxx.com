<template>
  <div id="app">
    <transition name="slide-fade">
      <div v-show="password !== pw" class="container bump-top">
        <div class="row center justify-content-center">
          <div class="input-group col-4">
            <input type="password" class="form-control bg-light"
                   placeholder="과연 맞출 수 있을까?" v-model="password">
          </div>
        </div>
      </div>
    </transition>

    <transition name="slide-fade">
      <div v-if="password === pw" class="container">
        <div class="row center justify-content-center">
          <div class="card col-7 letter-wrapper bg-secondary">
            <div class="row center justify-content-center boo">
              <div class="card col-12 text-white bg-dark">
                <div class="card-body">
                  <h1> {{ header }} </h1>
                </div>
              </div>
            </div>
            <div class="row center justify-content-center boo">
              <div class="card col-12 text-white bg-dark">
                <div class="card-body letter-body">
                  <p> {{ paragraph1 }} </p>
                </div>
              </div>
            </div>
            <div class="row center justify-content-center boo">
              <div class="card col-12 text-white bg-dark">
                <div class="card-body letter-body">
                  <p> {{ paragraph2 }} </p>
                </div>
              </div>
            </div>
            <div class="row center justify-content-center boo">
              <div class="card col-12 text-white bg-dark">
                <div class="card-body letter-body">
                  <p> {{ paragraph3 }} </p>
                </div>
              </div>
            </div>
            <div class="row center justify-content-center boo">
              <div class="card col-12 text-white bg-dark">
                <div class="card-body">
                  <h3> {{ footer }} </h3>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
  import rawLetter from '../secret_assets/letter300.txt';
  import letterPW from '../secret_assets/letterPW.txt';

  export default {
    name: "LetterPage",
    data() {
      return {
        pw: "123456", //
        password: "",
        header: "",
        paragraph1: "",
        paragraph2: "",
        paragraph3: "",
        footer: ""
      }
    },
    mounted() {
      const s = rawLetter.split("-----");
      this.header = s[0];
      this.paragraph1 = s[1];
      this.paragraph2 = s[2];
      this.paragraph3 = s[3];
      this.footer = s[4];

      this.pw = letterPW.trim();
      console.log(letterPW.trim());
    }
  }
</script>

<style scoped>
  #app {
    background-color: #343a40;
    height: 100%;
  }
  .card {
    margin-top: 5px;
    margin-bottom: 5px;
  }
  h1 {
    font-weight: normal;
    font-size: 36pt;
  }

  .letter-body {
    text-align: left;
  }

  .letter-wrapper {
    margin-top: 40px;
    padding-top: 10px;
    padding-bottom: 10px;
    height: auto;
  }

  .boo {
    padding-left: 15px;
    padding-right: 15px;
  }

  .bump-top {
    padding-top: 40px;
  }

  .slide-fade-enter-active {
    transition: opacity 3s;
  }
  .slide-fade-leave-active {
    transition: all 1s cubic-bezier(1.0, 0.5, 0.8, 1.0);
  }

  .slide-fade-enter, .slide-fade-leave-to
    /* .slide-fade-leave-active below version 2.1.8 */ {
    transform: translateY(-100px);
    opacity: 0;
  }
</style>
