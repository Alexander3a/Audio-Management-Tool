package de.alex.audio_management;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseGui extends JFrame {
    private JPanel MainGui;
    private JButton Headset;
    private JButton Headset_Box;
    private JButton Box;

    public BaseGui(){
        setVisible(true);
        setSize(233, 150);
        setTitle("BaseGui");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(MainGui);
        Headset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config_utils c = new Config_utils(Main.config_file);
                new AudioRepeaterUtils("","","").kill();
                try {
                    Thread.sleep(100);
                }catch (Exception e13){

                }
                new AudioRepeaterUtils(c.GetFromFile("Headset_output"),c.GetFromFile("input"),"").start();
            }
        });
        Headset_Box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config_utils c = new Config_utils(Main.config_file);
                new AudioRepeaterUtils("","","").kill();
                try {
                    Thread.sleep(100);
                }catch (Exception e13){
                }
                new AudioRepeaterUtils(c.GetFromFile("Headset_output"),c.GetFromFile("input"),"").start();
                new AudioRepeaterUtils(c.GetFromFile("Box_output"),c.GetFromFile("input"),"").start();
            }
        });
        Box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config_utils c = new Config_utils(Main.config_file);
                new AudioRepeaterUtils("","","").kill();
                try {
                    Thread.sleep(100);
                }catch (Exception e13){

                }
                new AudioRepeaterUtils(c.GetFromFile("Box_output"),c.GetFromFile("input"),"").start();
            }
        });
    }
}
