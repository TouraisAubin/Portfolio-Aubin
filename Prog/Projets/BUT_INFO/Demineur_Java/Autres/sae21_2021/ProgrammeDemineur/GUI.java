import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JFrame{
    public JPanel contentPane;
    public static Dimension DEFAULT_DIMENSION = new Dimension(1200, 800);

    
    public GUI(){
        super("Démineur");
        this.setSize(DEFAULT_DIMENSION);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createContentPane();
        this.createMainMenu();
    }
    
    /**
     * créez les boutons
     */
    public final void createMainMenu(){
        MainMenu menu = new MainMenu(this);
    }
    
    /**
     * efface le contentPane par un nouveau qui est vide
     */
    private void createContentPane(){
        this.contentPane = new JPanel();
        this.contentPane.setLayout(new BorderLayout());
        this.setContentPane(this.contentPane);
    }
    
}
