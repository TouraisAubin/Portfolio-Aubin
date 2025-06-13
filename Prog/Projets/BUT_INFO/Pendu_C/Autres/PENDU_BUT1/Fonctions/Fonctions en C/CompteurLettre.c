#include <stdio.h>
#include <stdlib.h>

#include <string.h>

// Compte le nombre de fois que la lettre est dans le mot
int TestLettre (char mot[], char lettre[]){
    int i = 0, test = 0;

    while(mot[i]){
        if (mot[i++] == lettre[0]){
            test++;
        }
   }
    
    return test;
}


// TEST
int main() {
    char Mot[100] = "JE MANGE DU POULET"; // TEST pour remplacer mot par underscore
    char lettre[0]; // Stock la lettre donner pour comparer

    printf("Donner une lettre : ");
    scanf("%c", lettre);

    printf("\nLa lettre se trouve %d fois dans la chaine de caracteres.\n", TestLettre(Mot, lettre)); // Affiche le nombre de fois que la lettre est dans le mot

    return 0;

}