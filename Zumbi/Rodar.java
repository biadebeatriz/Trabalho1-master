package Zumbi;

import begin.PaginaInicial;

import javax.swing.*;

public class Rodar {
    public static void main(String[] args) {
        PaginaInicial pagina = new PaginaInicial();
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                pagina.createAndShowGUI();
            }
        });
    }
}
