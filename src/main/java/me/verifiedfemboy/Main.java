package me.verifiedfemboy;

import me.verifiedfemboy.fm.API;
import me.verifiedfemboy.fm.track.recentTrack;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {

        String API_KEY = "80f7a246ca008d9faeaedd08055a0a08";
        API api = new API();
        api.setAPI_KEY(API_KEY);
        String user = "muraz_kysior";
        try {
            recentTrack recentTrack = new recentTrack(user, api);
            String track_name = recentTrack.getTrackName();
            String artist_name = recentTrack.getArtistName();

            System.out.println(track_name + " - " + artist_name);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}