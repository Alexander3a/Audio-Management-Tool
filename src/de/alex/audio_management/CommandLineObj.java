package de.alex.audio_management;

public class CommandLineObj {
    String winname;
    String input;
    String output;
    String bufferms;
    String samplingr;
    String buffers;
    String bitsps;
    String chancfg;
    String chans;
    String priority;
    String folderloc;
    String exename;
    public CommandLineObj(String winname,String input,String output,String bufferms,String samplingr,String buffers,String bitsps,String chancfg,String chans,String priority,String folderloc,String exename){
        this.winname = winname;
        this.input = input;
        this.output = output;
        this.bufferms = bufferms;
        this.samplingr = samplingr;
        this.buffers = buffers;
        this.bitsps = bitsps;
        this.chancfg = chancfg;
        this.chans = chans;
        this.priority = priority;
        this.folderloc = folderloc;
        this.exename = exename;
    }
    public String getOutput(){
        return "cmd.exe /c start " +
                "/min" +
                " \"audiorepeater\" \""+folderloc+"\\"+exename+".exe\" /WindowName:\""+winname+"\" /Input: \""+input+"\" /Output: \""+output+"\" /BufferMs:"+bufferms+" /SamplingRate:"+samplingr+" /Buffers:"+buffers+" /BitsPerSample:"+bitsps+" /ChanCfg:"+chancfg+" /Priority:"+priority+" /Autostart";
    }
}
