package service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DaysService {
    public static MonthDataModel getMonth(){
        LocalDate current = LocalDate.now();
        Month month = current.getMonth();
        int dayOfWeek = current.withDayOfMonth(1).getDayOfWeek().getValue();
        int currentDay = current.getDayOfMonth();
        return new MonthDataModel(month.name(),getDays(currentDay,month.length(current.isLeapYear()),dayOfWeek));
    }
    public static List<Day> getDays(int currentDay,int monthLength,int dayOfWeek){
        List<Day> days = new ArrayList<>();
        for (int i = 1; i <= monthLength ; i++, dayOfWeek++) {
            if(dayOfWeek < 8){
                if(i == currentDay){
                    days.add(new Day(i,dayOfWeek,true,Task.generateTasks()));
                }else{
                    days.add(new Day(i,dayOfWeek,false,Task.generateTasks()));
                }
            }else{
                dayOfWeek = 1;
                if(i == currentDay){
                    days.add(new Day(i,dayOfWeek,true,Task.generateTasks()));
                }else{
                    days.add(new Day(i,dayOfWeek,false,Task.generateTasks()));
                }
            }
        }
        return days;
    }
}
