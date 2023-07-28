package org.example;

public class Main {
    public static void main(String[] args) {
        Device device = new TvDevice();
        device.printStatus();
        Remote remote = new BasicRemote(device);
        remote.power();
        remote.volumeUp();
        remote.changeChannel();

        device.printStatus();

    }
}