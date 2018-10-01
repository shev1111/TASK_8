package com.shev;

import com.shev.server.data.ConnectionServerData;
import com.shev.server.log.MyServerLogger;
import com.shev.server.service.ServerService;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList<ConnectionServerData> connectionServerData = ServerService.createRandomConnectionServerData(10);
        MyServerLogger.writeLogToTxt(connectionServerData);

        String from = "2018-09-29 20:25:10";
        String to   = "2018-09-01 13:56:00";

        ArrayList<ConnectionServerData> ServerData = ServerService.getConnectionServerDataByPeriod(from,to);

        for (ConnectionServerData data:ServerData) {
            System.out.println(data);
        }

        MyServerLogger.deleteThreeDaysOldData();




    }

}
