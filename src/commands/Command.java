package commands;

import worker.MapWorker;
import worker.Worker;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Command extends RecursiveTask<String> implements Executable, Serializable {
//    transient Scanner cin = new Scanner(System.in);
    transient ObjectOutputStream oos;
    private final String desc;
    String arg = "";
    String login;
    Lock lock=new ReentrantLock();


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

    @Override
    public String execute() throws IOException, ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    protected String compute() {
        lock.lock();
        try {
            return execute();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return "";
    }

    


    public void setLogin(String login) {
        this.login = login;
    }


}