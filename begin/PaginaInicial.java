package begin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class PaginaInicial {
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GRUPO 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        //Create the menu bar.  Make it have a green background.
        JMenuBar greenMenuBar = new JMenuBar();
        greenMenuBar.setOpaque(true);
        greenMenuBar.setBackground(new Color(154, 165, 127));
        greenMenuBar.setPreferredSize(new Dimension(200, 20));

        //Create a yellow label to put in the content pane.
        JLabel yellowLabel = new JLabel();
        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));

        //Imagem do zombie
        ImageIcon wPic = new ImageIcon("/home/DAITAN/bsiqueira/IdeaProjects/Trabalho1-master/begin/imagens/imagens/zombie/zombie6.jpg");
        Image sc = wPic.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(sc);
        JLabel imagi = new JLabel(icon);

        ActionListener actionListenerG = new AnActionListener();
        ActionListener actionListenerAn = new AnActionListenerAn();


        //Bottao
        JButton buttonA = new JButton("ANIMATION");
        JButton buttonG = new JButton("TABELA");

        buttonA.addActionListener(actionListenerAn);
        buttonG.addActionListener(actionListenerG);

        //Set the menu bar and add the label to the content pane.
        frame.setJMenuBar(greenMenuBar);
        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);
        frame.getContentPane().add(imagi, BorderLayout.CENTER);
        frame.getContentPane().add(buttonA, BorderLayout.EAST);
        frame.getContentPane().add(buttonG, BorderLayout.WEST);

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }




}

