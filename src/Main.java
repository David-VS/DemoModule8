import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //aanmaken directory
        File testDir = new File("./files");
        testDir.mkdirs();
        //definieren file in directory
        File testFile = new File(testDir.getPath()+"/test.txt");

        //*
        //stream kan ook via command line / console
        System.out.println("Wat wil je opslaan?");
        Scanner textInput = new Scanner(System.in);

        //file maken en data wegschrijven
        try(FileWriter writer = new FileWriter(testFile) ) {
            String watMoetIkOpslaan = textInput.nextLine();
            writer.write(watMoetIkOpslaan);
        }catch(IOException e){
            System.out.println("Bestand kan niet aangemaakt worden");
        }
        //*/

        try(FileReader reader = new FileReader(testFile);
            BufferedReader bufferedReader = new BufferedReader(reader)){
            String watZitErInDeFile = bufferedReader.readLine();
            System.out.println(watZitErInDeFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}