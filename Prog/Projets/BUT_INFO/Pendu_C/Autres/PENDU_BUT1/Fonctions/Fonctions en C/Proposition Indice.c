#include <stdio.h>
#include <stdlib.h>


// Fonction Indice
int PropositionIndice(){
	int ReponseIndice;

	printf("Voulez-vous un Indice ? (0. NON - 1. OUI) ") ;
	scanf("%d", &ReponseIndice);

	switch(ReponseIndice) {	// Affichage selon la reponse
		case 0:
			printf("\nVous ne voulez pas d'indice.\n\n");	
			break;
		case 1:
			printf("\nVous voulez un Indice.\n");		
			break;
		default:
			printf("\nERROR !\n");
			break;
	}

	return ReponseIndice;
}



int main() {
	int StockageIndice;

	//Proposition et don de l'indice
	StockageIndice = PropositionIndice();

// Si l'utilisateur veut un indice, on affiche l'indice du mot a devine qui a etait stockee via la fonction copie
/*
	if(StockageIndice == 1){
		printf("Votre Indice est :%s", TabStockageIndice);
	}
*/

	return 0;
}