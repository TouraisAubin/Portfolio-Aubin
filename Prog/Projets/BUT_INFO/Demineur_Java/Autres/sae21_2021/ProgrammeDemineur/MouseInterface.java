import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInterface implements MouseListener{    
    private final GraphicGameGrid frame;
    
    public MouseInterface(GraphicGameGrid frame0){
        this.frame = frame0;
    }
    /**
     * détermine si quel clic de la souris c'est
     * @param e evenement
     */
    @Override
    public void mouseClicked(MouseEvent e){
        MyJPanel panel = (MyJPanel)e.getSource();
        
        String click = "none";
        
        switch(e.getButton()){
            case 1: click = "BUTTON1";
            break;
            case 2: click = "BUTTON2";
            break;
            case 3: click = "BUTTON3";
            break;
        }
        if(click.equals("BUTTON1")){
            this.frame.leftClickUpdate(panel.x, panel.y);
        }else if(click.equals("BUTTON3")){
            this.frame.rightClickUpdate(panel.x, panel.y);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e){}
    
    @Override
    public void mouseReleased(MouseEvent e){}
    
    @Override
    public void mouseEntered(MouseEvent e){}
    
    @Override
    public void mouseExited(MouseEvent e){}
}
