package commands;

import worker.MapWorker;
import worker.Worker;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Command implements Executable, Serializable {
//    transient Scanner cin = new Scanner(System.in);
    transient ObjectOutputStream oos;
    private final String desc;
    String arg = "";

    public Command(String title) {
        this.desc = title;
    }

    public String getDesc() {
        return desc;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

//    public void setCin(Scanner cin) {
//        this.cin = cin;
//    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public String sort(LinkedHashMap<Long, Worker> workers){
        StringBuilder sb=new StringBuilder();
        List<Long> keys = workers.keySet().stream().sorted().collect(Collectors.toList());
        for(Long id:keys){
            sb.append(id+"="+workers.get(id).toString()+"\n");
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}