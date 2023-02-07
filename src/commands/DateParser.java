package commands;

import worker.Months;

import java.util.Date;

public class DateParser {
    public static Date parse(String dateLine) {
        String[] dates = dateLine.split(" ");
        String[] time = dates[3].split(":");
        int years = Integer.parseInt(dates[5]) % 100;
        int dt = Integer.parseInt(dates[2]);
        for (Months m : Months.values()) {
            if (dates[1].equals(m.toString())) {
                dt += (!dates[1].equals("Jan") && !dates[1].equals("Feb") && Integer.parseInt(dates[5]) % 4 == 0) ? 1 : 0;
                break;
            }
            dt += m.getDct();
        }
        years += 30;
        int hours = Integer.parseInt(time[0]) + dt * 24 - 3;
        int mins = Integer.parseInt(time[1]);
        long seconds = Integer.parseInt(time[2]) + hours * 3600L + mins * 60L;
        return new Date((years - 2) / 4 * 31622400000L + (years - ((years - 2) / 4)) * 31536000000L + seconds * 1000);
    }
}
