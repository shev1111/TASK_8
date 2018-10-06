package com.shev;

import com.shev.server.data.ConnectionServerData;
import com.shev.server.exeption.IllegalDateParametersException;
import com.shev.server.service.ServerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        ArrayList<ConnectionServerData> connectionServerData = ServerService.createRandomConnectionServerData(10);
        ServerService.writeLog(connectionServerData);

        String from = "2018-09-29 20:25:10";
        String to   = "2018-09-29 20:25:13";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date dateFrom;
        Date dateTo;
        try {
            dateFrom  = dateFormat.parse(from);
            dateTo  = dateFormat.parse(to);

            ArrayList<ConnectionServerData> serverData = ServerService.getConnectionServerDataByPeriod(dateFrom,dateTo);
            for (ConnectionServerData data:serverData) {
                System.out.println(data);
            }
            ServerService.deleteOldData();


        } catch (IllegalDateParametersException | ParseException e) {
            e.printStackTrace();
        }




    }

}
