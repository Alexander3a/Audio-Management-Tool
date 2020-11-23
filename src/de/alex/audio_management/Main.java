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
        if(new Config_utils(config_file).GetFromFile("Debug").equals("true"))new DebugGui();
        new BaseGui();
    }
}
