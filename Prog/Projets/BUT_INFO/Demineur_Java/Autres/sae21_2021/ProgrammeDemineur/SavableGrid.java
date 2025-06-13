import java.io.Serializable;


public class SavableGrid implements Serializable{
    public final Grid grid;
    public final MyJPanel[][] panelGrid;
    public final int[][] viewGrid;
    
    /**
     * contient tout les types de grille permettant à l'application de charger une grille
     * @param g grille (représentattion en machine de la grille)
     * @param p grille de panel (permet l'affichage)
     * @param v grille contenant les iformation à mettre dans les panel
     */
    public SavableGrid(Grid g, MyJPanel[][] p, int[][] v){
        this.grid      = g;
        this.panelGrid = p;
        this.viewGrid  = v;
    }
}
