package com.company;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

public class ScanThread implements Runnable {
    private String hosts;
    private int[] ports;
    Thread thread;
    LinkedList<Integer> output;
    ScanThread(String host, int ... port){
        this.hosts = host;
        this.ports = port;
        thread = new Thread(this);
        output = new LinkedList<>();
    }

    public void run(){
        for(int port : ports)try {
            Socket soc = new Socket(hosts,port);
            output.add(port);
        } catch (IOException e) {}
    }
}