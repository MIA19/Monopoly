package de.mia19.game;

/**
 * Created by e6_reich on 22/06/2017.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Stats {


    /**
     * Currently only writing to a local file in the package folder.

     */

    //TODO: TBA: Write stats to remote file or Database
    public Stats(){
        BufferedWriter writer;
        try {
            String stats = "stats" ;
            File logFile = new File(stats);

            writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.write("Stats:");


            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
