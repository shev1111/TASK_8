package com.shev.server.data;

public class ConnectionServerData {

    private long currentTime;
    private long session;
    private String IP;

    public ConnectionServerData(String random) {
        if(random.contentEquals("random")){
            currentTime = System.currentTimeMillis();
            session = RandomServerData.getRandomSessionId();
            IP = RandomServerData.getRandomServerIP();
        }
    }

    public ConnectionServerData() {

    }

    public long getCurrentTime() {
        return currentTime;
    }

    public long getSession() {
        return session;
    }

    public String getIP() {
        return IP;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void setSession(long session) {
        this.session = session;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
}
