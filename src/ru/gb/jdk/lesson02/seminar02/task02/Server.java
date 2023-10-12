package ru.gb.jdk.lesson02.seminar02.task02;

public class Server implements ServerSocketThreadListener{
    private boolean status;
    private BaseListener serverListner;

    Server(BaseListener serverListner){
        this.status = false;
        this.serverListner = serverListner;
    }

    public void start() {
        String message;
        if (status) {
            message = "Server is already running.";
        } else {
            status = true;
            message = "Server started.";
        }
        serverListner.genereateMessage(message);
    }

    public void stop() {
        String message;
        if (status) {
            status = false;
            message = "Server stopped.";
        } else {
            message = "Server is already stoped.";
        }
        serverListner.genereateMessage(message);
    }

}
