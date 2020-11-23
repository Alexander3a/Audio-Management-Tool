package de.alex.audio_management;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Writer {
    static File file;
    static BufferedWriter writer;
    public static void in(String path){
        file = new File(path);

        try {
            if(file.exists()){
                file.delete();
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            writer = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void close(){
        try {
            writer.close();
            file =null;
            writer=null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Write(String input){
        try {
            writer.write(""+input);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
