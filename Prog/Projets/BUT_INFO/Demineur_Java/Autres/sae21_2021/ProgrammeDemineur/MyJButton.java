import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class MyJButton extends JButton{
    /**
     * créé un JButton gris avec une image d'icone
     * @param icon image à dessiner
     */
    public MyJButton(String icon){
        super();
         
        this.setOpaque(true);
        this.setBackground(Color.GRAY);
        this.setFocusPainted(false);
                
        this.setIcon(new ImageIcon(icon));
    }
}
