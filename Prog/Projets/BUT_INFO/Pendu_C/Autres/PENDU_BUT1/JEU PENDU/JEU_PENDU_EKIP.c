/*  Membres de l'equipe "EKIP" :
- Aubin
- Dave
- Francois-Xavier
- Ahmet */

#include <stdio.h>
#include <stdlib.h>

#include <time.h>
#include <string.h>

#define NBREMOT 5

// Francois Xavier
// Affichage des regles du jeu 
void afficheregle(){
	printf("BIENVENUE AU JEU DU PENDU\n\n");

	printf("Voici les regles du jeu :\n");
    printf("Vous avez le droit a 5 point a chaque debut de partie.\n");
    printf("Quand une lettre est fausse, le joueur perd 1 point.\n");
    printf("S'il reste 3 points au joueur, on lui propose de prendre 1 indice mais, s'il choisit de le prendre, il perdra 1 point.\n");
    printf("S'il reste 1 points au joueur, on lui propose de trouver le mot en entier, mais si c'est faux, il perdra la partie.\n\n");
    printf("Lors du choix du theme, de l'indice ou de pouvoir rejouer, entrer le nombre puis faites uniquement ENTREE.\n");
    printf("Pour proposer une lettre ou le mot en entier, le joueur doit entrer les caracteres en MAJUSCULE suivit d'un point pour valider son choix.\n\n");

    printf("Nous vous souhaitons une bonne partie, et BONNE CHANCE !\n\n");
}

// AUBIN
//Fonction pour randomiser le nombre
int Randomisation(){
	srand(time(NULL));

    int Random = rand() % NBREMOT; // Randomise un nombre entre NBREMOT (5 car On possede 5 mot dans le tableau) [0 a 4]

    return Random;
}

// Fonction pour gagne perdu
int GagnePerdu(int Resultat){

	switch(Resultat) {	// Affichage WIN ou DEFEAT
		case 0: // Si resultat = 0 alors il a perdu car 0 tentatives restantes
			printf("\n\nVous avez PERDU !\n\n");
			break;
		case 1: // Si resultat = 1 alors il a gagne car minimun 1 tentative restante
			printf("\n\nVous avez GAGNE !\n\n");
			break;
		default:
			printf("\nERROR !\n\n");
			break;
	}

	return Resultat;
}

//Fonction affichage themes
char AffichageTheme(){
	int NumTheme;

	do{ // Faire L'affichage des themes
		printf("Vous avez le choix entre 4 themes : \n");
		printf("1. ANIME\n");
		printf("2. RAP\n");
		printf("3. CINEMA\n");
		printf("4. JEUX VIDEO\n");

		printf("\nAu quel voulez-vous jouer ? (1. ANIME - 2. RAP - 3. CINEMA - 4. JEUX VIDEO) ");
		scanf("%d", &NumTheme); // L'utilisateur dit quel theme il souhaite jouer

		if((NumTheme < 0) || (NumTheme > 4)){ // Si l'utilisateur donne une autre valeur que 1; 2; 3 ou 4, alors message d'erreur
			printf("\nATTENTION ! Veuillez choisir un theme existant allant de 1 a 4\n\n");
		}

	} while((NumTheme < 0) || (NumTheme > 4)); // Si utilisateur donne un theme disponible alors on continue le programme sinon on redemande de donner un theme qui est disponible

	return NumTheme;
}

//Fonction qui stock le Mot/Indice a trouve
char *strcpy(char *destination, const char *source);


