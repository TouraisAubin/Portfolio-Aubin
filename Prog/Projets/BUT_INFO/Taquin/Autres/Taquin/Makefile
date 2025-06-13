but : taquin

OFILES =  	affichage.o \
			main.o \

CC = gcc

CFLAGS = -Wall -ansi -pedantic -g


affichage.o : affichage.c affichage.h
	gcc -c affichage.c affichage.h
main.o : main.c 
	gcc -c main.c

taquin : $(OFILES)
	$(CC) $(CFLAGS) -o taquin $(OFILES) -lgraph