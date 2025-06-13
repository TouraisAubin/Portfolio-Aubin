#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<graph.h>

extern void fenetre(int x,int y,int x1,int y1);

extern void decoupe(int x, int y, int tailleX, int tailleY, char * img, const int tab[][8], int tailleTabX, int tailleTabY);

extern void acceuil(int tab[3]);

extern int saisie(int tailleX, int tailleY, int* x1, int* y1, int x0,int y0,int tab[][8]);

extern void jeu(int x0, int y0, int tailleX, int tailleY, char * img, int tab[][8], int tailleTabX, int tailleTabY);

extern int victoire(int x, int y, const int tab[][8]);
