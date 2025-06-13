import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GraphicGameGrid extends JFrame{
    private static final int INT_FLAG = -1, INT_DOUBT = -2, INT_EMPTY_SQUARE = 0, NOTHING = 9;
    private static final String STRING_FLAG = "★", STRING_DOUBT = "?", STRING_NOTHING = "";
    private final int gridHeight, gridWidth, nbMine;
    private final Dimension defaultSize = new Dimension(800, 700);
    public MyJPanel[][] panelGrid = new MyJPanel[30][30];
    private JPanel gridContainer;
    public int[][] viewGrid = new int[30][30];
    public Grid grid;
    private final JLabel mineInfo = new JLabel();
    
    /**
     * appelez lors de la création d'une nouvelle grille
     * @param gridHeight0 hauteur de la grille
     * @param gridWidht0 largeur de la grille
     * @param nbMine0 nombre de mine
     */
    public GraphicGameGrid(int gridHeight0, int gridWidht0, int nbMine0){
        super("Demineur");
        this.setVisible(true);
        this.gridHeight = gridHeight0;
        this.gridWidth  = gridWidht0;
        this.nbMine = nbMine0;
        this.setSize(this.defaultSize);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.gridContainer = this.initialize();
        this.add(this.gridContainer, BorderLayout.CENTER);
        this.add(createMenuButton(), BorderLayout.SOUTH);
    }
    
    /**
     * appelez lors du chargement d'une grille
     * @param g grille
     * @param p grille de MyJPanel
     * @param v 
     */
    public GraphicGameGrid(Grid g, MyJPanel[][] p, int[][] v){
        super("Demineur");
        this.setVisible(true);
        this.grid = g;
        this.panelGrid = p;
        this.viewGrid = v;
        this.gridHeight = g.getGridHeight();
        this.gridWidth  = g.getGridWidth();
        this.nbMine = g.getNbMine();
        this.setSize(this.defaultSize);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.gridContainer = this.initialize(p);
        this.add(this.gridContainer, BorderLayout.CENTER);
        this.add(createMenuButton(), BorderLayout.SOUTH);
    }
    
    /**
     * rend le fond gris clair des MyJPanel pour les cases découverte
     */
    private void mineReveal(){
        for(int i = 0; i < gridHeight; i++){
            for(int j = 0; j < gridWidth; j++){
                if(this.grid.getGrid()[i][j] == Grid.HIDED_MINE){
                    this.panelGrid[i][j].innerText.setText("");
                    this.panelGrid[i][j].innerText.setIcon(new ImageIcon("src/image/Bomb.png"));
                }
            }
        }
    }
    
    /**
     * créez la fenetre de choix des sauvegardes
     * @param manager manager de sauvergarde pour le chargement des sauvegardes
     */
    private void createSaveMenu(SaveManager manager){
        MenuSuperclass frame = new MenuSuperclass(new Dimension(400, 400));
        frame.setLayout(new GridLayout(SaveManager.NUMBER_OF_SAVE+1, 1));
        Font font = new Font("Arial", Font.PLAIN, 30);
        
        for (int i = 0; i < SaveManager.NUMBER_OF_SAVE; i++) {
            JPanel tempPanel = new JPanel();
            tempPanel.setBackground(Color.DARK_GRAY);
            tempPanel.setOpaque(false);
            
            JLabel labelInfo = new JLabel(""+i);
            tempPanel.add(labelInfo);
            labelInfo.setOpaque(false);
            
            JLabel tempLabel = new JLabel("Sauvegarde N°"+(i+1));
            tempLabel.setFont(font);
            tempLabel.setForeground(Color.WHITE);
            tempPanel.add(tempLabel);
            
            if(manager.getlistOfFile()[i].equals("empty")){
                tempLabel.setText("Emplacement Vide");
                tempLabel.setForeground(Color.GRAY);
            }
            
            tempPanel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try{
                        int position = 0;
                        
                        try{
                            position = Integer.parseInt(labelInfo.getText())+1;
                        } catch(NumberFormatException nfe){
                            System.out.println("Unable get positions of saves");
                        }
                        
                        SavableGrid objToSave = new SavableGrid(grid, panelGrid, viewGrid);
                        manager.save(objToSave, position);
                        JOptionPane.showMessageDialog(null, "Partie sauvegardé !");
                        frame.dispose();
                        
                    } catch(Exception exception){
                        System.out.println("Unable to save the file");
                        JOptionPane.showMessageDialog(null, "Impossible de sauvegarder la partie");
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    JPanel component = (JPanel)e.getSource();
                    component.setBackground(Color.DARK_GRAY);
                    component.setOpaque(true);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    JPanel component = (JPanel)e.getSource();
                    component.setBackground(Color.WHITE);
                    component.setOpaque(false);
                }
            });
            
            frame.add(tempPanel);
        }
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int space = 2;
	gbc.insets = new Insets(space, space, space, space);
        
        MyJButton backButton = new MyJButton("src/image/Cancel.png");
        backButton.addActionListener((event) -> frame.dispose());
        backButton.setPreferredSize(new Dimension(300, 35));
        gbc.gridwidth = 1;
        gbc.gridx     = 0;
        gbc.gridy     = 0;
        buttonPanel.add(backButton , gbc);
        buttonPanel.setOpaque(false);
        
        frame.add(buttonPanel);
    }
    
    /**
     * créez les bouttons de sauvegarde et permettant de revenir au menu
     * @return panel contenant les bouttons
     */
    private JPanel createMenuButton(){
        
        JPanel southPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        MyJButton saveButton = new MyJButton("src/image/Save.png");
        saveButton.setPreferredSize(new Dimension(400, 25));
        gbc.gridwidth = 1;
        gbc.gridx     = 0;
        gbc.gridy     = 0;
        southPanel.add(saveButton , gbc);
        
        MyJButton backButton = new MyJButton("src/image/Back.png");
        backButton.setPreferredSize(new Dimension(400, 25));
        gbc.gridwidth = 1;
        gbc.gridx     = 1;
        gbc.gridy     = 0;
        southPanel.add(backButton , gbc);
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveManager manager = new SaveManager();
                createSaveMenu(manager);
            }
        });
        
        GraphicGameGrid ggg = this;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ggg.dispose();
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
        
        southPanel.setBackground(Color.BLACK);
        return southPanel;
    }
    
    /**
     * compte le nombre de drapeaux
     * @return le nombre de drapeaux
     */
    private int countFlag(){
        int nbFlag = 0;
        
        for(int i = 0; i < gridHeight; i++){
            for(int j = 0; j < gridWidth; j++){
                if(panelGrid[i][j].innerText.getText().equals(STRING_FLAG)){
                    nbFlag++;
                }
            }
        }
        
        return nbFlag;
    }
    
    /**
     * Compte le nombre de case cachés par rapport au nombre de mine
     * @return vrai si les 2 sont égale faux sinon
     */
    private boolean isThereAWin(){
        int countMine = 0;
        
        for (int i = 0; i < this.gridWidth; i++) {
            for (int j = 0; j < this.gridHeight; j++) {
                if(this.viewGrid[i][j] == NOTHING || this.viewGrid[i][j] == INT_FLAG || this.viewGrid[i][j] == INT_DOUBT){
                    countMine++;
                }
            }
        }
        
        
        if(countMine == this.nbMine){
            return true;
        }
        
        return false;
    }
    
    /**
     * revele la ces clique au coordonnées indiqués
     * @param x0 coordonnées en x de la case
     * @param y0 coordonnées en y de la case
     */
    public void leftClickUpdate(int x0, int y0){
        if(this.viewGrid[x0][y0] != INT_FLAG && this.viewGrid[x0][y0] != INT_DOUBT){
            if(DemineurToolBox.isThereAMine(this.grid, x0, y0)){
                this.mineReveal();
                this.grid.endStatue = true;
                removeListener();
                JOptionPane.showMessageDialog(null, "J'ai en ai vu des gens nuls");
                JOptionPane.showMessageDialog(null, "Mais toi niveau talent ca tend vers 0");
            } else {
                DemineurToolBox.squareReveal(this.viewGrid, this.grid, x0, y0);
                this.repaintGrid();
            }
            if(isThereAWin()){
                this.mineReveal();
                this.grid.endStatue = true;
                removeListener();
                JOptionPane.showMessageDialog(null, "C'est bien t'as gagné");
                JOptionPane.showMessageDialog(null, "T'as pas d'autres choses à faire \nque de jouer au démineur ?");
                JOptionPane.showMessageDialog(null, "Genre trouver un travail");
            }
        }
    }
    
    /**
     * appelez lors de la défaite ou la victoire et permet de retirer tous les listeners des cases
     */
    private void removeListener(){
        for(int i = 0; i < this.gridHeight; i++){
            for(int j = 0; j < this.gridWidth; j++){
                MouseListener[] ml = this.panelGrid[i][j].getMouseListeners();
                for(int k = 0; k < ml.length; k++){
                    this.panelGrid[i][j].removeMouseListener(ml[k]);
                }
            }
        }
    }
    
    /**
     * change le marqueur de la case
     * @param x0 coordonnées de la case en x
     * @param y0 coordonnées de la case en y
     */
    public void rightClickUpdate(int x0, int y0){
        if(this.viewGrid[x0][y0] == NOTHING || this.viewGrid[x0][y0] == INT_DOUBT || this.viewGrid[x0][y0] == INT_FLAG){
            String labelText = this.panelGrid[x0][y0].innerText.getText();
            JLabel label     = this.panelGrid[x0][y0].innerText;
            
            int nb = this.grid.getNbMine()-this.countFlag();
            this.mineInfo.setText("Mine restante : "+nb);
        
            if(labelText.equals(STRING_NOTHING)){
                label.setText(STRING_FLAG);
                this.viewGrid[x0][y0] = INT_FLAG;
            } else if(labelText.equals(STRING_FLAG)){
                label.setText(STRING_DOUBT);
                this.viewGrid[x0][y0] = INT_DOUBT;
            } else if(labelText.equals(STRING_DOUBT)){
                label.setText(STRING_NOTHING);
                this.viewGrid[x0][y0] = NOTHING;
            }
            this.repaintGrid();
        }
    }
    
    /**
     * initialise les panels
     * @return retourne le panel contenant les MyJPanel
     */
    private JPanel initialize(){
        
        for(int i = 0; i < 30; i++){
            Arrays.fill(this.viewGrid[i], NOTHING);
        }
        this.grid = new Grid(this.gridHeight, this.gridWidth, this.nbMine);
        
        JPanel gamePanel = new JPanel();
        GridLayout myGridLayout = new GridLayout(this.gridHeight, this.gridWidth, 1, 1);
        gamePanel.setLayout(myGridLayout);
        
        for(int i = 0; i < this.gridHeight; i++){
            for(int j = 0; j < this.gridWidth; j++){
                this.panelGrid[i][j] = new MyJPanel(i, j);
                this.panelGrid[i][j].addMouseListener(new MouseInterface(this));
                gamePanel.add(this.panelGrid[i][j]);
            }
        }
        
        this.mineInfo.setText("Mine restante : "+this.grid.getNbMine());
        this.add(this.mineInfo, BorderLayout.NORTH);
        
        return gamePanel;
    }
    
    /**
     * Initialisation lors du chargement d'une sauvegarde
     * @param gridOfMyJPanel grille contenant les cases de type MyJPanel
     * @return retourne le panel contenant les MyJPanel
     */
    private JPanel initialize(MyJPanel[][] gridOfMyJPanel){        
        JPanel gamePanel = new JPanel();
        GridLayout myGridLayout = new GridLayout(this.gridHeight, this.gridWidth, 1, 1);
        gamePanel.setLayout(myGridLayout);
        
        for(int i = 0; i < this.gridHeight; i++){
            for(int j = 0; j < this.gridWidth; j++){
                gamePanel.add(gridOfMyJPanel[i][j]);
                if(this.grid.endStatue == false){
                    gridOfMyJPanel[i][j].addMouseListener(new MouseInterface(this));
                }
            }
        }

        //this.mineInfo.setText("Mine restante : "+this.grid.getNbMine());
        //this.add(this.mineInfo, BorderLayout.NORTH);

        return gamePanel;
    }
    
    /**
     * repaint la grille
     */
    private void repaintGrid(){
        for(int i = 0; i < this.gridHeight; i++) {
            for(int j = 0; j < this.gridWidth; j++) {
                
                if(this.viewGrid[i][j] == NOTHING){
                    this.panelGrid[i][j].setBackground(Color.DARK_GRAY);
                    
                } else if (this.viewGrid[i][j] == INT_EMPTY_SQUARE){
                    this.panelGrid[i][j].setBackground(Color.GRAY);
                    this.panelGrid[i][j].setInnerText(STRING_NOTHING);
                    
                } else if(this.viewGrid[i][j] == INT_FLAG){
                    this.panelGrid[i][j].setBackground(Color.DARK_GRAY);
                    this.panelGrid[i][j].setInnerText(STRING_FLAG);
                    
                } else if(this.viewGrid[i][j] == INT_DOUBT){
                    this.panelGrid[i][j].setBackground(Color.DARK_GRAY);
                    this.panelGrid[i][j].setInnerText(STRING_DOUBT);
                    
                } else {
                    this.panelGrid[i][j].setBackground(Color.GRAY);
                    this.panelGrid[i][j].setInnerText(""+this.viewGrid[i][j]);
                }
            }
        }
    }
    
}
