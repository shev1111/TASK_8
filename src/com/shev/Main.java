package com.shev;

import com.shev.server.data.ConnectionServerData;
import com.shev.server.exeption.IllegalDateParametersException;
import com.shev.server.log.MyServerLogger;
import com.shev.server.service.ServerService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
       /*long milis = 1538235848374L;
        Date date = new Date(milis);
        System.out.println(date);*/
        //ArrayList<ConnectionServerData> connectionServerData = ServerService.getConnectionServerData(10);
        //MyServerLogger.writeLogToTxt(connectionServerData);

        /*ArrayList<ConnectionServerData> connectionServerData = MyServerLogger.getServerSessionsPeriod();

        for (ConnectionServerData data:connectionServerData) {
            System.out.println(data.getIP());
        }*/

        String from = "2018-09-29 20:25:10";
        String to   = "2018-09-30 13:56:00";



    }

}
