package se.liu.ida.emiwi425.tddd78.tetris;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * The highscorelist is where we store our highscores. When we start at game
 * we create the list once and for all. We can via the method "saveHighscoreList" save the
 * list to a file, however we can not yet read the file back.
    */

public final class HighscoreList {

    private static final String PATH = System.getProperty("user.dir") + "/score.txt";
    private static final File FILENAME = new File(PATH);
    private static  HighscoreList instance = new HighscoreList();
    private List<Highscore> highscores = new ArrayList<>();

    public HighscoreList() {}

    public void saveHighscoreList() throws FileNotFoundException, IOException {
        if (!FILENAME.exists()) {
            throw new FileNotFoundException(PATH);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String listAsJson = gson.toJson(instance);
        FileWriter fileWriter = new FileWriter(FILENAME);
        PrintWriter printwriter = new PrintWriter(fileWriter);      //We handle this exception in the TetrisViewer.
        printwriter.print(listAsJson);
        printwriter.close();

    }

    public void readHighscoreFile() throws FileNotFoundException{
    if (!FILENAME.exists()) {
      throw new FileNotFoundException(PATH);
      }
       Gson gson = new Gson();
       JsonReader reader = new JsonReader(new FileReader(FILENAME));
       HighscoreList list = gson.fromJson(reader, HighscoreList.class);
       if(!(list.highscores.isEmpty())) {
           for (Highscore h : list.highscores) {
               instance.addHighScore(h);
           }
       }
    }


    public static HighscoreList getInstance() {
	return instance;
    }

    public List<Highscore> getHighscores() {
	return highscores;
    }

    public void addHighScore(Highscore hs){
        highscores.add(hs);
    }

    public static File getFILENAME() {
        return FILENAME;
    }
}





