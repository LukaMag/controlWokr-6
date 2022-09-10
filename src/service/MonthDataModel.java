package service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class MonthDataModel {
    private String month;
    List<Day> days;

    public MonthDataModel(String  month,List<Day> days) {
        this.month = month;
        this.days = days;
    }


    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "MonthDataModel{" +
                "month='" + month + '\'' +
                ", days=" + days +
                '}';
    }
}
