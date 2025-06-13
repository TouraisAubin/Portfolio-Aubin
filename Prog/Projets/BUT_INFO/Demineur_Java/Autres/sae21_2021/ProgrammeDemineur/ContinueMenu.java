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
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ContinueMenu extends MenuSuperclass{
    private JPanel[] saveIcon = new JPanel[SaveManager.NUMBER_OF_SAVE];
    private final SaveManager sManager;
    
    /**
     * Constructeur servant à l'initialisation de la fenetre
     * @param d dimension de la fentre
     */
    public ContinueMenu(Dimension d){
        super(d);
        this.sManager = new SaveManager();
        this.add(this.createMenu(), BorderLayout.CENTER);
    }
    
    /**
     * méthode permettant de contruire le menu
     * @return Un JPanel contenant l'ensemble des éléments du menu
     */
    private JPanel createMenu(){
        
        JPanel panel = new JPanel(new GridLayout(this.saveIcon.length, 1));
        
        Font f = new Font("Arial", Font.PLAIN, 30);
        
        for(int i = 0; i < this.saveIcon.length; i++){
            this.saveIcon[i] = new JPanel(new BorderLayout());
            this.saveIcon[i].setBackground(Color.DARK_GRAY);
            this.saveIcon[i].setOpaque(false);
            
            JLabel tempLabel = new JLabel("Sauvegarde N°"+(i+1));
            tempLabel.setFont(f);
            tempLabel.setForeground(Color.WHITE);
            
            SavableGrid grid = null;
            
            if(this.sManager.getlistOfFile()[i].equals("empty")){
                tempLabel.setText("Emplacement Vide");
                tempLabel.setForeground(Color.GRAY);
                this.saveIcon[i].addMouseListener(new ContinueMenuMouseListener(0, sManager, this));
            } else {
                
                try{
                    grid = (SavableGrid)sManager.load(this.sManager.getlistOfFile()[i]);
                } catch(Exception e){
                    System.out.println("Unable to load file : "+this.sManager.getlistOfFile()[i]);
                }
                
                Font fontInfo = new Font("Arial", Font.PLAIN, 20);
                String gridInfo = "Largeur : "+grid.grid.getGridWidth()+", Hauteur : "+grid.grid.getGridHeight()+", Mine : "+grid.grid.getNbMine();
                JLabel labelInfo = new JLabel(gridInfo);
                labelInfo.setFont(fontInfo);
                labelInfo.setForeground(Color.WHITE);
                this.saveIcon[i].add(labelInfo, BorderLayout.CENTER);
                this.saveIcon[i].add(this.createMenuButton(grid, i+1), BorderLayout.EAST);
                this.saveIcon[i].addMouseListener(new ContinueMenuMouseListener(i, sManager, this));
            }
            
            this.saveIcon[i].add(tempLabel, BorderLayout.NORTH);
            
            panel.add(this.saveIcon[i]);
        }
        
        panel.setOpaque(false);
        return panel;
    }
    
    /**
     * méthode créez les boutons pour continuer et supprimer la sauvegarde
     * @param grid La sauvegarde
     * @param position Le numéro de la sauvegarde
     * @return 
     */
    private JPanel createMenuButton(SavableGrid grid, int position){
        JPanel panel = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int space = 2;
	gbc.insets = new Insets(space, space, space, space);
        
        
        MyJButton continueGame = new MyJButton("src/image/Continue.png");
        continueGame.setPreferredSize(new Dimension(300, 35));
        gbc.gridwidth = 1;
        gbc.gridx     = 0;
        gbc.gridy     = 0;
        panel.add(continueGame, gbc);
        ContinueMenu frame = this;
        continueGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GraphicGameGrid(grid.grid, grid.panelGrid, grid.viewGrid);
            }
        });
        
        MyJButton deleteGame = new MyJButton("src/image/Delete.png");
        deleteGame.setPreferredSize(new Dimension(300, 35));
        gbc.gridwidth = 1;
        gbc.gridx     = 0;
        gbc.gridy     = 1;
        panel.add(deleteGame, gbc);
        deleteGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                sManager.delete(position+".txt");
                new ContinueMenu(frame.getSize());
            }
        });
        
        
        panel.setOpaque(false);
        return panel;
    }
    
}
