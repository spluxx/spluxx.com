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
              <a>Music Chat</a>  <a class="card-title" href="http://musicchat.live">(Link)</a>
              <p class="card-text"> A chatting app that allows people in the same "room" to listen to the same music simultaneously. </p>
            </div>
            <div class="row center">
              <div class="col-md-6">
                <div class="col-md-12 card">
                  <img class="card-img-top" src="../assets/music_chat_front.png">
                </div>
              </div>

              <div class="col-md-6">
                <div class="col-md-12 card">
                  <img class="card-img-top" src="../assets/music_chat_chat.png">
                </div>
              </div>

            </div>

          </div>
        </div>

        <div class="row center">
          <div class="col-md-6">
            <div class="col-md-12 card">
              <div class="card-body">
                <a>Dynamic Scala</a><a class="card-title" href="https://github.com/spluxx/dynamic-scala">(Github)</a>
                <p class="card-text"> Yet another state control; Loop in a purely functional context. </p>
              </div>
              <img class="card-img-top" src="../assets/dynamic_scala.png">
            </div>
          </div>
          <div class="col-md-6 ml-auto">
            <div class="col-md-12 card">
              <div class="card-body">
                <a>Poke Search</a><a class="card-title" href="http://spluxx.com/poke">(Link)</a>
                <p class="card-text"> Find your pokemon that has the same weight/height as you! </p>
              </div>
              <img class="card-img-top" src="../assets/poke_search.png">
            </div>
          </div>
        </div>

        <div class="row center">
          <div class="col-md-6">
            <div class="col-md-12 card">
              <div class="card-body">
                <a>GameMaker</a><a class="card-title" href="https://github.com/spluxx/gamemaker">(Github)</a>
                <p class="card-text">Game authoring environment for turn-based strategy games</p>
              </div>
              <div class="card-img-top">
                <iframe width="100%" height="500" src="https://www.youtube.com/embed/5OeS4lR2X5s" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
              </div>
            </div>
          </div>
          <div class="col-md-6 ml-auto">
            <div class="col-md-12 card">
              <div class="card-body">
                <a class="card-title">SLogo</a>
                <p class="card-text">Replica of Logo</p>
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
                <a class="card-title">Pika Breakout</a>
                <p class="card-text">A variation of Breakout</p>
              </div>
              <div class="card-img-top">
                <iframe width="100%" height="500" src="https://www.youtube.com/embed/M-UqvpM0Czo" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
              </div>
            </div>
          </div>
          <div class="col-md-6">
          <div class="col-md-12 card">
            <div class="card-body">
              <a class="card-title">Cell Society</a>
              <p class="card-text">Four cellular automata models with real-time adjustable parameters</p>
            </div>
            <div class="card-img-bottom">
              <iframe width="100%" height="500" src="https://www.youtube.com/embed/GMeG-adQeMA" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
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
