package worker;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Random;

public class MapWorker implements Serializable {

    public static LinkedHashMap<Long, Worker> workers = new LinkedHashMap<>();
    public static Date date=new Date();
    public static long id=0;
    public static void fill() {
        workers.put(getRandId(), new Worker("Loginity","Чоршанбе", new Coordinates(123f, 123), 1d, Status.FIRED, new Organization(123, OrganizationType.GOVERNMENT)));
        workers.put(getRandId(), new Worker("qwer","Мариф", new Coordinates(455f, 1), 12345d, Status.RECOMMENDED_FOR_PROMOTION, new Organization(123, OrganizationType.GOVERNMENT)));
        workers.put(getRandId(), new Worker("qwer","Азизхан", new Coordinates(989f, 28), 12345d, Status.FIRED, new Organization(123, OrganizationType.GOVERNMENT)));
        workers.put(getRandId(), new Worker("User","Хейбати", new Coordinates(050f, 39), 12345d, new Organization(123, OrganizationType.GOVERNMENT)));
        workers.put(getRandId(), new Worker("Loginity","Шамиль", new Coordinates(940f, 1), 12345d, new Organization(123, OrganizationType.GOVERNMENT)));
        workers.put(getRandId(), new Worker("zxcvb","Шовхал", new Coordinates(409f, 4671), 12345d, Status.REGULAR, new Organization(123, OrganizationType.GOVERNMENT)));
        workers.put(getRandId(), new Worker("asadfgg","Эмиль", new Coordinates(1250f, 567), 12345d, new Organization(123, OrganizationType.GOVERNMENT)));
        workers.put(getRandId(), new Worker("asadfgg","Асхаб", new Coordinates(1000f, 594), 12345d, Status.REGULAR, new Organization(123, OrganizationType.GOVERNMENT)));
        workers.put(getRandId(), new Worker("qwer","Арби", new Coordinates(565f, 642), 12345d, Status.REGULAR, new Organization(123, OrganizationType.GOVERNMENT)));
    }

    public MapWorker() {
        date=new Date();
        fill();
    }

    static private Long getRandId() {
        long id = (long) (Math.random() * 10000 + 2341);
        while (MapWorker.getWorkers().containsKey(id)) {
            id = (long) (Math.random() * 10000 + 2341);
        }
        return id;
    }

    public static LinkedHashMap<Long, Worker> getWorkers() {
        if(workers.equals(null)){

        }
        return workers;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
