#include <stdio.h>
#include <stdlib.h>

//Fonction affichage themes
char AffichageTheme(){
	int NumTheme;

	do{
		printf("Vous avez le choix entre 4 themes : \n");
		printf("1. ANIME\n");
		printf("2. RAP\n");
		printf("3. CINEMA\n");
		printf("4. JEUX VIDEO\n");

		printf("\nAu quel voulez-vous jouer ? ");
		scanf("%d", &NumTheme);

		if((NumTheme < 0) || (NumTheme > 4)){
			printf("\nATTENTION ! Veuillez choisir un theme existant allant de 1 a 4\n\n");
		}

	} while((NumTheme < 0) || (NumTheme > 4));

	return NumTheme;
} 

int main(){
	int Theme;

	// Affichage Themes
	Theme = AffichageTheme();
	printf("Vous voulez jouer au Theme numero %d.\n", Theme);

	return 0;
}