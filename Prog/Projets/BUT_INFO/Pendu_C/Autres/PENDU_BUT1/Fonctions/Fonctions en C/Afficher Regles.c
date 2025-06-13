#include <stdio.h>
#include <stdlib.h>

// Affichage Regles
void afficheregle(){
	printf("BIENVENUE AU JEU DU PENDU\n\n");

	printf("Voici les regles du jeu :\n");
    printf("Vous avez le droit a 5 point a chaque debut de partie.\n");
    printf("Quand une lettre est fausse, le joueur perd 1 point.\n");
    printf("S'il reste 3 points au joueur, on lui propose de prendre 1 indice mais, s'il choisit de le prendre, il perdra 1 point.\n");
    printf("S'il reste 1 points au joueur, on lui propose de trouver le mot en entier, mais si c'est faux, il perdra la partie.\n");

    printf("Pour proposer une lettre ou le mot en entier, le joueur doit entrer les caracteres en MAJUSCULE suivit d'un point pour valider son choix.\n\n");

    printf("Nous vous souhaitons une bonne partie, et BONNE CHANCE !\n\n");
}

int main(){
    afficheregle();

    return 0;
}