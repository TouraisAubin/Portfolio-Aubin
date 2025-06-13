#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<graph.h>
#include"affichage.h"

void echange(int tailleX, int tailleY, int* x1, int* y1, int x0,int y0, int tab[8][8]){
	
	int x = 0, y = 0;

	/* probabilite 1/2 de se deplacer en x ou en y*/
	if ((rand()%2) == 0){
		/* probabilite de se déplacer de 1 ou -1 sur x */
		if ((rand()%2) == 0 && x0 != 0){
            x = -1;
        } else if(x0 != tailleX-1){
            x = 1;
        }

	} else {
		/* probabilite de se déplacer de 1 ou -1 sur y */
		if ((rand()%2) == 0  && y0 != 0){
			y = -1;
		} else if(y0 != tailleY-1){
			y = 1;
		}
	}
	
	tab[x0][y0] = tab[x0+x][y0+y];
	tab[x0+x][y0+y] = 0;
	
	*x1 = x0+x;
	*y1 = y0+y;
}


void printTab(int x, int y, const int tab[8][8]){

	int i, j;

	for(i = 0; i < y; i++){
        for(j = 0; j < x; j++){
            printf("%3d", tab[i][j]);
        }
        printf("\n");
    }
	printf("\n");
	return;
}


int main (int argc, char * argv[]){
	
	int tab2[3] = {};
	acceuil(tab2);
	int i, j, ax, ay, x = tab2[1]-1, y = tab2[2]-7, x0 = 0, y0 = 0, tab[8][8] = {};

	srand(time(NULL));

/* remplissage de la matrice-----------------------------------------------*/
	for(i = 0; i < y; i++){
		for(j = 0; j < x; j++){
			tab[i][j] = i*x+j;
		}
	}

/* mélange de la matrice --------------------------------------------------*/
	for(i = 0; i < (x*y)*5; i++){
		echange(y, x, &x0, &y0, x0, y0, tab);
	}

	if (tab2[0] == 1){
		jeu(x0, y0, 1920, 1080, "image1.xpm", tab, x, y);
	} else if (tab2[0] == 2){
		jeu(x0, y0,  598,  598, "image2.xpm", tab, x, y);
	} else {
		jeu(x0, y0,  800,  517, "image3.xpm", tab, x, y);
	}
	

/*-------------------------------------------------------------------------*/
	return EXIT_SUCCESS;
}
