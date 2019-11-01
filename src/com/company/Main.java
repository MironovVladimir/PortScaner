package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SocketScanner test = new SocketScanner("localhost", 17, 8080, 8888, 0, 8080, 8888, 4, 8080, 8888, 808,8080, 7, 808,8080, 8888, 808, 8080);
        test.scan();
        test.resoult();
    }
}
