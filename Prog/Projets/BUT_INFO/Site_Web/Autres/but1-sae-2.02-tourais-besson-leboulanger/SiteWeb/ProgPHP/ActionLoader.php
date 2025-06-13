<?php
   session_start();
   if (isset($_SESSION['connect'])) {
      header("Location:../ProgHTML/Profil.php");
      exit();
   }

   include_once("connexionBD.php");

   $login = $_POST['login'];
   $mdp = $_POST['mdp'];

   $requete = "Select id,login, mdp From Customer Where login = \"$login\"";
   $resultat = mysqli_query($db, $requete);
   $info = mysqli_fetch_assoc($resultat);
   if($info){
      if(password_verify($mdp,$info['mdp'])){
         $_SESSION['connect'] = $info['id'];
         header("Location:../ProgHTML/Profil.php");
      }else{
         echo "connexion échoué";
      }
   }
?>