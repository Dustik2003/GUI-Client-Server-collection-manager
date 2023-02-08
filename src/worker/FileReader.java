package worker;

import commands.DateParser;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class FileReader {
    public static void readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(path))) {
            int data = reader.read();
            while (data != 10 && data != -1) data = reader.read();
            data = reader.read();
            while (data != -1) {
                sb.append((char) data);
                data = reader.read();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        String[] lines = sb.toString().split("\n");
        for (String line : lines) {
            String[] str = line.split(",");
            MapWorker.getWorkers().put(Long.parseLong(str[0]), new Worker(str[1], new Coordinates(Float.parseFloat(str[2]), Double.parseDouble(str[3])), DateParser.parse(str[4]), Double.parseDouble(str[5]), str[6].equals("")?null:LocalDate.parse(str[6]), (str[7] == "" ? null : Position.valueOf(str[7])), (str[8] == "" ? null : Status.valueOf(str[8])), new Organization(Integer.parseInt(str[9]), OrganizationType.valueOf(str[10]))));
        }
    }
}
