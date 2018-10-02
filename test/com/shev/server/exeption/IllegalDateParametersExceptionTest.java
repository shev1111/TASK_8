package com.shev.server.exeption;

import com.shev.server.service.ServerService;
import org.junit.Test;
import static org.junit.Assert.*;

public class IllegalDateParametersExceptionTest {
    @Test
    public void IllegalDateParametersTest() {
        String testString = "'to' parameter must be greater then 'from'!";
        try {
            String testTo = "2018-09-29 20:25:10";
            String testFrom   = "2018-09-29 20:25:13";
            ServerService.getConnectionServerDataByPeriod(testFrom, testTo);
        } catch (IllegalDateParametersException e) {
            assertTrue(testString.equals(e.getMessage()));
        }
    }

}
