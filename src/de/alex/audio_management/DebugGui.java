package de.alex.audio_management;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DebugGui extends JFrame {

    private JPanel mainPannel;
    private JButton First;
    private JButton Kill;
    private JButton Third;
    private JButton Second;

    public DebugGui() {
        setVisible(true);
        setSize(450, 150);
        setTitle("DebugGui");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPannel);
        Kill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AudioRepeaterUtils("","","").kill();
            }
        });
        First.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AudioRepeaterUtils("","","").kill();
                try {
                    Thread.sleep(100);
                }catch (Exception e13){

                }
                new AudioRepeaterUtils("Line 1 (Virtual Audio Cable)","Lautsprecher (THX Spatial - Syn","a1").start();
                new AudioRepeaterUtils("Line 3 (Virtual Audio Cable)","Lautsprecher (THX Spatial - Syn","a3").start();
                new AudioRepeaterUtils("Line 4 (Virtual Audio Cable)","Lautsprecher (THX Spatial - Syn","a4").start();
                new AudioRepeaterUtils("Line 5 (Virtual Audio Cable)","Lautsprecher (THX Spatial - Syn","a5").start();
            }
        });
    }
}
