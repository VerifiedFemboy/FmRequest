package me.verifiedfemboy;

import me.verifiedfemboy.fm.FM;
import me.verifiedfemboy.fm.image.ImageSize;
import me.verifiedfemboy.fm.track.recentTrack;
import me.verifiedfemboy.fm.user.User;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {

        String API_KEY = "";
        FM fm = new FM();
        fm.setAPI_KEY(API_KEY);

        User user = new User("muraz_kysior");
        try {
            recentTrack recentTrack = new recentTrack(user, fm);
            String track_name = recentTrack.getTrackName();
            String artist_name = recentTrack.getArtistName();
            String album_name = recentTrack.getAlbumName();
            System.out.println(track_name + " - " + artist_name + " Album: " + album_name + " Image: " + recentTrack.getImage(ImageSize.EXTRA_LARGE));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}