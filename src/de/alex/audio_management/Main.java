package de.alex.audio_management;

import javax.swing.*;
import java.io.File;

public class Main {
    final static File config_file = new File(".\\c.cfg");
    public static void main(String[] args) {
        if(!config_file.exists()){
            JOptionPane.showMessageDialog(null,"No cfg file found");
            System.exit(69);
        }
        for(int i = 0;i< args.length  ;i++){
            if(args[i].equals("-auto")){
                Config_utils c = new Config_utils(Main.config_file);
                new AudioRepeaterUtils("","","").kill();
                try {
                    Thread.sleep(100);
                }catch (Exception e13){
                }
                new AudioRepeaterUtils(c.GetFromFile("input"),c.GetFromFile("Headset_output"),"").start();
                new AudioRepeaterUtils(c.GetFromFile("input"),c.GetFromFile("Box_output"),"").start();
                System.exit(13);
            }
        }

        if(new Config_utils(config_file).GetFromFile("Debug").equals("true"))new DebugGui();
        new BaseGui();
    }
}
