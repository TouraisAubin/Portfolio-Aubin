#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NBREMOT 5

//Fonction qui stock le Mot/Indice a trouve
char *strcpy(char *destination, const char *source);


int main(){
	char TabStockageMot[20] = "TEST"; // Stockage Mot [20] prendre large pour eviter probleme de place pour les caracteres avec la liste
    char TabStockageIndice[100] = "TEST"; // Stockage Indice

// TABLEAUX MOT - TEST -
	char *TabMotANIME[NBREMOT] = {"NARUTO", "ONE PIECE", "DRAGON BALL Z", "SNK", "SWORD ART ONLINE"};

// TABLEAU INDICE - TEST -
	char *TabIndiceANIME[NBREMOT] = {"POSSEDE UN DEMON A 9 QUEUES", "LE ROI DES PIRATES, CA SERA MOIIII", "KA-ME-HA-ME-HAAAA", "J'AI MANGE MON PAPA", "SI JE MEURS ICI, CELA SERA DEFINITF..."};


// Pour le test - Donc Naruto -
int Nombre = 0; // 1e mot du Tableau Mot = NARUTO

	int taille = strlen(TabMotANIME[Nombre]);
	printf("La taille du mot est de %d.\n", taille);

    strcpy(TabStockageMot, TabMotANIME[Nombre]); // Copie Mot
	strcpy(TabStockageIndice, TabIndiceANIME[Nombre]); // Copie Indice

	printf("Votre copie MOT est : %s\n", TabStockageMot); // Affiche le mot stocke
	printf("Votre copie INDICE est : %s\n", TabStockageIndice); // Affiche l'indice du mot stocke

	return 0;
}