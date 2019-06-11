package begin;

import Zumbi.ConsultarG;

import java.awt.event.*;

public class  AnActionListener implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Apertou o botao.");
        ConsultarG con  = new ConsultarG();
        con.main();

    }
}
