<template>
  <div id="app">
    <div id="header">
      <hr>
        <h1> Projects </h1>
      <hr>
    </div>
    <div id="body">
      <div class="container">
        <div class="row center">
          <div class="col-md-12 card">
            <div class="card-body">
              <a class="card-title" href="https://github.com/spluxx/music_chat">Music Chat</a>
              <p class="card-text"></p>
            </div>
            <div class="row center">

              <div class="col-sm-11 card ml-auto mr-auto">
                <img class="card-img-top" src="../assets/music_chat_chatting.png">
              </div>

              <div class="col-md-6">
                <div class="col-md-12 card">
                  <img class="card-img-top" src="../assets/music_chat_login.png">
                </div>
              </div>

              <div class="col-md-6">
                <div class="col-md-12 card">
                  <img class="card-img-top" src="../assets/music_chat_login_fail.png">
                </div>
              </div>

            </div>

          </div>
        </div>

        <div class="row center">
          <div class="col-md-6">
            <div class="col-md-12 card">
              <div class="card-body">
                <a class="card-title" href="https://github.com/spluxx/dynamic-scala">Dynamic Scala</a>
                <p class="card-text"></p>
              </div>
              <img class="card-img-top" src="../assets/dynamic_scala.png">
            </div>
          </div>
          <div class="col-md-6 ml-auto">
            <div class="col-md-12 card">
              <div class="card-body">
                <a class="card-title" href="http://spluxx.com/poke">Poke Search</a>
                <p class="card-text"></p>
              </div>
              <img class="card-img-top" src="../assets/poke_search.png">
            </div>
          </div>
        </div>

        <div class="row center">
          <div class="col-md-6">
            <div class="col-md-12 card">
              <div class="card-body">
                <h5 class="card-title">Cell Society</h5>
                <p class="card-text"></p>
              </div>
              <div class="card-img-bottom">
                <iframe width="100%" height="500" src="https://www.youtube.com/embed/GMeG-adQeMA" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
              </div>
            </div>
          </div>
          <div class="col-md-6 ml-auto">
            <div class="col-md-12 card">
              <div class="card-body">
                <h5 class="card-title">SLogo</h5>
                <p class="card-text"></p>
              </div>
              <div class="card-img-top">
                <iframe width="100%" height="500" src="https://www.youtube.com/embed/Kf3CCZWIkTg" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
              </div>
            </div>
          </div>
        </div>

        <div class="row center">
          <div class="col-md-6">
            <div class="col-md-12 card">
              <div class="card-body">
                <h5 class="card-title">Pika Breakout</h5>
                <p class="card-text"></p>
              </div>
              <div class="card-img-top">
                <iframe width="100%" height="500" src="https://www.youtube.com/embed/M-UqvpM0Czo" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "PortfolioPage"
  }
</script>

<style scoped>
  h1 {
    font-size: 36pt;
    margin: 15px;
    font-weight: normal;
  }

  hr {
    border: none;
    height: 3px;
    background-color: #333; /* Modern Browsers */
  }

  #header {
    width: 80%;
    margin-left: auto;
    margin-right: auto;
    padding: 20px;
  }

  .card {
    padding: 5px;
    margin-bottom: 5px;
  }

  .row {
    margin-bottom: 20px;
  }

  a {
    color: #42b983;
    font-size: 20pt;
  }
</style>
