#include <stdio.h>
#include <stdlib.h>

#include <string.h>

// Fonction Supplementaire pour effectuer le test de la fonction corection
//Fonction qui stock le Mot/Indice a trouve
char *strcpy(char *destination, const char *source);

// Fonction Corection
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

    for(comptRempMot = 0; comptRempMot <= Taille; comptRempMot++) {         // recopie des mots
            Mc[comptRempMot] = Chaine[comptRempMot] ;
    }

    while(Mc[compteur] != '\0'){        // remplisage de "_" pour afficher les mots trouves
        if(Mc[compteur] == ' '){ // lorsque un espace est detecte dans le mot a trouver un esapce sera mit dans le meme numero case
        memoir[compteur] = ' ';
        compteurEspace ++; // comptage des espace pour etre pris en compte dans dans le nombre de lettre a trouver
        }
        else{
            memoir[compteur] = '_'; // reremplisage de "_"
            compteur2 ++ ; // comptage du nombre de lettre sans espace
        }
        compteur++;     // comptage du nombre de lettre
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

        if(ereur == 3) {      // par Aubin
            int ReponseIndice;

            printf("Voulez-vous un Indice ? (0. NON - 1. OUI) ") ; // propse un indice selon le choix de l'utilisateur
            scanf("%d", &ReponseIndice); // stock le choix de l'utulisateur

            switch(ReponseIndice) { // Affichage selon la reponse
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

int main() {
    // TEST FONCTION AVEC MOT ONE PIECE
    char *TabMotANIME[5] = {"NARUTO", "ONE PIECE", "DRAGON BALL Z", "SNK", "SWORD ART ONLINE"};    
    char *TabIndiceANIME[5] = {"POSSEDE UN DEMON A 9 QUEUES", "LE ROI DES PIRATES, CA SERA MOIIII", "KA-ME-HA-ME-HAAAA", "J'AI MANGE MON PAPA", "SI JE MEURS ICI, CELA SERA DEFINITF..."};
    char TabStockageMot[100] = "TEST"; // Stockage Mot [20] prendre large pour eviter probleme caractere avec la liste
    char TabStockageIndice[100] = "TEST"; // Stockage Indice

    strcpy(TabStockageIndice, TabIndiceANIME[1]); // Copie Indice
    strcpy(TabStockageMot, TabMotANIME[1]); // Copie Mot

    int taille = strlen(TabMotANIME[1]);

// TEST DE LA FONCTION EN QUESTION
    int erreur = corection(TabStockageMot, TabStockageIndice, taille);
            
    return 0;
}
