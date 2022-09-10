import service.DaysService;
import service.MonthDataModel;
import service.TaskMaker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new TaskMaker("localhost", 9889).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        MonthDataModel monthDataModel = DaysService.getMonth();
//        System.out.println(monthDataModel);
    }
}
