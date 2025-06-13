<!DOCTYPE html>

<?php
  session_start();
  include_once("../ProgPHP/connexionBD.php");

  function sqlQuery($requete){
    include_once("../ProgPHP/connexionBD.php");
    $resultat = mysqli_query($db, $requete);
    $info = mysqli_fetch_assoc($resultat);
    return $info;
  }

  

  $value = $_SESSION['connect'];

  $info = sqlQuery("Select * From CustomerProtectedData Where id = \"$value\"");

  //$firstname = $info['firstname'];
  //$surname   = $info['surname'];
  //$email     = $info['email'];

  setcookie("firstname", $info['firstname'], time()+3600);
  setcookie("surname"  , $info['surname']  , time()+3600);
  setcookie("email"    , $info['email']    , time()+3600);

  $info = sqlQuery("Select login From Customer Where id = \"$value\"");
  setcookie("login"    , $info['login']    , time()+3600);
  ?>

<html>
<head>
  <title>Profil</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<!-- Barre de Navigation -->
  <div class="w3-top">
    <div class="w3-bar w3-light-grey w3-border w3-large">
      <button class="w3-button w3-indigo w3-xlarge w3-right w3-card fa fa-home" onclick="openRightMenu()"></button>
        <a class="w3-bar-item w3-indigo">Profil</a>
        
        <div class= "w3-sidebar w3-bar-block w3-animate-right" style="display:none;right:0;" id="rightMenu">
              <button onclick="closeRightMenu()" class="w3-bar-item w3-button w3-indigo w3-large w3-right">Fermer &times;</button>
              <a href="Connexion.php" class="w3-bar-item w3-button">Se connecter</a>
            <a href="https://dwarves.iut-fbleau.fr/~tourais/SiteWeb/ProgPHP/deconnexion.php" class="w3-bar-item w3-button">Se deconnecter</a>
        </div>
    </div>
  </div>

<!-- Container avec le profil du client -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    

  <div class="w3-row">

    <div class="w3-col m3">

      <div class="w3-card w3-round w3-indigo w3-margin">
        <div class="w3-container w3-margin">
         <h4 class="w3-center">Profil</h4>
         <p class="w3-center"><img src="../Photo/icone.png" class="w3-circle w3-border" style="height:70px;width:70px" alt="Avatar"></p>
         <hr>
         <?php  

         $value = $_COOKIE['login'];
         echo "<p><img src=\"../../Photo/icone.png\" class=\"w3-circle w3-border w3-margin-right\" style=\"height:30px;width:30px\" alt=\"Avatar\"><button class=\"w3-btn w3-white w3-large\">$value</button></p>";
         $value = $_COOKIE['firstname'];
         echo "<p><img src=\"../../Photo/icone.png\" class=\"w3-circle w3-border w3-margin-right\" style=\"height:30px;width:30px\" alt=\"Avatar\"><button class=\"w3-btn w3-white w3-large\">$value</button></p>";
         $value = $_COOKIE['surname'];
         echo "<p><img src=\"../../Photo/icone.png\" class=\"w3-circle w3-border w3-margin-right\" style=\"height:30px;width:30px\" alt=\"Avatar\"><button class=\"w3-btn w3-white w3-large\">$value</button></p>";
         $value = $_COOKIE['email'];
         echo "<p><img src=\"../../Photo/icone.png\" class=\"w3-circle w3-border w3-margin-right\" style=\"height:30px;width:30px\" alt=\"Avatar\"><button class=\"w3-btn w3-white w3-large\">$value</button></p>";

         ?>
        </div>
      </div>
      <br>
      
    
    </div>
    

  <div class="w3-col m9 w3-margin-top">
    
    <div class="w3-container w3-margin">
      <table class="w3-table-all w3-pading w3-margin-top">

        <thead>
          <tr class="w3-indigo">
            <th>Materiaux</th>
            <th>Quantite (mg)</th>
          </tr>
        </thead>

        <tr class="w3-text-black">
          <td>Or</td>
          <td>10 000</td>
        </tr>

        <tr class="w3-text-black">
          <td>Cuivre</td>
          <td>15 000</td>      
        </tr>

        <tr class="w3-text-black">
          <td>Aluminium</td>
          <td>25 000</td>       
        </tr>
              <tr class="w3-text-black">
          <td>Paladium</td>
          <td>15</td>       
        </tr>
              <tr class="w3-text-black">
          <td>Argent</td>
          <td>340</td>       
        </tr>
              <tr class="w3-text-black">
          <td>Platinium</td>
          <td>1</td>       
        </tr>
              <tr class="w3-text-black">
          <td>Gold</td>
          <td>34</td>       
        </tr>
      
      </table>
    </div>
      
  </div>
      

</div>

<div class="w3-center w3-border">
    <p class="w3-xxlarge font-effect-shadow-multiple">Cagnotte</p>
  <div class="w3-light-grey w3-round-xlarge w3-border w3-margin">
    <div class="w3-container w3-indigo w3-xlarge w3-round-xlarge" style="width:75%">75%</div>
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
