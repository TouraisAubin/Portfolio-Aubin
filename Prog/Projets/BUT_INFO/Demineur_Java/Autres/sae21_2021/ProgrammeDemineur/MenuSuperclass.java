import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MenuSuperclass extends JFrame{
    protected Dimension defaultSize = new Dimension(800, 700);
    private String imagePath = "src/image/dirt_block.jpg";
    
    public MenuSuperclass(){
        super("Demineur");
        this.setSize(defaultSize);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.paintBackground(this.imagePath);
    }
    
    /**
     * créé une fenêtre dimension size
     * @param size taille de la fenetre
     */
    public MenuSuperclass(Dimension size){
        super("Demineur");
        this.defaultSize = size;
        this.setSize(defaultSize);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.paintBackground(this.imagePath);
    }
    
    /**
     * créé une fenetre de dimension size et utilise l'image passé en argument comme fond d'écran
     * @param size taille de fenetre
     * @param imagePath0 chemin vers l'image à mettre en fond d'écran
     */
    public MenuSuperclass(Dimension size, String imagePath0){
        super("Demineur");
        this.defaultSize = size;
        this.setSize(defaultSize);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.imagePath = imagePath0;
        this.paintBackground(this.imagePath);
    }
    
    /**
     * créé une fenetre avec l'image passé en argument comme fond d'écran
     * @param imagePath0 chemin vers l'image à mettre en fond d'écran
     */
    public MenuSuperclass(String imagePath0){
        super("Demineur");
        this.setSize(defaultSize);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.imagePath = imagePath0;
        this.paintBackground(this.imagePath);
    }
    
    /**
     * Dessine le fond d'écran
     * @param imagePath chemin vers l'image a mettre en fond d'écran
     */
    private void paintBackground(String imagePath){
        Image img = Toolkit.getDefaultToolkit().getImage(imagePath);
        
        this.setContentPane(new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                for (int j = 0; j*img.getHeight(this) < this.getHeight(); j++) {
                    for(int i = 0; i*img.getWidth(this) < this.getWidth(); i++){
                        g.drawImage(img, i*img.getWidth(this), j*img.getHeight(this), this);
                    }
                }
            }
        });
        this.setLayout(new BorderLayout());
    }
    
}
