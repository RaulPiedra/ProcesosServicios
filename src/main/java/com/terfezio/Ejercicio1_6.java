package com.terfezio;

import java.io.*;

public class Ejercicio1_6 {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();

        if (args.length != 3) {
            System.out.println("Comando invalido. Uso: ");
            System.out.println("comando origen texto destino");
        }
        else {
            String[] commands = {"grep", args[1], args[0]};
            Process process = runtime.exec(commands);



            InputStreamReader isr = new InputStreamReader(process.getInputStream());
            BufferedReader stdInput = new BufferedReader(isr);

            InputStreamReader isr2 = new InputStreamReader(process.getErrorStream());
            BufferedReader stdError = new BufferedReader(isr2);


            String string = null;
            PrintWriter pw = new PrintWriter(args[2]);

            while ((string = stdInput.readLine()) != null) {
                System.out.println(string);
                pw.write(string + "\n");
            }
            pw.write("\n");
            pw.close();

        }


    }
}
