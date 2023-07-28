package org.example;

public class BasicRemote implements Remote{
    protected Device device;
    public BasicRemote(Device device){
        this.device = device;
    }
    @Override
    public void power() {
        if(device.isDisabled()){
            device.isEnabled();
        }else{
            System.out.println("POWERING UP");
            device.isEnabled();
        }

    }
    @Override
    public void volumeUp(){
        System.out.println("Set volume up");
        device.setVolume(device.getVolume()+5);
    }
    @Override
    public void volumeDown() {
        System.out.println("SET VOLUME DOWN");
        Integer volume = device.getVolume();
        device.setVolume(volume-5);
    }

    @Override
    public void changeChannel() {
        System.out.println("CHANGING CHANNEL");
        Integer channelNo = device.getChannel();
        device.setChannel(channelNo+1);
    }
}
