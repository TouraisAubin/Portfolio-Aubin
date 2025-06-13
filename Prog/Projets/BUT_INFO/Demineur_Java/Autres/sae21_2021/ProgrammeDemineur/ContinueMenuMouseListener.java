import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


public class ContinueMenuMouseListener implements MouseListener{
    private final ContinueMenu parentFrame;
    private final int position;
    private final SaveManager manager;
    
    /**
     * 
     * @param i numero de la sauvegarde
     * @param s manager de sauvegarde permettant les action relives aux sauvegardes
     * @param parentFrame0 fenetre ayant appelé ce listener
     */
    public ContinueMenuMouseListener(int i, SaveManager s, ContinueMenu parentFrame0){
        this.position    = i;
        this.parentFrame = parentFrame0;
        this.manager     = s;
    }
    
    /**
     * Charge la sauvegarde relative a la position de cet objet
     * @param e evenement
     */
    @Override
    public void mouseClicked(MouseEvent e){
        JPanel source = (JPanel)e.getSource();
        if(position != 0){
            this.parentFrame.dispose();
            try{
                SavableGrid grid = (SavableGrid)manager.load((position+1)+".txt");
                GraphicGameGrid game = new GraphicGameGrid(grid.grid, grid.panelGrid, grid.viewGrid);
            } catch(Exception exception){
                System.err.println("Unable to load game");
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e){}
    
    @Override
    public void mouseReleased(MouseEvent e){}
    
    /**
     * Colorie le fond en gris foncé au survol
     * @param e evenement
     */
    @Override
    public void mouseEntered(MouseEvent e){
        JPanel component = (JPanel)e.getSource();
        component.setBackground(Color.DARK_GRAY);
        component.setOpaque(true);
    }
    
    /**
     * Rend le fons transparent à la fin du survol
     * @param e evenement
     */
    @Override
    public void mouseExited(MouseEvent e){
        JPanel component = (JPanel)e.getSource();
        component.setBackground(Color.WHITE);
        component.setOpaque(false);
    }
}
