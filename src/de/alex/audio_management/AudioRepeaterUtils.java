package de.alex.audio_management;

import java.io.IOException;

public class AudioRepeaterUtils {
    String kill = "taskkill /F /IM audiorepeater.exe";
    CommandLineObj commandLine = null;
    //String norm = "cmd.exe /c start /min \"audiorepeater\" \"%folderloc%\\%exename%.exe\" /WindowName:\"%winname%\" /Input: \"%input%\" /Output: \"%output%\" /BufferMs:%bufferms% /SamplingRate:%samplingr% /Buffers:%buffers% /BitsPerSample:%bitsps% /ChanCfg:%chancfg% /Priority:%priority% /Autostart";
    public AudioRepeaterUtils(String input,String output,String special_cfg){
        init(input,output,special_cfg);
        //System.out.println(norm);
    }
    public AudioRepeaterUtils(AudioObj audioObj){
        String input = audioObj.input;
        String output = audioObj.output;
        String special_cfg = audioObj.special_cfg;
        init(input,output,special_cfg);
        //System.out.println(norm);
    }
    private void init(String input,String output,String special_cfg){
        if(input==null){
            return;
        }
        commandLine = new CommandLineObj(input+" - "+output,input,output,new Config_utils(Main.config_file).GetFromFile("bufferms"),new Config_utils(Main.config_file).GetFromFile("samplingr"),new Config_utils(Main.config_file).GetFromFile("buffers"),new Config_utils(Main.config_file).GetFromFile("bitsps"),new Config_utils(Main.config_file).GetFromFile("chancfg"),new Config_utils(Main.config_file).GetFromFile("chans"),new Config_utils(Main.config_file).GetFromFile("priority"),new Config_utils(Main.config_file).GetFromFile("folderloc"),new Config_utils(Main.config_file).GetFromFile("exename"));
        if(special_cfg.equals("a1")){
            commandLine.bufferms=200+"";
            commandLine.samplingr=48000+"";
            commandLine.buffers=12+"";
            commandLine.bitsps=32+"";
            commandLine.chancfg="\"7.1 surround\"";
        }
        if(special_cfg.equals("a3")){
            commandLine.bufferms=200+"";
            commandLine.samplingr=48000+"";
            commandLine.buffers=12+"";
            commandLine.bitsps=16+"";
            commandLine.chancfg="\"7.1 surround\"";
        }
        if(special_cfg.equals("a4")){
            commandLine.bufferms=200+"";
            commandLine.samplingr=48000+"";
            commandLine.buffers=12+"";
            commandLine.bitsps=16+"";
            commandLine.chancfg="\"7.1 surround\"";
        }
        if(special_cfg.equals("a5")){
            commandLine.bufferms=500+"";
            commandLine.samplingr=48000+"";
            commandLine.buffers=12+"";
            commandLine.bitsps=16+"";
            commandLine.chancfg="\"7.1 surround\"";
        }
        //System.out.println(commandLine.getOutput());
    }
    public void start(){
        excCommand(commandLine.getOutput());
    }
    public void kill(){
        excCommand(kill);
    }
    private void excCommand(String new_dir){
        System.out.println("exec: " +new_dir);
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(new_dir);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
