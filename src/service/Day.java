package service;

import java.util.*;

public class Day {
    private static Random r = new Random();

    private int number;
    private int dayOfWeek;
    private boolean current;
    private List<Task> tasks;

    public Day(int number, int dayOfWeek, boolean current, List<Task> tasks) {
        this.number = number;
        this.dayOfWeek = dayOfWeek;
        this.current = current;
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public static Random getR() {
        return r;
    }

    public static void setR(Random r) {
        Day.r = r;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String
    toString() {
        return "Day{" +
                "number=" + number +
                ", dayOfWeek=" + dayOfWeek +
                ", current=" + current +
                ", tasks=" + tasks +
                '}';
    }
}
