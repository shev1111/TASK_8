package com.shev.server.log;


import com.shev.server.data.ConnectionServerData;
import com.shev.server.exeption.IllegalDateParametersException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.assertEquals;



public class MyServerLoggerTest {

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String SEP = System.getProperty("file.separator");
    private static final String TEST_READ_DELETE_FILE = USER_DIR+SEP+"test"+SEP+"com"+SEP+"shev"+SEP+"server"+SEP+"log"+SEP+"server_logs_test.txt";
    private static final String TEST_WRITE_FILE = USER_DIR+SEP+"test"+SEP+"com"+SEP+"shev"+SEP+"server"+SEP+"log"+SEP+"write_logs_test.txt";
    private static final long testCurrentTime = new Date().getTime();
    private static final long testThreeDaysOldTime = testCurrentTime-259200000L;
    private static final long testOneDayOldTime = testCurrentTime-86400000L;


    @BeforeClass
    public static void setBeforeClass(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(TEST_READ_DELETE_FILE))){
            for(int index = 1; index<5;index++){
                bufferedWriter.write(testCurrentTime +" 155535858 235.199.239.35\n");
            }
            bufferedWriter.write(testThreeDaysOldTime+" 155535858 235.199.239.35\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getServerSessionsPeriod() throws IllegalDateParametersException {
        Date testDateFrom = new Date(testOneDayOldTime);
        Date testDateTo = new Date(testCurrentTime);
        String expectResult = testCurrentTime+" 155535858 235.199.239.35";
        ArrayList<ConnectionServerData> connectionServerData = MyServerLogger.getServerSessionsPeriod(testDateFrom,testDateTo, TEST_READ_DELETE_FILE);
        assertEquals(expectResult,connectionServerData.get(0).toString());
    }


    @Test
    public void deleteThreeDaysOldData() throws IllegalDateParametersException{
        Date testDateFrom = new Date(testThreeDaysOldTime);
        Date testDateTo = new Date(testCurrentTime);
        String expectResult = testCurrentTime+" 155535858 235.199.239.35";
        MyServerLogger.deleteThreeDaysOldData(TEST_READ_DELETE_FILE);
        ArrayList<ConnectionServerData> connectionServerData = MyServerLogger.getServerSessionsPeriod(testDateFrom,testDateTo, TEST_READ_DELETE_FILE);
        assertEquals(expectResult,connectionServerData.get(connectionServerData.size()-1).toString());

    }


    @Test
    public void writeLogToTxt() throws IllegalDateParametersException{
        Date testDateFrom = new Date(testThreeDaysOldTime);
        Date testDateTo = new Date(testCurrentTime);
        ArrayList<ConnectionServerData> testServerData = new ArrayList<>();
        testServerData.add(new ConnectionServerData(1538503098861L, 111111111L, "0.0.0.0"));
        String expectResult = "1538503098861 111111111 0.0.0.0";
        MyServerLogger.writeLogToTxt(testServerData, TEST_WRITE_FILE);
        ArrayList<ConnectionServerData> connectionServerData = MyServerLogger.getServerSessionsPeriod(testDateFrom,testDateTo, TEST_WRITE_FILE);
        assertEquals(connectionServerData.get(0).toString(), expectResult);

    }

    @AfterClass
    public static void setAfterClass(){
        File testReadDeleteFile = new File(TEST_READ_DELETE_FILE);
        File testWriteFile = new File(TEST_WRITE_FILE);
        testReadDeleteFile.delete();
        testWriteFile.delete();
    }


}
