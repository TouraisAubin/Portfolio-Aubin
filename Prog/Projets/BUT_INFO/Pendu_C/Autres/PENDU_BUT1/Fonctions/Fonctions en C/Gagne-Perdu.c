#include <stdio.h>
#include <stdlib.h>


// Fonction pour gagne perdu
int GagnePerdu(int Resultat){

	switch(Resultat) {	// Affichage WIN ou DEFEAT
		case 0:
			printf("Vous avez PERDU !\n\n");		
			break;
		case 1:
			printf("Vous avez GAGNE !\n\n");		
			break;
		default:
			printf("ERROR !\n\n");
			break;
	}

	return Resultat;
}


int main() {
	int Resultat;
    int Sortie; // Permettre ainsi de jouer OU de s'arreter de jouer
    int ereur = 3; // TEST si nombre de tentative atteint a 0 ou qu'il reste des tentatives
	
	// Permettre de savoir si l'utilisateur a gagne ou perdu
	// 1 = GAGNE - 0 = PERDU
	
	if(ereur > 0){
		Resultat = 1;
	}
	else{
		Resultat = 0;
	}

	// VOIR LE NOMBRE DE TENTATIVES RESTANT
	printf("Il vous reste %d tentatives\n", ereur);

	GagnePerdu(Resultat);

	return 0;
}