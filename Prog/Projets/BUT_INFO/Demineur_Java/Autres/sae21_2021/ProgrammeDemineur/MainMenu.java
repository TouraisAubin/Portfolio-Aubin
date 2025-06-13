import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class MainMenu {
    private final GUI frame;
    private MyJButton[] menuButton;
    private final String backgroundPath = "src/image/background-V2.png";
    private final String[] imageButtonPath = {
            "src/image/New-Game.png",
            "src/image/Continue.png",
            "src/image/Success.png",
            "src/image/Option.png",
            "src/image/Quit-Game.png",
        };
    
    /*
    gridBagCoorAndDimension[i][0] = GridBagConstraints.gridwidth
    gridBagCoorAndDimension[i][1] = GridBagConstraints.gridx
    gridBagCoorAndDimension[i][2] = GridBagConstraints.gridy
    gridBagCoorAndDimension[i][3] = Preferred Width Size
    gridBagCoorAndDimension[i][4] = Preferred Height Size
    */
    private final int[][] gridBagCoorAndDimension = {
            {2, 0, 0, 400, 35},
            {2, 0, 1, 400, 35},
            {2, 0, 2, 400, 35},
            {1, 0, 3, 200, 35},
            {1, 1, 3, 200, 35},
        };
    
    private final int[] insetsValue = {0, 0, 5, 5};
        
    /**
     * intialise les boutons du menu et leur ajoute leur ActionListener
     * @param frame0 fenêtre dans laquelle sont disposé ces bontons de menu
     */
    public MainMenu(GUI frame0){
        this.frame = frame0;
        
        this.paintBackground(this.backgroundPath);
        JPanel buttonPanel = this.createMenuButton();
        buttonPanel.setOpaque(false);
        this.frame.add(buttonPanel, BorderLayout.CENTER);
                
        this.menuButton[0].addActionListener(this::newGameButtonAction);
        this.menuButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContinueMenu(frame.DEFAULT_DIMENSION);
                frame.dispose();
            }
        });
        this.menuButton[2].addActionListener((event) -> JOptionPane.showMessageDialog(null, "Nan JE DECONNE \n\nj'ai pas eu le temps"));
        this.menuButton[3].addActionListener((event) -> JOptionPane.showMessageDialog(null, "C'est juste de la déco"));
        this.menuButton[4].addActionListener((event) -> this.frame.dispose());
    }
    
    /**
     * Dessine le fond d'écran du menu
     * @param imagePath chemin vers l'image à mettre en fond
     */
    private void paintBackground(String imagePath){
        Image img = Toolkit.getDefaultToolkit().getImage(imagePath);
        
        this.frame.setContentPane(new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, (frame.getWidth()/2)-(img.getWidth(null)/2), 0, this);
            }
        });
        this.frame.setLayout(new BorderLayout());
    }
    
    /**
     * change de fenêtre ferme celle ci et ouvre la suivante
     * @param event évènement
     */
    private void newGameButtonAction(ActionEvent event){
        this.frame.dispose();
        GridSizeAsk sizeInput = new GridSizeAsk(this.frame);
    }
    
    /**
     * créé les boutons du menu
     * @return panel contenant les boutons du menu
     */
    private JPanel createMenuButton(){
      
        this.menuButton = new MyJButton[5];

        JPanel centerPanel = new JPanel(new GridBagLayout());
                
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.insets = new Insets(this.insetsValue[0], this.insetsValue[1], this.insetsValue[2], this.insetsValue[3]);
        
        
        for(int i = 0; i < this.imageButtonPath.length; i++){
            this.menuButton[i] = new MyJButton(this.imageButtonPath[i]);
            this.menuButton[i].setPreferredSize(new Dimension(this.gridBagCoorAndDimension[i][3], this.gridBagCoorAndDimension[i][4]));
            gbc.gridwidth = this.gridBagCoorAndDimension[i][0];
            gbc.gridx     = this.gridBagCoorAndDimension[i][1];
            gbc.gridy     = this.gridBagCoorAndDimension[i][2];
            centerPanel.add(this.menuButton[i] , gbc);
        }
        
        return centerPanel;
    }
    
    
}
