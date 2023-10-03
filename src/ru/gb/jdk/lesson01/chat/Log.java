package ru.gb.jdk.lesson01.chat;



import java.io.*;
import java.util.ArrayList;

public class Log {
    private ArrayList<String> logArr = new ArrayList<>();
    private String nameFile;
    private boolean availability = false;

    public Log(String name){
        this.nameFile = name;
        if(new File("log_" + this.nameFile +".txt").exists()){
            reader();
            this.availability = true;
        }
    }

    public void reader() {
        try(BufferedReader reader = new BufferedReader(new FileReader("log_" + this.nameFile + ".txt")))
        {
            String line = reader.readLine();

            while (line != null) {
                logArr.add(line);
                line = reader.readLine();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void writer(){
        try(FileWriter writer = new FileWriter("log_" + this.nameFile + ".txt", false))
        {
            for(int i = 0; i < logArr.size(); i++){
                writer.write(logArr.get(i)+"\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String> getLogArr() {
        return logArr;
    }

    public boolean isAvailability() {
        return availability;
    }
}
