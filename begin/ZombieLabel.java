package begin;


import java.awt.*;
import javax.swing.*;

public class ZombieLabel {
    private int n;
    ZombieLabel(int n){
        this.n = n;
    }

    private ImageIcon scaleImage(ImageIcon notscaled, int w, int h){
        Image scaleim = notscaled.getImage().getScaledInstance(w,h,Image.SCALE_SMOOTH);
        ImageIcon sc = new ImageIcon(scaleim);
        return sc;
    }

    public JLabel getLabelZombie(){
        ImageIcon im = new ImageIcon("/home/beatriz/IdeaProjects/Begin/imagens/zombie/zombie4.jpg");
        ImageIcon scaleim = this.scaleImage(im, 200,300);
        JLabel label = new JLabel(scaleim, JLabel.LEFT);

        return label;
    }


}