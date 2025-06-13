
<html>
<head>
	<title>Accueil</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
		.mySlides {display:none;}
	</style>
</head>

<body>
<div class="w3-padding-48">

<!-- Barre de Navigation -->
	<div class="w3-top">
		<div class="w3-bar w3-light-grey w3-border w3-large">
			<button class="w3-button w3-indigo w3-xlarge w3-right w3-card fa fa-home" onclick="openRightMenu()"></button>
		    <a class="w3-bar-item w3-indigo">Accueil</a>
		    <a href="achat.php" class="w3-button w3-margin-left w3-bar-item w3-blue w3-bolt">Achat</a>
		    <a class="w3-button w3-margin-left w3-bar-item w3-blue">Vente</a>

				
				<div class= "w3-sidebar w3-bar-block w3-animate-right" style="display:none;right:0;" id="rightMenu">
		  			  <button onclick="closeRightMenu()" class="w3-bar-item w3-button w3-indigo w3-large w3-right">Fermer &times;</button>
		  			  <a href="Connexion.php" class="w3-bar-item w3-button">Se connecter</a>
					  <a href="../ProgPHP/deconnexion.php" class="w3-bar-item w3-button">Se deconnecter</a>
				</div>
		</div>
	</div>

	<div class="w3-panel w3-indigo w3-round-xlarge w3-padding-16 w3-center w3-margin w3-card-4">

		<div class="w3-panel w3-white w3-round-xlarge w3-padding-16 w3-center w3-margin">

			<form method="post" action="ActionLoader.php">


<!-- Menu accueil -->

			<div class="w3-content w3-section w3-center" style="max-width:500px">
			  <img class="mySlides" src="../Photo/iphone5.jpg" style="width:100%">
			  <img class="mySlides" src="../Photo/fairphone2.jpg" style="width:97%">
			  <img class="mySlides" src="../Photo/Samsung.jpg" style="width:77%">
			  <img class="mySlides" src="../Photo/pearPhone.jpg" style="width:100%">
			</div>

			</form>

		</div>

	</div>

</div>



<script>
/*Script pour la nav barre du profil */
function openRightMenu() {
  document.getElementById("rightMenu").style.display = "block";
}

function closeRightMenu() {
  document.getElementById("rightMenu").style.display = "none";
}
</script>

<script>
/* Script pour un menu slide automatique */
var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
</body>
</html>