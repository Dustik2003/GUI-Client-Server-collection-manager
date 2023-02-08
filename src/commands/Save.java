package commands;

import worker.MapWorker;
import worker.Worker;

import java.io.*;

public class Save extends Command {
    public Save() {
        super("????????? ????????? ? ????");
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        sb.append("id,name,coordinates.x,coordinates.y,creationDate,salary,endDate,position,status,organization.employeesCount,organization.type\n");
        for (Long id : MapWorker.getWorkers().keySet()) {
            Worker tmp = MapWorker.getWorkers().get(id);
            sb.append(id + "," + tmp.getName() + "," + tmp.getCoordinates().getX() + "," + tmp.getCoordinates().getY() + "," + tmp.getCreationDate() + "," + tmp.getSalary() + "," + (tmp.getEndDate() == null ? "" : tmp.getEndDate()) + "," + (tmp.getPosition() == null ? "" : tmp.getPosition()) + "," + (tmp.getStatus() == null ? "" : tmp.getStatus()) + "," + tmp.getOrganization().getEmployeesCount() + "," + tmp.getOrganization().getType() + "\n");
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("output.csv"))) {
            writer.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
