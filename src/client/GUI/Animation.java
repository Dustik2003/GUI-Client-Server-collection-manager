package client.GUI;

import commands.WorkerInfo;
import worker.Worker;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class Animation extends Thread{
    public static WorkersVisual workersVisual;

//    public Animation(WorkersVisual workersVisual) {
//    }

    @Override
    public void run() {
        workersVisual = new WorkersVisual();
    }
}
