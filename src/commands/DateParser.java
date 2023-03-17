package commands;

import worker.Months;

import java.util.Date;

public class DateParser {
    public static Date parse(String dateLine) {
        String[] dates = dateLine.split(" ");
        String[] time = dates[3].split(":");
        int years = Integer.parseInt(dates[5]);
        int dt = Integer.parseInt(dates[2]);
        for (Months m : Months.values()) {
            if (dates[1].equals(m.toString()))break;
            dt += m.getDct();
        }
        years -= 1970;
        int hours = Integer.parseInt(time[0]) + dt * 24 - 3-(years>=42 && years<=44?1:0);
        int mins = Integer.parseInt(time[1]);
        long seconds = Integer.parseInt(time[2]) + hours * 3600L + mins * 60L;
        return new Date((years - 2) / 4 * 31622400000L + (years - ((years - 2) / 4)) * 31536000000L + seconds * 1000);
    }


    public static int getYear(String dateLine){
        return Integer.parseInt(dateLine.split(" ")[5]);
    }

    public static int getMonth(String dateLine){
        int i=0;
        String[] dates = dateLine.split(" ");
        for (Months m : Months.values()) {
            if (dates[1].equals(m.toString()))break;
            i++;
        }
        return i;
    }

    public static int getDay(String dateLine){
        return Integer.parseInt(dateLine.split(" ")[2]);
    }


}
