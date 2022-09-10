package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task {
    private static Random r = new Random();
    private static TaskState[] taskStates = {TaskState.URGENTLY,TaskState.WORK,TaskState.STUDY,TaskState.HOBBY};

    private String name;
    private TaskState state;
    private String description;

    public Task(String name, TaskState state, String description) {
        this.name = name;
        this.state = state;
        this.description = description;
    }

    public static List<Task> generateTasks(){
        List<Task> tasks = new ArrayList<>();
        int rnd = r.nextInt(4);
        TaskState state = TaskState.URGENTLY ;
        for (int i = 0; i < rnd; i++) {
            for (int j = 0; j < taskStates.length; j++) {
                if (j == rnd) {
                    state = taskStates[i];
                    break;
                }
                tasks.add(new Task(Generator.makeName(),state,Generator.makeDescription()));
            }
        }
        return tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", state=" + state +
                ", description='" + description + '\'' +
                '}';
    }
}
