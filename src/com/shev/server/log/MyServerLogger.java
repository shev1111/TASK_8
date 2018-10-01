package com.shev.server.log;

import com.shev.server.data.ConnectionServerData;
import com.shev.server.exeption.IllegalDateParametersException;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class MyServerLogger {

    private static final String LOG_FILE = "src\\com\\shev\\server\\log\\server_logs.txt";

    public static void writeLogToTxt (ArrayList<ConnectionServerData> connectionServerData) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            for (ConnectionServerData serverData : connectionServerData) {
                bufferedWriter.write(Long.toString(serverData.getCurrentTime())+" "+
                                         serverData.getSession()+" "+
                                         serverData.getIP());
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<ConnectionServerData> getServerSessionsPeriod(Date from, Date to) throws IllegalDateParametersException{
        if(from.getTime()>to.getTime()){
            throw new IllegalDateParametersException("'to' parameter must be greater then 'from'!");
        }
        ArrayList<ConnectionServerData> connectionServerDataList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(LOG_FILE))) {

            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                ConnectionServerData connectionServerData =new ConnectionServerData();
                String[] tokens = currentLine.split(" ");

                for (int cursor = 0; cursor<tokens.length;cursor++){

                    switch (cursor){

                        case 0:connectionServerData.setCurrentTime(Long.parseLong(tokens[cursor]));
                        case 1:connectionServerData.setSession(Long.parseLong(tokens[cursor]));
                        case 2:connectionServerData.setIP(tokens[cursor]);
                    }
                    long sessionDate = connectionServerData.getCurrentTime();
                    if(sessionDate>=from.getTime()&&sessionDate<=to.getTime()){
                        connectionServerDataList.add(connectionServerData);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return connectionServerDataList;
    }
}
