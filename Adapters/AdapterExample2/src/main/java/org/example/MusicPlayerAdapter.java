package org.example;

public class MusicPlayerAdapter {
    public void playMusic(Mp3Player mp3Player){
        MusicPlayer musicPlayer  = new MusicPlayer();
        Mp4Player mp4Player = new Mp4Player();
//        String mp3Format = mp3Player.audioFormat;
//        String mp4AudFormat = mp4Player.audioFormat;
//        String mp4VidFormat = mp4Player.videoFormat;
//        if(mp3Format == mp4AudFormat){
    mp4Player.audioFormat = mp4Player.videoFormat = mp3Player.audioFormat;

    musicPlayer.playMusic(mp4Player);
        //}
//        else{
//            System.out.println("Cannot play the music");
//        }
    }
}
