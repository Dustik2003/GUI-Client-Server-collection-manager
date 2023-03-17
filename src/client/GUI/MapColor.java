package client.GUI;

import worker.MapWorker;

import java.awt.*;
import java.util.HashMap;

public class MapColor extends HashMap<String, Color> {

    public MapColor() {
        for(Long id: WorkersTable.workers.keySet()){
            int r=(int)(Math.random()*100000)%256,g=(int)(Math.random()*100000)%256,b=(int)(Math.random()*100000)%256;
            put(WorkersTable.workers.get(id).getOwner(),new Color(r,g,b));
        }
    }
}
