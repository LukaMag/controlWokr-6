package service;

import com.sun.net.httpserver.HttpExchange;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import server.BasicServer;
import server.ContentType;
import server.ResponseCodes;
import server.Utils;
import service.MonthDataModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TaskMaker extends BasicServer {
    private static MonthDataModel model = DaysService.getMonth();

    public TaskMaker(String host, int port) throws IOException {
        super(host, port);
        registerGet("/", this::mainHandler);
        registerPost("/dayChoose", this::dayHandler);
        registerPost("delete",this::deleteHAndler);
    }

    private void deleteHAndler(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String,String> parsed = Utils.parseUrlEncoded(raw,"&");
        String task = parsed.get("task");
        int number = Integer.parseInt(parsed.get("dayId"));
        model.getDays().get(number).getTasks().remove(model.getDays().get(number).getTasks().removeIf(e -> e.getName().equals(task)));
        dayHandler(exchange);
    }

    private void dayHandler(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String,String> parsed = Utils.parseUrlEncoded(raw,"&");
        int number = Integer.parseInt(parsed.get("dayId"));
        Optional<Day> day = model.days.stream().findAny().filter(e -> e.getNumber() == number);
        if(day.isPresent()){
            renderTemplate(exchange,"day.html",day);
        }else{
            try{
                String msg = "Something went wrong";
                byte[] data = msg.getBytes(StandardCharsets.UTF_8);
                sendByteData(exchange,ResponseCodes.NOT_FOUND,ContentType.TEXT_PLAIN,data);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    private void mainHandler(HttpExchange exchange) {
        renderTemplate(exchange,"main.html",model);
    }


}
