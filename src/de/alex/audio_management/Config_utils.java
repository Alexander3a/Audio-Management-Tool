package de.alex.audio_management;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Config_utils {
    File file = null;
    public Config_utils(File file){
        this.file = file;
    }

    public String GetFromFile(String var){
        ArrayList xd = null;
        try {
            xd = getfromfile(Main.config_file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        final String[] out = {""};
        xd.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                if(((String)o).startsWith(var+":=:")){
                    out[0] =(String)o;
                }
            }
        });
        return out[0].replace(var+":=:","");
    }
    public void SetFromFile(String var,String args){
        ArrayList org = null;
        try {
            org = getfromfile(Main.config_file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Creating new config file");
            try {
                JOptionPane.showMessageDialog(null,"Creating new config file");
            }catch (Exception ex){

            }
        }
        Writer.in(Main.config_file.getAbsolutePath());
        if(org!=null)
        org.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if(!s.startsWith(var+":=:")){
                    Writer.Write(s);
                }
            }
        });
        Writer.Write(var+":=:"+args);
        Writer.close();
    }
    private ArrayList getfromfile(String file) throws IOException {
//        if(!new File(file).exists()){
//            return null;
//        }
        ArrayList buf = new ArrayList();
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String text="null";
        try {
            while (!text.equals("")){
                if(!text.equals("") &&!text.equals("null")){
                    buf.add(text);
                }
                text= bufferedReader.readLine();
            }
        }catch (NullPointerException e){
            //e.printStackTrace();
        }
        return buf;
    }

}
