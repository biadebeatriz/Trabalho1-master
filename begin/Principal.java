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

public class Principal {

    private static void FramePrincipal() {
        //Create and set up the window.
        JFrame frame = new JFrame("Unhealh Zombie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Doctor
        DoctoraLabel Doctora = new DoctoraLabel(1);
        JLabel LDoctora = Doctora.getLabelDoctora1();

        //Zombie
        ZombieLabel Zombie = new ZombieLabel(1);
        JLabel LZombie = Zombie.getLabelZombie();


        //Create the menu bar.  Make it have a green background.
        JMenuBar greenMenuBar = new JMenuBar();
        greenMenuBar.setOpaque(true);
        greenMenuBar.setBackground(new Color(154, 165, 127));
        greenMenuBar.setPreferredSize(new Dimension(200, 20));

        //String Label
        StringLabel sl = new StringLabel("Oque vc quer sua porra de zombie");



        JPanel panel = new JPanel(new BorderLayout());
        panel.add(LDoctora,BorderLayout.EAST);
        panel.add(LZombie,BorderLayout.WEST);
        panel.add(sl.getStringLabel(),BorderLayout.PAGE_END);

        frame.add(panel);
        //frame.add(panelzombie);
        frame.setJMenuBar(greenMenuBar);
        frame.setBackground(Color.WHITE);
        frame.setSize(600,600);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {;
                FramePrincipal();
            }
        });
    }

}
