package commands;

import client.GUI.WorkersTable;
import worker.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class ChangeWorker extends Command{
    long id;
    Object res;
    int column;

    public ChangeWorker(long id, Object res, int column) {
        super("Меняет поля объекта коллекции");
        this.id = id;
        this.res = res;
        this.column = column;
    }

    @Override
    public String execute() throws IOException, ClassNotFoundException, SQLException {

        switch (column) {
            case (3) -> {
                Coordinates c = MapWorker.workers.get(id).getCoordinates();
                c.setX((Float) res);
                MapWorker.workers.get(id).setCoordinates(c);
            }
            case (4) -> {
                Coordinates c = MapWorker.workers.get(id).getCoordinates();
                c.setY((Double) res);
                MapWorker.workers.get(id).setCoordinates(c);
            }
            case (6) -> MapWorker.workers.get(id).setSalary((Double) res);
            case (7) -> MapWorker.workers.get(id).setEndDate(LocalDate.parse(res + ""));
            case (8) -> MapWorker.workers.get(id).setPosition((Position) res);
            case (9) -> MapWorker.workers.get(id).setStatus((Status) res);
            case (10) -> {
                Organization org = MapWorker.workers.get(id).getOrganization();
                org.setEmployeesCount((Integer) res);
                MapWorker.workers.get(id).setOrganization(org);
            }
            case (11) -> {
                Organization org = MapWorker.workers.get(id).getOrganization();
                org.setType((OrganizationType) res);
                MapWorker.workers.get(id).setOrganization(org);

                System.out.println(MapWorker.getWorkers());
            }
        }
        System.out.println(MapWorker.getWorkers());
        return "Success";
    }
}
