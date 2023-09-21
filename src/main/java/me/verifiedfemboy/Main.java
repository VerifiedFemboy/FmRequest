package me.verifiedfemboy;

import me.verifiedfemboy.fm.API;
import me.verifiedfemboy.fm.artist.Artist;
import me.verifiedfemboy.fm.image.ImageSize;
import me.verifiedfemboy.fm.track.recentTrack;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {

        String API_KEY = "";
        API api = new API();
        api.setAPI_KEY(API_KEY);
        String user = "muraz_kysior";
        try {
            recentTrack recentTrack = new recentTrack(user, api);
            String track_name = recentTrack.getTrackName();
            String artist_name = recentTrack.getArtistName();
            String album_name = recentTrack.getAlbumName();

            Artist artist = new Artist("Madeon", api);
//            System.out.println(track_name + " - " + artist_name + " Album: " + album_name + " Image: " + recentTrack.getImage(ImageSize.EXTRALARGE));
            System.out.println(artist.getSummary());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}