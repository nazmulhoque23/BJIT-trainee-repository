package org.example;

public interface Device {
    boolean isEnabled();
    boolean isDisabled();
    Integer getVolume();
    void setVolume(Integer volume);
    void setChannel(Integer volume);
    Integer getChannel();
    void printStatus();
}