// Affichage Theme Choisit
int Theme_Choisit(int NumTheme){
	switch(NumTheme) {	// Affichage selon le theme selon le choix que l'utilisateur a fait depuis AffichageTheme
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

// Fonction pour que l'utilisateur dise s'il veut rejouer ou non
int Rejouer(){
	int Reponse;

	printf("Voulez-vous rejouer ? (0. NON - 1. OUI) ") ;
	scanf("%d", &Reponse);

	switch(Reponse) {	// Affichage selon la reponse
		case 0: // Si utilisateur choisit 0 alors il ne veut pas rejouer
			printf("Vous ne voulez pas rejouer !\n\n");
			printf("Au revoir.\n\n");
			break;
		case 1: // Si utilisateur choisit 1 alors il veut rejouer
			printf("Vous voulez rejouer !\n\n");
			break;
		default:
			printf("ERROR !\n");
			break;
	}

	return Reponse;
}


// DAVE
int corection(char *Chaine, char *Indice, int Taille) {
    char TabPRo[15];

    int ereur = 5;

    int RepBonne = 0 ;      // variable qui stocke le nombre de bonne reponse
    int NBLetrretrouv = 0 ;         // sock le nombre de correspondance deja touver pour la partie ou il faut taper
    int t = 0 ;         // compteur utiliser pour afficher les mots trouver
    char caract ;       // stocke les caracteres tape
    int propo= 0  ;         // varie selon si le choix de taper le mots en entier
    int corespon = 0 ;      // stocke le nombre de correspondance entre les deux tableaux
    int i = 0 ;         // compteur pour remplir de "_"
    int compt2 = 0;         // compteur pour boucle de verification des mots
    int compt1 = 0 ;        // compteur pour boucle de verification des mots
    int comptMem = 0 ;      // compteur pour boucle de verification des caractere trouve
    int comptRempMot = 0 ; // compteur pour remplir le tableau du mot a trouver
    int PluC = 0 ;  // lorsque vous donnez une proposition, il va memoriser si la lettre a deja ete trouve dans le mot
    int NBespace ; // stocke le nombre d'espace
    int MemCompt ; //  memorisation du nombre de lettre

    char Mc[20];
    char memoir[20] ;       // stocke les mots deja touve et les affiche en "_"

	int compteur = 0; // Affichage underscore taille mot
	int compteur2 = 0; // Affichage underscore Sans Espace taille mot
    int compteurEspace = 0;

    for(comptRempMot = 0; comptRempMot <= Taille; comptRempMot++) { 		// recopie des mots
            Mc[comptRempMot] = Chaine[comptRempMot] ;
    }

    while(Mc[compteur] != '\0'){ 		// remplisage de "_" pour afficher les mots trouves
    	if(Mc[compteur] == ' '){ // lorsque un espace est detecte dans le mot a trouver un esapce sera mit dans le meme numero case
    	memoir[compteur] = ' ';
    	compteurEspace ++; // comptage des espace pour etre pris en compte dans dans le nombre de lettre a trouver
    	}
        else{
    		memoir[compteur] = '_'; // reremplisage de "_"
    		compteur2 ++ ; // comptage du nombre de lettre sans espace
    	}
    	compteur++;		// comptage du nombre de lettre
    }


    MemCompt = compteur; // memorisation du nombre de lettre avant sa desacrementation
    compteur--; // Eviter de compter le \0

    i = 0 ; // passage a zero pour reutiliser ce compteur
	corespon = 0; // passage a zero pour reutiliser ce compteur

	// Affichage des undescore
    while(i <= compteur) {      
    	printf("%c ", memoir[i]);
        i++;
    }

    RepBonne = compteurEspace;

    while((ereur > 0) && (RepBonne <= compteur)) {       // s'arreter si on a 0 erreur ou si toutes les lettres sont Bonnes le nombre 12 a adapter
        printf("\n\n\nDonnez une lettre : ");

        // remise des compteurs a 0
        i = 0 ;
        compt1 = 0 ;
        compt2 = 0 ;
        corespon = 0 ;

        caract = getchar();     // entrer des caracteres proposes
        while( caract != '.') {         // entree des tentatives
            TabPRo[i] = caract ;
            i ++ ; // i va stocker le nombre de lettre que l'utilisateur a tape

            caract = getchar();
        }

        printf( " \n" );    // saut de ligne

        if((ereur > 0) && (propo == 0)) {      // si le choix n'a pas encore fait ou n'a pas ete propose
            compt1 = 0;

            // double boucle pour verifier, en resume ca va selectionner chaque caractere, et la comparer a tous les caracteres du tableau
            // avant de faire pareil avec le prochain caractere tape
            while (compt1 < 2) {      // test lettre par lettre de ce que l'utilisateur a entre
                compt2 = 0;

                while(compt2 <= compteur) {     // chaque lettre est comparee avec tous les mots du tableau de veref ici Mc
                    if(TabPRo[compt1] ==  Mc[compt2]) {      // s'il y a une correspondance, on acremante le nombre de lettre trovee

                        if(Mc[compt2] != memoir[compt2]) {       // verification dans la memoire pour pas taper x fois le meme caractere et tricher
                            corespon = corespon + 1;    // le nombre de corespondance trouvee
                            memoir[compt2] = Mc[compt2] ;      // stockage dans la memoire
                            NBLetrretrouv ++ ;      // donne les corespondances deja trouvees pour plus tard
                        }
                    }
                    compt2++;
                }
                compt1++;
            }

           // remise des compteurs a 0
           compt1 = 0 ;
           compt2 = 0 ;

           if( corespon ==  0 ) {       // s'il n'a pas trouver de correspondance ca met une erreur "1 Tentative en moins"
                ereur = ereur - 1 ;
           }
           else if( corespon > 0 ) {       // sinon ca acremente les bonnes reponses
                RepBonne = RepBonne + corespon ;   // le nombre de caratere trouve se stock
           }

           printf("Il vous reste %d tentatives\n\n", ereur) ;     //  dire les tentatives qu'ils restent

           corespon = 0 ;   // remise des compteurs a 0
        } // Fin du if ligne 53

        if((ereur == 1) && (propo != 1)) {      // proposition de taper le mot en entier avec 3, ca ne marcher pas a 3
            printf("Voulez-vous tenter le mot en entier ? (0. NON - 1. OUI) ");
            scanf("%d", &propo);

            printf( " \n" );        // saut de ligne
        }

        if(ereur == 3) {     
        	// Fonction Proposition Indice Par Aubin -- Integre directement dans la fonction Corection
        	int ReponseIndice;

			printf("Voulez-vous un Indice ? (0. NON - 1. OUI) ") ; // propse un indice selon le choix de l'utilisateur
			scanf("%d", &ReponseIndice); // stock le choix de l'utulisateur

			switch(ReponseIndice) {	// Affichage selon la reponse
				case 0:
					printf("\nVous ne voulez pas d'indice.\n\n"); // s'il ne veut pas d'indice
					break;
				case 1:
					printf("\nVous voulez un Indice.\n");
					printf("Votre Indice est : %s.\n\n", Indice); // affiche l'indice

					ereur --;

					printf("Il vous reste %d tentatives\n\n", ereur) ;     //  dire les tentatives qu'ils restent
					break;
				default:
					printf("\nERROR !\n");
					break;
			}
        }

        if(propo ==  1) {   // joue s'il choisit de taper le mot en entier
            i = 0;

            printf("Tape le mots en entier : ") ;
            caract = getchar();     // entrer des caracteres proposes

            while( caract != '.') {     // entree des tantatives pour la double
                TabPRo[i] = caract;
                i++;

                caract = getchar();
            }

            printf( " \n" ); // saut de ligne

            NBespace = MemCompt - compteur2; // calcule du nombre d'espace
            corespon = NBLetrretrouv + NBespace ;      // stock des corespondances deja toruvees
           
           	// Remise a 0 des compteurs
            compt1 = 0;
            compt2 = 0 ;

            while (compt1<=i) {         // test lettre par lettre de ce que l'utilisateur a entree
                compt2 = 0;
                PluC = 0 ; // remise a 0 pour le prochain caractere a trouver

                while(compt2 <= compteur) {     // chaque lettre est comparee avec tous les mots du tableau de veref
                    if( TabPRo[compt1] == Mc[compt2] ) {     // s'il ya une corespondence, on acrémante le nombre de lettre trouvee

                        if( Mc[compt2] != memoir[compt2] ) { // verification dans la memoire
                        	corespon ++; // detactage de la corespondance
                            memoir[compt2] = Mc[compt2] ; // stocke dans la memoire
                            PluC = 1 ; // pour eviter de compter plusieurs fois le meme mot
                            
                            if( PluC == 0 ) { // si le plusieurs fois le mot est detecte, on ne le compte pas
                                corespon ++;
                          	}
                        }
                    }
                    compt2++;
                }
                compt1++;
            }
            compt1 = 0 ;
            compt2 = 0 ;

            i --;

            if(corespon == MemCompt ) {        //donne les point, seulement si tous les nombres des caratere sont bon
                RepBonne = MemCompt;
            }

            else {      // sinon il perd tentative
               ereur = 0 ;
               printf("Le mot etait : %s", Chaine);
            }

            propo = 0 ;     // remise a 0 pour refaire le choix
        }     // Fin if ligne 105

        if(ereur != 0){
	        while(t <= compteur) {   // affichage des lettres trouvees
	            printf("%c ", memoir[t]);
	            t ++ ;
	        }
	    }
        t = 0;
    }

    return ereur ;  // retourne le nombre d'erreur
}


// JEU PENDU MAIN
int main() {
	int Theme;	// Stock le numero du theme choisit par l'utilisateur pour ainsi jouer au theme en question
	int StockageIndice;		// Stock l'indice du mot qui est a trouve pour l'afficher si l'utilisateur souhaite en avoir un
	int Resultat;	// Stock si l'utilisateur possede ou non des tentatives a la fin de la partie pour lui indiquer s'il a GAGNE ou PERDU
	int Sortie; // Permettre ainsi de jouer OU de s'arreter de jouer
	int Tentatives;	// Stock le nombre de tentatives restant de l'utilisateur apres la fin de sa partie
	int taille; // Taille du mot genere aleatoirement et qui est a devine

    char TabStockageMot[100] = "TEST"; // Stockage Mot [20] prendre large pour eviter probleme caractere avec la liste
    char TabStockageIndice[100] = "TEST"; // Stockage Indice

// TABLEAUX MOT
	char *TabMotANIME[NBREMOT] = {"NARUTO", "ONE PIECE", "DRAGON BALL Z", "SNK", "SWORD ART ONLINE"};
	char *TabMotRAP[NBREMOT] = {"AU DD", "FREZZ CORLEON", "DRAKE GOD PLAN", "NEKFEU", "KAARIS"};
	char *TabMotCINEMA[NBREMOT] = {"PULP FICTION", "INTERSTELAR", "AVATAR", "INCEPTION", "FIGHT CLUB"};
	char *TabMotJEUX_VIDEO[NBREMOT] = {"GOD OF WAR", "RATCHT CLANK", "DEMON SOUL", "ARK SURVIVAL", "NBA 2K"};

// TABLEAU INDICE
	char *TabIndiceANIME[NBREMOT] = {"POSSEDE UN DEMON A 9 QUEUES", "LE ROI DES PIRATES, CA SERA MOIIII", "KA-ME-HA-ME-HAAAA", "J'AI MANGE MON PAPA", "SI JE MEURS ICI, CELA SERA DEFINITF..."};
	char *TabIndiceRAP[NBREMOT] = {"Clips sur la tour effeil de deux freres", " Freestyle reference un terroristes celebre", "Un rappeur ultra connu qui distribut des billets", "Meilleur plume dur rap game et parisien", "Devenu celebre en disant je broie tes os boie ton sang"};
	char *TabIndiceCINEMA[NBREMOT] = {"Plusse intrigue tournant sur le thème des gangster", "Espace et concept temporel de Christopher Nolan", "Un film sur une civilisation de gens bleus", "Exploration des rêves avec Leonardo DiCaprio", "Double personnage à te faire faire du savon"};
	char *TabIndiceJEUX_VIDEO[NBREMOT] = {"Lame du chaos", "Un renard avec son robot", "C'est la meme chose que Dark Soul", "Tu combats des Dinosaure", "M. J."};

    // DEBUT DU JEU
    // Affichage des regles du jeu
	afficheregle();

	do{
		// Affichage Themes Disponible
		Theme = AffichageTheme();

		// Affichage du Theme Choisit par l'utilisateur
		Theme_Choisit(Theme);

		//GENERATION NOMBRE ALEATOIRE
		int Nombre = Randomisation();

// Stockage Indice et Mot genere par le randomisateur avec la taille du mot
		switch(Theme) {	// Affichage selon le theme
		case 1: // ANIME
			strcpy(TabStockageIndice, TabIndiceANIME[Nombre]); // Copie Indice
			strcpy(TabStockageMot, TabMotANIME[Nombre]); // Copie Mot

			taille = strlen(TabMotANIME[Nombre]); // Mesure la taille du mot a devine
			break;

		case 2: // RAP
			strcpy(TabStockageIndice, TabIndiceRAP[Nombre]); // Copie Indice
			strcpy(TabStockageMot, TabMotRAP[Nombre]); // Copie Mot

			taille = strlen(TabMotRAP[Nombre]); // Mesure la taille du mot a devine
			break;

		case 3: // CINEMA
			strcpy(TabStockageIndice, TabIndiceCINEMA[Nombre]); // Copie Indice
			strcpy(TabStockageMot, TabMotCINEMA[Nombre]); // Copie Mot

			taille = strlen(TabMotCINEMA[Nombre]); // Mesure la taille du mot a devine
			break;

		case 4:// JEUX VIDEO
			strcpy(TabStockageIndice, TabIndiceJEUX_VIDEO[Nombre]); // Copie Indice
		    strcpy(TabStockageMot, TabMotJEUX_VIDEO[Nombre]); // Copie Mot

			taille = strlen(TabMotJEUX_VIDEO[Nombre]); // Mesure la taille du mot a devine
			break; 
		}

		// Application Fonction Corection
		Tentatives = corection(TabStockageMot, TabStockageIndice, taille);

		// Si 0 Tentatives alors Resultat = 0 sinon 1
		if(Tentatives > 0){
			Resultat = 1; // 1 = GAGNE
		}
		else{
			Resultat = 0; // 0 = PERDU
		}

		// Si 0 Tentatives alors PERDU, sinon Tentatives > 0 alors GAGNE
		GagnePerdu(Resultat);

		// Propose a l'utilisateur de rejouer ou non
		Sortie = Rejouer();

	} while(Sortie != 0); // Si REPONSE UTILISATEUR = 0 alors on rejoue, sinon si 1 UTILISATEUR VEUT STOPPER alors on sort de la boucle

	return 0;
}
