
  <?php
 

include_once("connexionBD.php");


$login = $_POST['login'];
$mdp = $_POST['mdp'];
$email = $_POST['email'];
$prenom = $_POST['firstname'];
$nom = $_POST['surname'];


$hash=password_hash( $mdp , PASSWORD_DEFAULT);

$reqi= "Insert into Customer(login,stash, mdp) values (\"$login\",0,\"$hash\")";
$resu = mysqli_query ($db,$reqi);


$requete = "Select id From Customer Where login = \"$login\" ";

$resultat = mysqli_query($db, $requete);

$info = mysqli_fetch_assoc($resultat);

$requ= "Insert into CustomerProtectedData(id,surname,firstname,email) values (\"".$info["id"]."\",\"$nom\",\"$prenom\",\"$email\")";
$resul = mysqli_query ($db,$requ);


$req = "select mdp , login from Customer where login = \"$login\" ";
$res = mysqli_query ($db,$req);
$info =mysqli_fetch_assoc ($res);


if ($info){


     echo "utilisateur créé";}


else {

   echo "erreur"; 

}

   ?>