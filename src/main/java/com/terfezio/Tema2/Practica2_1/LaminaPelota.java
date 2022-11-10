package com.terfezio.Tema2.Practica2_1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class LaminaPelota extends JPanel {

    //A�adimos pelota a la l�mina

    public void add(Pelota b) {

        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for (Pelota b : pelotas) {

            g2.fill(b.getShape());
        }

    }

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}
