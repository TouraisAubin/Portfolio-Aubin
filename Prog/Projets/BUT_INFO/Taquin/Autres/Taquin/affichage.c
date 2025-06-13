#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<graph.h>
#include"affichage.h"


void fenetre(x, y, x1, y1){
	InitialiserGraphique();
	CreerFenetre(x, y, x1, y1);
	/*ChargerImageFond("image.xpm");*/
}


void decoupe(int x, int y, int tailleX, int tailleY, char * img, const int tab[][8], int tailleTabX, int tailleTabY){
	
	int i, j, k, l, dstX, dstY, tempX = tailleX/x, tempY = tailleY/y;

	/*FermerGraphique();*/
	ChoisirEcran(1);
	ChargerImage(img, 0, 0, 0, 0, tailleX, tailleY);

	for (i = 0; i < y; i++){
		for (j = 0; j < x; j++){
			if (tab[i][j] != 0){
				CopierZone( 1, 0, (tab[i][j]%tailleTabX)*tempX, (tab[i][j]/tailleTabX)*tempY, tempX, tempY, j*tempX, i*tempY);
			}
		}
	}
	ChoisirEcran(0);
}


int saisie(int tailleX, int tailleY, int* x1, int* y1, int x0,int y0,int tab[][8]){
	int mv, x = 0, y = 0, t = Touche();

	if(t == 65362 && x0 != tailleX-1){
		/*haut*/
        x = 1;
		mv = 1;

	} else if(t == 65364 && x0 != 0){
		/*bas*/
        x = -1;
		mv = 2;

	} else if(t == 65361 && y0 != tailleY-1){
		/*gauche*/
        y = 1;
		mv = 3;

	} else if(t == 65363 && y0 != 0){
		/*droite*/
        y = -1;
		mv = 4;

	} else {
		return 0;
	}

	tab[x0][y0] = tab[x0+x][y0+y];
    tab[x0+x][y0+y] = 0;

    *x1 = x0+x;
    *y1 = y0+y;

	return mv;
}


int victoire(int x, int y, const int tab[][8]){
	int i, j, temp = -1;

	for (i = 0; i < y; i++){
		for (j = 0; j < x; j++){
			if (tab[i][j] <= temp){
				return 0;
			} else {
				temp = tab[i][j];
			}
		}
	}
	return 1;

}


void deplacement(int tailleX, int tailleY, int tailleTabX, int tailleTabY, int lastMv, int x0, int y0){
	int x = x0, y = y0, tempX = tailleX/tailleTabX, tempY = tailleY/tailleTabY;

	if (lastMv == 0){
		return;
	} else if (lastMv == 1 && x0 != 0){
		x = x-1;
		/*haut*/
	} else if (lastMv == 2 && x0 < tailleTabY){
		x = x+1;
		/*bas*/
	} else if (lastMv == 3 && y0 != 0){
		y = y-1;
		/*gauche*/
    } else if (lastMv == 4 && y0 < tailleTabX){
        y = y+1;
		/*droite*/
    }
	
	ChoisirCouleurDessin(CouleurParComposante(255, 255, 255));
	CopierZone(0, 0, y0*tempX, x0*tempY, tempX, tempY, (y)*tempX, (x)*tempY);
	RemplirRectangle(y0*tempX, x0*tempY, tempX, tempY);
}


void jeu(int x0, int y0, int tailleX, int tailleY, char * img, int tab[][8], int tailleTabX, int tailleTabY){
	
	int lastMv, vict = 0;

	fenetre(0, 0, tailleX, tailleY);
	decoupe(tailleTabX, tailleTabY, tailleX, tailleY, img, tab, tailleTabX, tailleTabY);
	while (vict == 0){
		lastMv = saisie(tailleTabY, tailleTabX, &x0, &y0, x0, y0, tab);
		vict = victoire(tailleTabX, tailleTabY, tab);
		deplacement(tailleX, tailleY, tailleTabX, tailleTabY, lastMv, x0, y0);
	}

	FermerGraphique();
	fenetre(300, 300, 600, 300);
	EcrireTexte(90, 160, "Vous avez gagne felicitation !", 2);
	Touche();
	FermerGraphique();
}


