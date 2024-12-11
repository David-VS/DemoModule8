package objectstreams;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Student s = new Student("Jos", "De Bouwer", LocalDate.parse("2000-06-29"));


        //aanmaken directory
        File testDir = new File("./files");
        testDir.mkdirs();
        //definieren file in directory
        File studentFile = new File(testDir.getPath() + "/student"+ LocalDate.now().toString()+".data");

        //*
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(studentFile))){

            output.writeObject(s);

        } catch (IOException e) {
            //foutafhandeling
        }
        //*/

        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(studentFile))){

            Student newStudent = (Student) input.readObject();
            System.out.println(newStudent);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
