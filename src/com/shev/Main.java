package com.shev;

import com.shev.server.data.ConnectionServerData;
import com.shev.server.exeption.IllegalDateParametersException;
import com.shev.server.service.ServerService;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList<ConnectionServerData> connectionServerData = ServerService.createRandomConnectionServerData(10);
        ServerService.writeLog(connectionServerData);

        String from = "2018-09-29 20:25:10";
        String to   = "2018-09-29 20:25:13";
        ArrayList<ConnectionServerData> ServerData = null;
        try {
            ServerData = ServerService.getConnectionServerDataByPeriod(from,to);
        } catch (IllegalDateParametersException e) {
            e.printStackTrace();
        }

        for (ConnectionServerData data:ServerData) {
            System.out.println(data);
        }
        ServerService.deleteOldData();




    }

}
