import java.awt.BorderLayout;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class MyJPanel extends JPanel implements Serializable{
    public final int x, y;
    public final JLabel innerText = new JLabel("", SwingConstants.CENTER);

    /**
     * créé un JPanel gris avec un label à l'intérieur
     * @param x0 coordonnées du panel dans la grille en x
     * @param y0 coordonnées du panel dans la grille en y
     */
    public MyJPanel(int x0, int y0) {
        this.x = x0;
        this.y = y0;
        this.setBackground(Color.DARK_GRAY);
        this.innerText.setForeground(Color.ORANGE);
        this.setLayout(new BorderLayout());
        this.add(this.innerText, BorderLayout.CENTER);
    }

    /**
     * créé un JPanel gris avec un label à l'intérieur
     * @param x0 coordonnées du panel dans la grille en x
     * @param y0 coordonnées du panel dans la grille en y
     * @param text text à mettre dans le label
     */
    public MyJPanel(int x0, int y0, String text) {
        this.x = x0;
        this.y = y0;
        this.setBackground(Color.DARK_GRAY);
        this.innerText.setText(text);
        this.innerText.setForeground(Color.ORANGE);
        this.setLayout(new BorderLayout());
        this.add(this.innerText, BorderLayout.CENTER);
    }
    
    /**
     * change le texte du JLabel
     * @param text text à écrire
     */
    public void setInnerText(String text){
        this.innerText.setText(text);
    }
}
