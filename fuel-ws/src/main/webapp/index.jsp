<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" media="screen" />
<link rel="stylesheet" href="css/flexigrid.css" media="screen" />
<link rel="stylesheet" href="css/fuel.css" media="screen" />
<style type="text/css">
	body {
		padding-top: 60px;
		padding-bottom: 40px;
	}
</style>
</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="javascript:location.reload()"><img src="img/Logo-softcom-mini.png" style="height: 25px; margin-right: 20px" />Fuel</a>
        </div>
      </div>
    </div>

    <div class="container">
    	
    	<div id="loading-header" class="hero-unit">
	        <h1>Bienvenue sur Fuel</h1>
	        <p>Veuillez patienter pendant le chargement des données...</p>
      	</div>
      	
      	<div id="loading-content" class="container">
      		<center><img src="img/ajax-loader.gif" /></center>
      	</div>
      	
      	<div id="result-content" class="container">
      		<table id="flexme" style="display: none"></table>
      	</div>
      	
      	<hr>
      	<footer>
	        <p>&copy; Softcom Technologies SA 2012</p>
	    </footer>
    </div>
</body>
<!-- Scripts at the end to optimize page loading. -->
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/jquery.dateFormat-1.0.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/flexigrid.js"></script>
<script type="text/javascript" src="js/fuel.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		Fuel.init();
	})
</script>
</html>
