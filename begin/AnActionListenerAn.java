package begin;

import Zumbi.ConsultarAn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  AnActionListenerAn implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Apertou o botao.");
        ConsultarAn con  = new ConsultarAn();
        con.main();
        // Principal pri = new Principal();
        //  pri.main();
    }
}
