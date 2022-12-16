package com.terfezio.Tema2.Practica2_1;

import java.awt.*;

public class PelotaHilos extends Thread {
    private Pelota pelota;
    private Component component;

    public PelotaHilos(Pelota pelota, Component component) {
        this.pelota = pelota;
        this.component = component;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3000; i++) {
            pelota.mueve_pelota(component.getBounds());
            component.paint(component.getGraphics());
        }
    }
}
