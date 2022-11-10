package com.terfezio.Tema2.Practica2_1;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


// L�mina que dibuja las pelotas----------------------------------------------------------------------


//Marco con l�mina y botones------------------------------------------------------------------------------

public class MarcoRebote extends JFrame{

	public MarcoRebote(){

		setBounds(600,300,400,350);

		setTitle ("Rebotes");

		lamina=new LaminaPelota();

		add(lamina, BorderLayout.CENTER);

		JPanel laminaBotones=new JPanel();

		ponerBoton(laminaBotones, "Dale!", new ActionListener(){

			public void actionPerformed(ActionEvent evento){

				//comienza_el_juego();
				Pelota pelota = new Pelota();
				lamina.add(pelota);
				PelotaHilos pelotaHilos = new PelotaHilos(pelota, lamina );
				pelotaHilos.start();
			}

		});


		ponerBoton(laminaBotones, "Salir", new ActionListener(){

			public void actionPerformed(ActionEvent evento){

				System.exit(0);

			}

		});

		add(laminaBotones, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	//Ponemos botones

	public void ponerBoton(Container c, String titulo, ActionListener oyente){

		JButton boton=new JButton(titulo);

		c.add(boton);

		boton.addActionListener(oyente);

	}

	//A�ade pelota y la bota 1000 veces

	public void comienza_el_juego (){


			Pelota pelota=new Pelota();

			lamina.add(pelota);

			for (int i=1; i<=3000; i++){

				pelota.mueve_pelota(lamina.getBounds());

				lamina.paint(lamina.getGraphics());

			}



	}

	private LaminaPelota lamina;


	public static void main(String[] args) {
		JFrame marco=new MarcoRebote();

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);
	}
}
