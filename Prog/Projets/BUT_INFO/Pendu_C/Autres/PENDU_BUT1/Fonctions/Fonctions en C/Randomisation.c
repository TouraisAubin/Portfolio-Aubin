// Randomisation

#include <stdlib.h>
#include <stdio.h>

#include <time.h>

#define NBREMOT 5 // Car dans le tableau il y aura 5 mots

//Fonction pour randomiser le nombre
int Randomisation(){
	srand(time(NULL));

    int Random = rand() % NBREMOT + 1; 
}

//"TEST" Afficher le nombre genere aleatoirement
int main(){
	int Nombre = Randomisation();
 
	printf("Le nombre random est : %d\n\n", Nombre);
	Nombre = Nombre - 1; // Afficher la case du nombre exact car tableau va de [0;4] et non pas de 1 à 5

	return 0;
}