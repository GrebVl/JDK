package ru.gb.jdk.lesson02.seminar02.task02;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogServerListener implements BaseListener{

    private File logFile;

    LogServerListener(String filename) throws IOException {
        logFile = new File(filename);
        if (!logFile.exists()){
            logFile.createNewFile();
        }
    }

    @Override
    public void genereateMessage(String msg) {
        msg =  LocalDateTime.now().toString() + " "  + msg;
        try (BufferedReader tempReader = new BufferedReader(new FileReader(this.logFile))) {
            List<String> lines = new ArrayList<>();
            while(tempReader.readLine() != null){
                lines.add(tempReader.readLine());
            }
            BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.logFile));
            for (String line : lines) {
                fileStream.append(line);
                fileStream.newLine();
            }
            fileStream.write(msg);
            fileStream.newLine();
            fileStream.flush();
            fileStream.close();
            tempReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
