package commands;

import worker.MapWorker;
import worker.Worker;

import java.io.*;

public class Save extends Command {
    public Save() {
        super("сохранить коллекцию в файл");
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        sb.append("id,name,coordinates.x,coordinates.y,creationDate,salary,endDate,position,status,organization.employeesCount,organization.type\n");
        for (Long id : MapWorker.getWorkers().keySet()) {
            Worker tmp = MapWorker.getWorkers().get(id);
            sb.append(id + "," + tmp.getName() + "," + tmp.getCoordinates().getX() + "," + tmp.getCoordinates().getY() + "," + tmp.getCreationDate() + "," + tmp.getSalary() + "," + (tmp.getEndDate() == null ? "" : tmp.getEndDate()) + "," + (tmp.getPosition() == null ? "" : tmp.getPosition()) + "," + (tmp.getStatus() == null ? "" : tmp.getStatus()) + "," + tmp.getOrganization().getEmployeesCount() + "," + tmp.getOrganization().getType() + "\n");
        }


        String path=System.getenv("SaveFile");
        if(path==null){
            System.out.print("Variable wasn't set. Enter the path to the save file\n>>");
            path= cin.nextLine().trim();
        }
        while(path.length()<5||(path.length()-path.indexOf("csv"))!=3){
            System.out.print("Invalid file format. Try again\n>>");
            path= cin.nextLine().trim();
        }
        try{
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path));
            writer.write(sb.toString());
        }catch (FileNotFoundException e){
            System.out.println("File not found or you do not have permissions");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
