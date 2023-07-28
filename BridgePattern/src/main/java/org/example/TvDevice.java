package org.example;

public class TvDevice implements Device{
    private boolean on = false;
    private Integer channelNumber = 1;
    private Integer volume = 0;

    @Override
    public boolean isEnabled() {
        if(on == false){
            on = true;
        }
        return on;
    }

    @Override
    public boolean isDisabled() {
        return on;
    }

    @Override
    public Integer getVolume() {
        return volume;
    }

    @Override
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public void setChannel(Integer channelNumber) {
        this.channelNumber = channelNumber;
    }

    @Override
    public Integer getChannel() {
        return channelNumber;
    }
    @Override
    public void printStatus(){
        System.out.println("I'm Tv.");
        System.out.println("I'm " + (on ? "enabled" : "disabled"));
        System.out.println("Current volume is " + volume + "%");
        System.out.println("Current channel is " + channelNumber);

    }


}
