package org.example;

public class Main {
    public static void main(String[] args) {
        MusicPlayerAdapter musicPlayerAdapter = new MusicPlayerAdapter();
        Mp3Player mp3Player = new Mp3Player();
        Mp4Player mp4Player = new Mp4Player();
        mp4Player.videoFormat = "x67";
        mp4Player.audioFormat = "x64";
        mp3Player.audioFormat = "x64";

        musicPlayerAdapter.playMusic(mp3Player);
    }
}