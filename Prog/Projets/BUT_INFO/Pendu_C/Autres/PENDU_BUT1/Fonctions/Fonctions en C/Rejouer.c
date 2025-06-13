#include <stdio.h>
#include <stdlib.h>


// Fonction pour rejouer
int Rejouer(){
	int Reponse;

	printf("Voulez-vous rejouer ? (0. NON - 1. OUI) ") ;
	scanf("%d", &Reponse);

	switch(Reponse) {	// Affichage selon la reponse
		case 0:
			printf("Vous ne voulez pas rejouer !\n\n");
			printf("Au revoir.\n\n");		
			break;
		case 1:
			printf("Vous voulez rejouer !\n\n");		
			break;
		default:
			printf("ERROR !\n");
			break;
	}

	return Reponse;
}

int main() {
    int Sortie; // Permettre ainsi de jouer OU de s'arreter de jouer

// ENTRER DANS LE JEU ET SI ON VEUT REJOUER ON RECOMMENCER SINON ON SORT DE LA BOUCLE
do{

	Sortie = Rejouer();

} while(Sortie != 0); // Si REPONSE UTILISATEUR = 0 alors on rejoue, sinon si 1 UTILISATEUR VEUT STOPPER alors on sort de la boucle

	return 0;
}