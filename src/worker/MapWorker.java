package worker;

import java.util.LinkedHashMap;

public class MapWorker {
    static Long key=0L;
    public static LinkedHashMap<Long,Worker> workers=new LinkedHashMap<>();

    public static void fill(){
        workers.put(key++,new Worker("Чоршанбе",new Coordinates(1f,1),1d,Status.FIRED ,new Organization(123,OrganizationType.GOVERNMENT)));
        workers.put(key++,new Worker("Мариф",new Coordinates(1f,1),12345d,Status.RECOMMENDED_FOR_PROMOTION,new Organization(123,OrganizationType.GOVERNMENT)));
        workers.put(key++,new Worker("Азизхан",new Coordinates(1f,1),12345d,Status.FIRED,new Organization(123,OrganizationType.GOVERNMENT)));
        workers.put(key++,new Worker("Хейбати",new Coordinates(1f,1),12345d,new Organization(123,OrganizationType.GOVERNMENT)));
        workers.put(key++,new Worker("Шамиль",new Coordinates(1f,1),12345d,new Organization(123,OrganizationType.GOVERNMENT)));
        workers.put(key++,new Worker("Шовхал",new Coordinates(1f,1),12345d,Status.REGULAR,new Organization(123,OrganizationType.GOVERNMENT)));
        workers.put(key++,new Worker("Эмиль",new Coordinates(1f,1),12345d,new Organization(123,OrganizationType.GOVERNMENT)));
        workers.put(key++,new Worker("Асхаб",new Coordinates(1f,1),12345d,Status.REGULAR,new Organization(123,OrganizationType.GOVERNMENT)));
        workers.put(key++,new Worker("Арби",new Coordinates(1f,1),12345d,Status.REGULAR,new Organization(123,OrganizationType.GOVERNMENT)));
    }

    public MapWorker() {
        fill();
    }

    public static LinkedHashMap<Long, Worker> getWorkers() {
        return workers;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
