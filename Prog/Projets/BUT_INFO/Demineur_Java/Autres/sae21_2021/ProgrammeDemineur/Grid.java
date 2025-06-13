import java.io.Serializable;
import java.util.Random;


public class Grid implements Serializable{
    static final int HIDED_SQUARE = 0, DISCOVERED_SQUARE = 1, HIDED_MINE = 2, EXPLODED_MINE = 3;
    static final int ABSOLUTE_WIDTH = 30, ABSOLUTE_HEIGHT = 30;
    private final int[][] minedGrid = new int[ABSOLUTE_HEIGHT][ABSOLUTE_WIDTH];
    private final int height, width, nbMine;
    public boolean endStatue = false;
    
    /**
     * initialise les valeurs
     * @param height0 = hauteur de la grille
     * @param width0 = largeur de la grille
     * @param nbMine0 = nombre de mine
     */
    public Grid(int height0, int width0, int nbMine0){
        this.height = height0;
        this.width  = width0;
        this.nbMine = nbMine0;
        
        this.fillGridWithMine(this.nbMine);
    }
    
    /**
     * remplie la grille avec le nombre de mine indiqué
     * @param nbMine0 nombre de mine à mettre dans la grille
     */
    private void fillGridWithMine(int nbMine0){
        Random randomGenerator = new Random();
        int x, y;
        
        for(int i = 0; i < nbMine0; i++){
            x = randomGenerator.nextInt(this.width);
            y = randomGenerator.nextInt(this.height);
            
            if(this.minedGrid[y][x] != DISCOVERED_SQUARE){
                this.minedGrid[y][x] = HIDED_MINE;
            } else {
                i = i-1;
            }
        }
    }
    
    /**
     * affiche la grille
     */
    public void printGrid(){
        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                System.out.print(this.minedGrid[i][j]+" ,");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    /**
     * affiche la grille dans sa taille absolue
     */
    public void printFullGrid(){
        for(int i = 0; i < ABSOLUTE_HEIGHT; i++){
            for(int j = 0; j < ABSOLUTE_WIDTH; j++){
                System.out.print(this.minedGrid[i][j]+" ,");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    /**
     * permet de changer la valeur d'une case de la grille
     * @param x0 coordonnées en x de la case
     * @param y0 coordonnées en y de la case
     * @param squareCode0 valeur a set
     */
    public void setGrid(int x0, int y0, int squareCode0){
        if(squareCode0 == HIDED_SQUARE || squareCode0 == DISCOVERED_SQUARE || squareCode0 == HIDED_MINE || squareCode0 == EXPLODED_MINE){
            this.minedGrid[x0][y0] = squareCode0;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * retourne la grille
     * @return la grille
     */
    public int[][] getGrid(){
        return this.minedGrid;
    }
    
    /**
     * retourn la hauteur de la grille
     * @return hauteur de la grille
     */
    public int getGridHeight(){
        return this.height;
    }
    
    /**
     * retourne la largeur de la grille
     * @return largeur de la grille
     */
    public int getGridWidth(){
        return this.width;
    }
    
    /**
     * retourne le nombre de mine
     * @return nombre de mine
     */
    public int getNbMine(){
        return this.nbMine;
    }
}
