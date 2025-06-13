#include <stdio.h>
#include <stdlib.h>

// Affichage Theme Choisit
int Theme_Choisit(int NumTheme){
	switch(NumTheme) {	// Affichage selon le theme
		case 1:
			printf("Vous avez choisit le theme : ANIME\n\n");
			break;
		case 2:
			printf("Vous avez choisit le theme : RAP\n\n");
			break;
		case 3:
			printf("Vous avez choisit le theme : CINEMA\n\n");
			break;
		case 4:
			printf("Vous avez choisit le theme : JEUX VIDEO\n\n");
			break;
		default:
			printf("Vous n'avez pris aucun theme\n\n");
			break;
	}
	return NumTheme;
}

int main(){
	int NumTheme = 2; // Test Choix Theme
	printf("Vous avez choisit le theme numero %d.\n", NumTheme);

	Theme_Choisit(NumTheme);

	return 0;
}