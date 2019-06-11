package begin;

import Zumbi.ConsultarG;

import java.awt.event.*;

public class  AnActionListener implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {
        ConsultarG con  = new ConsultarG();
        con.main();

    }
}
