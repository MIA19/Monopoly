package de.mia19.game;

/**
 * Created by e6_reich on 22/06/2017.
 */

import java.io.*;
import java.util.Scanner;

public class Stats {

    private int ueberlos = 0;


    public Stats() throws FileNotFoundException {

        increaseueberlos();

        File file = new File("stats.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int readueberlos = 0;
        while (scanner.hasNextInt()) {

            readueberlos = scanner.nextInt();
        }

        BufferedWriter writer;
        try {
            String stats = "stats";
            File logFile = new File("stats.txt");

            int gesamt = ueberlos + readueberlos;

            writer = new BufferedWriter(new FileWriter(logFile, false));
            writer.write("" + gesamt);


            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void increaseueberlos() {
        ueberlos++;

    }
}
