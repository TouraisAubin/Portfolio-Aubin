import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GridSizeAsk extends MenuSuperclass{
    protected final Dimension defaultSize = new Dimension(800, 700);
    private final int[] insetsValue = {0, 0, 5, 5};
    private JTextField[] textGridDimension = new JTextField[3];
    public int DefaultGridHeight = 20;
    public int DefaultGridWidth  = 20;
    public int DefaultNbMine     = 40;
    
    
    public GridSizeAsk(GUI frame0){
        super();
        JPanel panel = createMenu();
        panel.setOpaque(false);
        this.add(panel);        
    }
    
    /**
     * créé toute JComponent à l'écran
     * @return panel contenant tout les composants
     */
    private JPanel createMenu(){
        JPanel centerPanel = new JPanel(new GridBagLayout());
                
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.insets = new Insets(this.insetsValue[0], this.insetsValue[1], this.insetsValue[2], this.insetsValue[3]);
        
        JLabel inputIndication = new JLabel("Hauteur (entre 4 et 30) : ");
        inputIndication.setForeground(Color.WHITE);
        inputIndication.setFont(new Font("Arial", Font.PLAIN, 25));
        gbc.gridwidth = 2;
        gbc.gridx     = 0;
        gbc.gridy     = 0;
        centerPanel.add(inputIndication , gbc);
        
        JTextField inputHeight = new JTextField(""+this.DefaultGridHeight);
        inputHeight.setHorizontalAlignment(JTextField.CENTER);
        this.textGridDimension[0] = inputHeight;
        inputHeight.setBackground(Color.BLACK);
        inputHeight.setForeground(Color.WHITE);
        inputHeight.setPreferredSize(new Dimension(400, 25));
        gbc.gridwidth = 2;
        gbc.gridx     = 0;
        gbc.gridy     = 1;
        centerPanel.add(inputHeight , gbc);
        
        //----------------------------------------------------------------------
        
        gbc.gridwidth = 2;
        gbc.gridx     = 0;
        gbc.gridy     = 2;
        JLabel inputIndication2 = new JLabel("Largeur (entre 4 et 30) : ");
        inputIndication2.setForeground(Color.WHITE);
        inputIndication2.setFont(new Font("Arial", Font.PLAIN, 25));
        centerPanel.add(inputIndication2 , gbc);
        
        
        JTextField inputWidth = new JTextField(""+this.DefaultGridWidth);
        inputWidth.setHorizontalAlignment(JTextField.CENTER);
        this.textGridDimension[1] = inputWidth;
        inputWidth.setBackground(Color.BLACK);
        inputWidth.setForeground(Color.WHITE);
        inputWidth.setPreferredSize(new Dimension(400, 25));
        gbc.gridwidth = 2;
        gbc.gridx     = 0;
        gbc.gridy     = 3;
        centerPanel.add(inputWidth , gbc);
        
        //----------------------------------------------------------------------
        
        gbc.gridwidth = 2;
        gbc.gridx     = 0;
        gbc.gridy     = 4;
        JLabel inputIndication3 = new JLabel("Nombre de mine : ");
        inputIndication3.setForeground(Color.WHITE);
        inputIndication3.setFont(new Font("Arial", Font.PLAIN, 25));
        centerPanel.add(inputIndication3 , gbc);
        
        JTextField inputNbMine = new JTextField(""+this.DefaultNbMine);
        inputNbMine.setHorizontalAlignment(JTextField.CENTER);
        this.textGridDimension[2] = inputNbMine;
        inputNbMine.setBackground(Color.BLACK);
        inputNbMine.setForeground(Color.WHITE);
        inputNbMine.setPreferredSize(new Dimension(400, 25));
        gbc.gridwidth = 2;
        gbc.gridx     = 0;
        gbc.gridy     = 5;
        centerPanel.add(inputNbMine , gbc);
        
        //----------------------------------------------------------------------
        
        MyJButton createGrid = new MyJButton("src/image/Create-New-Grid.png");
        gbc.gridwidth = 2;
        gbc.gridx     = 0;
        gbc.gridy     = 6;
        centerPanel.add(createGrid , gbc);
        createGrid.addActionListener(this::getGridDimension);
        
        return centerPanel;
    }
    
    /**
     * recupère l'évènement du bouton qui créer la nouvelle grille
     * @param event évènement
     */
    private void getGridDimension(ActionEvent event){
        int height = -1, width = -1, nbMine = -1;
        try{
            height = Integer.parseInt(this.textGridDimension[0].getText());
            width  = Integer.parseInt(this.textGridDimension[1].getText());
            nbMine = Integer.parseInt(this.textGridDimension[2].getText());
            if(height <= 30 && 4 <= height && width <= 30 && 4 <= width){
                if(nbMine < height*width){
                    if(nbMine == 0){
                        JOptionPane.showMessageDialog(null, "Félicitations tu es un lâche... \nou un génie... \nj'ai encore du mal à cerner");
                        JOptionPane.showMessageDialog(null, "Ca se voit toi tu joues\n pas à la roulette russe\nparceque c'est 'dangereux'");
                    } else if(nbMine <= 4){
                        JOptionPane.showMessageDialog(null, "On va dire que t'as pas le goût du risque toi");
                        JOptionPane.showMessageDialog(null, "Sérieusement met un vrai chiffre");
                        JOptionPane.showMessageDialog(null, "Au moins au dessus de 5");
                        JOptionPane.showMessageDialog(null, "Flipette");
                    } else {
                        changeWindow(height, width, nbMine);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "T'es au courant que t'as mis \nplus de mine qu'il y a de cases ?");
                    JOptionPane.showMessageDialog(null, "T'es suicidaire ?");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Qu'est-ce que t'as pas compris dans : \n'Saisissez une valeur en 4 et 30' ?");
                JOptionPane.showMessageDialog(null, "J'ai du mal à savoir si t'es illettré,\njuste un peu débile ou sournois");
                JOptionPane.showMessageDialog(null, "Je pense que j'ai une réponse mais pas sûr\nqu'elle te plaise");
            
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Tu trouves ça drôle de saisir des lettres \nà la place des chiffres ?");
            JOptionPane.showMessageDialog(null, "T'es parents ils en penseraient quoi ?");
            JOptionPane.showMessageDialog(null, "Je suis sûr t'es du genre à pas tenir la porte");
            JOptionPane.showMessageDialog(null, "Ou du genre à préférer l'heure d'hiver");
            JOptionPane.showMessageDialog(null, "Ou pire à laisser une seule feuille de PQ");
            }
    }

    /**
     * passe de cette fenêtre à la fenêtre de jeux
     * @param height0 hauteur de la grille
     * @param width0 largeur de la grille
     * @param nbMine0 nombre de mines de la grille
     */
    private void changeWindow(int height0, int width0, int nbMine0){
        this.dispose();
        GraphicGameGrid gameGrid = new GraphicGameGrid(height0, width0, nbMine0);
    }
    
}
