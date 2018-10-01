package com.shev.server.service;

import com.shev.server.data.ConnectionServerData;
import com.shev.server.exeption.IllegalDateParametersException;
import com.shev.server.log.MyServerLogger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ServerService {

    /*@param int numbers how many instances to return in ArrayList
    * @return ArrayList of ConnectionServerData
    * */
    public static ArrayList<ConnectionServerData> createRandomConnectionServerData(int numberOfInstances){
        ArrayList<ConnectionServerData> connectionServerData = new ArrayList<>(numberOfInstances);
        for(int cursor=0;cursor<numberOfInstances;cursor++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            connectionServerData.add(new ConnectionServerData("random"));
        }
        return connectionServerData;
    }

    /*@param String from and to dates with pattern format yyyy-MM-dd HH:mm:ss
    * @return ArrayList of ConnectionServerData for defined period
    * */
    public static ArrayList<ConnectionServerData> getConnectionServerDataByPeriod(String from, String to){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        ArrayList<ConnectionServerData> serverData = new ArrayList<>();
        try {

            Date dateFrom = dateFormat.parse(from);
            Date dateTo = dateFormat.parse(to);
            serverData = MyServerLogger.getServerSessionsPeriod(dateFrom,dateTo);

        } catch (ParseException|IllegalDateParametersException e) {
            e.printStackTrace();
        }
        return serverData;
    }
}
