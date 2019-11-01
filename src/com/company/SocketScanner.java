package com.company;
import java.util.ArrayList;

class SocketScanner {

    private ArrayList<ScanThread> threads;
    private String hosts;
    private int[] ports;

    SocketScanner(String hosts, int threads, int... ports){
       this.ports = ports;
       this.hosts = hosts;
       this.threads = new ArrayList<>();
       splitLoad(threads);
    }

    private void splitLoad(int n){
        System.out.println(ports.length +" "+ports.length/(n)+" "+ports.length%n);
        int offset = 0;
        for(int i =0; i < n;i++ ){
            int blockSize = ports.length/n;
            if(i<ports.length%n) blockSize++;
            int[] temp = new int[blockSize];
            System.arraycopy(ports, offset, temp, 0, blockSize);
            threads.add(new ScanThread(hosts, temp));
            offset+=blockSize;
        }
    }

    void scan() throws InterruptedException {
        for(ScanThread test : threads){
            test.thread.start();
        }
        for(ScanThread test : threads){
            test.thread.join();
        }
    }

    void resoult(){
        for(ScanThread test : threads){
            System.out.println(test.output);
        }
    }
}
