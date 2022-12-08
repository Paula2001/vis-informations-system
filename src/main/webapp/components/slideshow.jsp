<div class="main-container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img class="image" src="images/1stslide.jpg" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img class="image" src="images/2ndslide.jpg" alt="Chicago" style="width:100%;">
      </div>

      <div class="item">
        <img class="image" src="images/3rdslide.jpg" alt="New york" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<style>
  .main-container{
    margin: 2%;
    max-height: 700px;
  }
  .main-container * {
    max-height: 700px;
  }
  .item {
    height: 60%;
  }
</style>