int graphBouton(int tab[][4], int seed, int nbBouton, int x, int y, int espace, int l, int h){
	int i, j;

	ChoisirCouleurDessin(CouleurParComposante(255, 255, 255));
	for (i = 0; i < nbBouton; i++){
		RemplirRectangle(x+i*l+i*espace, y, l, h);
		tab[i+seed][0] = x+i*l+i*espace;
		tab[i+seed][1] = y;
		tab[i+seed][2] = (x+i*l+i*espace)+l;
		tab[i+seed][3] = y+h;
	}
}


int saisieSourie(int tab[][4]){
	int i;

	if(SourisCliquee() == 1){
		for(i = 1; i < 16; i++){
			if(_X <= tab[i][2] && tab[i][0] <= _X && _Y <= tab[i][3] && tab[i][1] <= _Y){
				return i;
			}
		}
	}
}


void carreNoir(int start, int end, int tab[][4]){
	int i;

	ChoisirCouleurDessin(CouleurParComposante(0, 0, 0));
	for(i = start; i < end; i++){
		DessinerRectangle(tab[i][0], tab[i][1], tab[i][2]-tab[i][0], tab[i][3]-tab[i][1]);
	}
}


void escroc(x, y){
	ChoisirCouleurDessin(CouleurParComposante(0, 0, 0));
	EcrireTexte(x    , y, "3", 2);
	EcrireTexte(x+105, y, "4", 2);
	EcrireTexte(x+210, y, "5", 2);
	EcrireTexte(x+315, y, "6", 2);
	EcrireTexte(x+420, y, "7", 2);
	EcrireTexte(x+525, y, "8", 2);
}


void acceuil(int tab2[3]){
	int temp, bouton1 = -1, bouton2 = -1, bouton3 = -1, sortie = 0;
	int tab[16][4] = {{  0,   0,   0,   0},
					  {750,  50, 904, 136},
					  {750, 200, 899, 350}, 
   				      {750, 400, 902, 498}};

	fenetre(0, 0, 1000, 600);
    ChoisirEcran(0);
    EffacerEcran(CouleurParComposante(55, 55, 65));
    EcrireTexte(50, 125, "Choisir Le Nombre De Colonnes : ", 2);
	graphBouton(tab, 4, 6, 50,  150, 15, 90, 90);
	escroc(90, 190);
	ChoisirCouleurDessin(CouleurParComposante(0, 0, 0));
	EcrireTexte(50, 375, "Choisir Le Nombre De Lignes : ", 2);
	graphBouton(tab, 10, 6, 50, 400, 15, 90, 90);
	escroc(90, 440);
    ChargerImage("preview1.jpg", 750, 50, 0, 0, 154, 86);
    ChargerImage("preview2.jpg", 750, 200, 0, 0, 149, 150);
    ChargerImage("preview3.jpg", 750, 400, 0, 0, 152, 98);
	ChoisirCouleurDessin(CouleurParComposante(100, 100, 255));



	carreNoir(1, 4, tab);

    while(sortie != 1){
		if (bouton1 != -1 && bouton2 != -1 && bouton3 != -1){
			sortie = 1;
		}
		temp = saisieSourie(tab);
		if (0 < temp && temp <= 3){
			bouton1 = temp;
			carreNoir(1, 4, tab);
			ChoisirCouleurDessin(CouleurParComposante(100, 100, 255));
			DessinerRectangle(tab[bouton1][0], tab[bouton1][1], tab[bouton1][2]-tab[bouton1][0], tab[bouton1][3]-tab[bouton1][1]);
		} else if (4 <= temp && temp <= 9){
			bouton2 = temp;
			carreNoir(4, 9, tab);
			ChoisirCouleurDessin(CouleurParComposante(100, 100, 255));
			DessinerRectangle(tab[bouton2][0], tab[bouton2][1], tab[bouton2][2]-tab[bouton2][0], tab[bouton2][3]-tab[bouton2][1]);
		} else if (10 <= temp && temp <= 16){
			bouton3 = temp;
			carreNoir(10, 16, tab);
			ChoisirCouleurDessin(CouleurParComposante(100, 100, 255));
			DessinerRectangle(tab[bouton3][0], tab[bouton3][1], tab[bouton3][2]-tab[bouton3][0], tab[bouton3][3]-tab[bouton3][1]);
		}
		temp = 0;
	}
	tab2[0] = bouton1;
	tab2[1] = bouton2;
	tab2[2] = bouton3;
    FermerGraphique();
}
