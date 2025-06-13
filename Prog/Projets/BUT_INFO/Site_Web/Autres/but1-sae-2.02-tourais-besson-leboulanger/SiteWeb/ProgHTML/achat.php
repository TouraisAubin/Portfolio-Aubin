<html>
<head>
  <title>Achat</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<!-- Barre de Navigation -->
  <div class="w3-top">
    <div class="w3-bar w3-light-grey w3-border w3-large">
      <button class="w3-button w3-indigo w3-xlarge w3-right w3-card fa fa-home" onclick="openRightMenu()"></button>
        <a href="Accueil.php" class="w3-button w3-margin-left w3-bar-item w3-indigo">Accueil</a>
        
        <div class= "w3-sidebar w3-bar-block w3-animate-right" style="display:none;right:0;" id="rightMenu">
              <button onclick="closeRightMenu()" class="w3-bar-item w3-button w3-indigo w3-large w3-right">Fermer &times;</button>
              <a href="Connexion.php" class="w3-bar-item w3-button">Se connecter</a>
            <a href="../ProgPHP/deconnexion.php" class="w3-bar-item w3-button">Se deconnecter</a>
        </div>
    </div>
  </div>

<!-- Container avec le profil du client -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    

  <div class="w3-row">

    <div class="w3-col m4">

      <div class="w3-card w3-round w3-indigo w3-margin">
        <div class="w3-container w3-margin w3-text-black">
          <form class = "w3-margin" name="Produit" method="post" action="">
                <h4 class = "w3-center">Type de Produit :</h4>
                <hr>
                <div class= "w3-">
                  <input name="Iphone 5" type="checkbox" id="1" value="Oui"> Iphone 5
                  <br>
                  <input name="dell latitude 7490" type="checkbox" id="3" value="Oui"> Samsung
                  <br>
                  <input name="Fairphone 2" type="checkbox" id="2" value="Oui"> Fairphone 2
                  <br>
                  <input name="pezr phone " type="checkbox" id="4" value="Oui"> pear phone
                  <br><br>
                  <input class="w3-right w3-margin" type="submit" value="Rechercher">
                </div>
          </form>
        </div>
      </div>
      <br>
      
    
    </div>
    

  <div class="w3-col m4 w3-margin">
    
<div class="w3-center ">
    <p class="w3-xxlarge font-effect-shadow-multiple">Cagnotte</p>
  <div class="w3-light-grey w3-round-xlarge w3-border w3-margin">
    <div class="w3-container w3-indigo w3-xlarge w3-round-xlarge" style="width:75%">75%</div>
  </div>
</div>
      
  </div>
      

</div>

<br>

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