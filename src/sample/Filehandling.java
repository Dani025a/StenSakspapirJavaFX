package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Filehandling {

    public void save(Gamedata gameData) throws IOException {
        File file = new File("spildata.txt");
        PrintWriter output = new PrintWriter(file);
        // Nu skal vi bare skrive data
        output.println(gameData.computerScore);
        output.println(gameData.playerScore);
        // Når du lukker filen, så gemmes det
        output.close();
    }

    public Gamedata load() throws FileNotFoundException {
        File file = new File("spildata.txt");
        Scanner input = new Scanner(file);
        Gamedata gameData = new Gamedata();
        gameData.playerScore = input.next();
        gameData.computerScore = input.next();
        return gameData;
    }

}