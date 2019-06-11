package begin;

import java.awt.*;
import javax.swing.*;

public class StringLabel {
    String fala;

    public StringLabel(String fala){
        this.fala = fala;
    }

    JLabel getStringLabel(){
        JLabel label = new JLabel(this.fala);
        return label;
    }

}
