public class DemineurToolBox {
    private static final int HIDED_SQUARE = 0, DISCOVERED_SQUARE = 1, HIDED_MINE = 2, EXPLODED_MINE = 3;
    private static final int[][] COOR_NEIGHBOR = {{-1, -1}, {0, -1},{1, -1},{-1, 0},{1, 0}, {0, 0},{-1, 1},{0, 1},{1, 1}};
   
    /**
     * Vérifie si le nombre de case converte est égale au nombre de mine
     * @param viewGrid0 grille
     * @param maxMine0 nombre de mine contenu dans la grille
     * @return vrai si le nombre de case est égale au nombre de mine faux sinon
     */
    public static boolean isThereAWin(int[][] viewGrid0, int maxMine0){
        int nbMine = 0;
        
        for(int[] viewGrid01 : viewGrid0){
            for (int j = 0; j < viewGrid0[0].length; j++) {
                if (viewGrid01[j] == 9) {
                    nbMine++;
                }
                if(nbMine > maxMine0){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Révèle la case aux coordonnées indiqués et se rappel de manière récursive pour les cases adjacentes si il n'y a aucune mine autour
     * @param viewGrid0 grille
     * @param grid0 
     * @param x0 placement en x de la case à réveler
     * @param y0 placement en y de la case à révéler
     */
    public static void squareReveal(int[][] viewGrid0, Grid grid0, int x0, int y0){
        int nbMine = 0, xNeighSquare, yNeighSquare;
                
        for(int i = 0; i < 9; i++){
            xNeighSquare = x0+COOR_NEIGHBOR[i][0];
            yNeighSquare = y0+COOR_NEIGHBOR[i][1];
            
            if(xNeighSquare >= 0 && yNeighSquare >= 0 && xNeighSquare < grid0.getGridWidth() && yNeighSquare < grid0.getGridHeight()){
                if(isThereAMine(grid0, xNeighSquare, yNeighSquare) && grid0.getGrid()[xNeighSquare][yNeighSquare] != DISCOVERED_SQUARE){
                    nbMine++;
                }
            }
        }
        
        grid0.setGrid(x0, y0, DISCOVERED_SQUARE);
        viewGrid0[x0][y0] = nbMine;
        
        if(nbMine == 0){            
            for(int i = 0; i < 9; i++){
                xNeighSquare = x0+COOR_NEIGHBOR[i][0];
                yNeighSquare = y0+COOR_NEIGHBOR[i][1];
                
                if(xNeighSquare >= 0 && yNeighSquare >= 0 && yNeighSquare < grid0.getGridWidth() && xNeighSquare < grid0.getGridHeight()){
                    if(grid0.getGrid()[xNeighSquare][yNeighSquare] != DISCOVERED_SQUARE){
                        squareReveal(viewGrid0, DISCOVERED_SQUARE, grid0, xNeighSquare, yNeighSquare);
                    }
                }
            }
        }
    }
    
    
    public static void squareReveal(int[][] viewGrid0, int changingValue0, Grid grid0, int x0, int y0){
        int nbMine = 0, xNeighSquare, yNeighSquare;
                
        for(int i = 0; i < 9; i++){
            xNeighSquare = x0+COOR_NEIGHBOR[i][0];
            yNeighSquare = y0+COOR_NEIGHBOR[i][1];
            
            if(xNeighSquare >= 0 && yNeighSquare >= 0 && xNeighSquare < grid0.getGridWidth() && yNeighSquare < grid0.getGridHeight()){
                if(isThereAMine(grid0, xNeighSquare, yNeighSquare) && grid0.getGrid()[xNeighSquare][yNeighSquare] != changingValue0){
                    nbMine++;
                }
            }
        }
        
        grid0.setGrid(x0, y0, changingValue0);
        viewGrid0[x0][y0] = nbMine;
        
        if(nbMine == 0){            
            for(int i = 0; i < 9; i++){
                xNeighSquare = x0+COOR_NEIGHBOR[i][0];
                yNeighSquare = y0+COOR_NEIGHBOR[i][1];
                
                if(xNeighSquare >= 0 && yNeighSquare >= 0 && yNeighSquare < grid0.getGridWidth() && xNeighSquare < grid0.getGridHeight()){
                    if(grid0.getGrid()[xNeighSquare][yNeighSquare] != changingValue0){
                        squareReveal(viewGrid0, changingValue0, grid0, xNeighSquare, yNeighSquare);
                    }
                }
            }
        }
    }

    /**
     * Vérifie si il y une mine aux coordonnées indiqués
     * @param grid0 grille
     * @param x0 coordonnées de la case en x
     * @param y0 coordonnées de la case en y
     * @return vrai si il y a une mine faux sinon
     */
    public static boolean isThereAMine(Grid grid0, int x0, int y0){
        if(grid0.getGrid()[x0][y0] == Grid.HIDED_MINE){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * affiche une grille
     * @param grid0 grille a afficher
     * @param height0 hauteur de la grille
     * @param width0 largeur de la grille
     */
    public static void printGrid(int[][] grid0,int height0,int width0){
        for(int i = 0; i < height0; i++){
            for(int j = 0; j < width0; j++){
                System.out.print(grid0[i][j]+" ,");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
}