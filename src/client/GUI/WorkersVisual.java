package client.GUI;

import commands.WorkerInfo;
import worker.*;

import javax.naming.NamingEnumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedHashMap;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static java.lang.Thread.sleep;

public class WorkersVisual extends JPanel {

    JPanel world;
    MapColor color;
    static LinkedHashMap<Long,Worker> workers;

    public WorkersVisual() {
//        new MapWorker();
        workers=WorkersTable.workers;
        world=new JPanel();
        color = new MapColor();
//        GraphicsConfiguration gc= canvas.getGraphicsConfiguration();
//        paint(canvas.getGraphics());
    }

    @Override
    public void paintComponent(Graphics g) {
        for (Long id : workers.keySet()) {
            System.out.println(workers);
            String owner = workers.get(id).getOwner();
            drawWorker(workers.get(id), g, color.get(owner));
        }
    }


    public void drawWorker(Worker worker, Graphics g, Color color) {

        Graphics2D g2d=(Graphics2D) g;
        int x = worker.getCoordinates().getX().intValue(), y = (int) Math.round(worker.getCoordinates().getY());
//        try {
            g2d.setColor(color);
            g2d.fillOval(x, y, 32, 32);
//            sleep(500);
            g2d.setColor(Color.black);
            g2d.fillOval(x + 8, y + 8, 5, 5);
//            sleep(500);
            g2d.fillOval(x + 19, y + 8, 5, 5);
//            sleep(500);
            g2d.drawLine(x + 8, y + 19, x + 23, y + 19);
//            sleep(500);
            g2d.drawLine(x + 16, y + 32, x + 16, y + 72);
//            sleep(500);
            g2d.drawLine(x, y + 45, x + 32, y + 45);
//            sleep(500);
            g2d.drawLine(x + 16, y + 72, x, y + 88);
//            sleep(500);
            g2d.drawLine(x + 16, y + 72, x + 32, y + 88);
//            sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() > x && e.getX() < x + 32 && e.getY() > y && e.getY() < y + 88) {
                    System.out.println(worker);
                    Thread info = new Thread(() -> {
                        WorkerInfo workerInfo = new WorkerInfo(worker);
                        workerInfo.setVisible(true);
                        try {
                            sleep(5000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        workerInfo.setVisible(false);
                    });
                    info.start();
                }
            }

        });
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    //    public static void fill() {
//        workers.put(getRandId(), new Worker("Loginity","Чоршанбе", new Coordinates(123f, 123), 1d, Status.FIRED, new Organization(123, OrganizationType.GOVERNMENT)));
//        workers.put(getRandId(), new Worker("qwer","Мариф", new Coordinates(455f, 1), 12345d, Status.RECOMMENDED_FOR_PROMOTION, new Organization(123, OrganizationType.GOVERNMENT)));
//        workers.put(getRandId(), new Worker("qwer","Азизхан", new Coordinates(989f, 28), 12345d, Status.FIRED, new Organization(123, OrganizationType.GOVERNMENT)));
//        workers.put(getRandId(), new Worker("User","Хейбати", new Coordinates(050f, 39), 12345d, new Organization(123, OrganizationType.GOVERNMENT)));
//        workers.put(getRandId(), new Worker("Loginity","Шамиль", new Coordinates(940f, 1), 12345d, new Organization(123, OrganizationType.GOVERNMENT)));
//        workers.put(getRandId(), new Worker("zxcvb","Шовхал", new Coordinates(409f, 4671), 12345d, Status.REGULAR, new Organization(123, OrganizationType.GOVERNMENT)));
//        workers.put(getRandId(), new Worker("asadfgg","Эмиль", new Coordinates(1250f, 567), 12345d, new Organization(123, OrganizationType.GOVERNMENT)));
//        workers.put(getRandId(), new Worker("asadfgg","Асхаб", new Coordinates(1000f, 594), 12345d, Status.REGULAR, new Organization(123, OrganizationType.GOVERNMENT)));
//        workers.put(getRandId(), new Worker("qwer","Арби", new Coordinates(565f, 642), 12345d, Status.REGULAR, new Organization(123, OrganizationType.GOVERNMENT)));
//    }
    static private Long getRandId() {
        long id = (long) (Math.random() * 10000 + 2341);
        while (MapWorker.getWorkers().containsKey(id)) {
            id = (long) (Math.random() * 10000 + 2341);
        }
        return id;
    }

}
