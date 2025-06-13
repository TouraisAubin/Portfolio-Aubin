
<html>
<head>
	<title>Inscription</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="w3-padding-48">

<!-- Barre de Navigation -->
	<div class="w3-top">
		<div class="w3-bar w3-light-grey w3-border w3-large">
			<button class="w3-button w3-indigo w3-xlarge w3-right w3-card fa fa-home" onclick="openRightMenu()"></button>
		    <a class="w3-bar-item w3-indigo">Inscription</a>

				<div class= "w3-sidebar w3-bar-block w3-animate-right" style="display:none;right:0;" id="rightMenu">
		  			<button onclick="closeRightMenu()" class="w3-bar-item w3-button w3-indigo w3-large w3-right">Fermer &times;</button>
		  			<a href="Connexion.php" class="w3-bar-item w3-button">Se connecter</a>
					  <a href="../ProgPHP/deconnexion.php" class="w3-bar-item w3-button">Se deconnecter</a>
				</div>
		</div>
	</div>

	<div class="w3-panel w3-indigo w3-round-xlarge w3-padding-16 w3-center w3-margin w3-card-4">

		<div class="w3-panel w3-white w3-round-xlarge w3-padding-16 w3-center w3-margin">

			<form method="post" action="../ProgPHP/actioninscrire.php">

<!-- Inscritpion -->
  <div class="w3-padding-64 w3-content w3-text-grey" id="contact">

    <h2 class="w3-text-indigo">INSCRIPTION</h2>
    <hr style="width:200px" class="w3-opacity">

   <!-- <form action="../ProgPHP/action_page.php" target="_blank"> -->

      <p><input class="w3-input w3-padding-16 w3-text-black " type="text" placeholder="Prenom" required name="firstname"></p>
      <p><input class="w3-input w3-padding-16 w3-text-black " type="text" placeholder="Nom" required name="surname"></p>
      <p><input class="w3-input w3-padding-16 w3-text-black" type="text" placeholder="Login" required name="login"></p>
      <p><input class="w3-input w3-padding-16 w3-text-black "type="text" placeholder="Adresse mail" required name="email"></p>
      <p><input class="w3-input w3-padding-16 w3-text-black " type="password" placeholder="Mot de Passe" required name="mdp"></p>
      <p>
        <button class="w3-button w3-indigo w3-round-xlarge w3-padding-large w3-margin-top" type="submit"><i class="fa fa-paper-plane"></i> S'INSCRIRE </button>
      </p>

    <!-- </form> -->

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


</body>
</html>