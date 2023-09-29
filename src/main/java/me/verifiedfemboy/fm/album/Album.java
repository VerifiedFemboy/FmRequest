package me.verifiedfemboy.fm.album;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.verifiedfemboy.fm.FM;
import me.verifiedfemboy.fm.FMUtils;
import me.verifiedfemboy.fm.image.ImageSize;
import me.verifiedfemboy.fm.stats.Stats;

import java.io.IOException;

public class Album {

    private String album_name;
    private String artist_name;

    protected JsonObject jsonObject;

    public Album(String artist_name, String album_name, FM fm) throws IOException {
        album_name = album_name.replace(" ", "%20");
        artist_name = artist_name.replace(" ", "%20");
        this.artist_name = artist_name;
        this.album_name = album_name;
        String url = "http://ws.audioscrobbler.com/2.0/?method=album.getinfo&api_key=" + fm.getAPI_KEY() + "&artist=" + artist_name + "&album=" + album_name + "&format=json";
        jsonObject = FMUtils.getJson().fromJson(FMUtils.sendRequest(url), JsonObject.class);
    }

    private JsonObject getAlbum(){
        return jsonObject.getAsJsonObject("album");
    }

    public Stats getStats(){
        return new Stats(getAlbum());
    }

    private JsonArray getImage(){
        return getAlbum().getAsJsonArray("image");
    }

    public String getImage(ImageSize imageSize){
        switch (imageSize){
            case SMALL -> {
                return getImage().get(0).getAsJsonObject().get("#text").getAsString();
            }
            case MEDIUM -> {
                return getImage().get(1).getAsJsonObject().get("#text").getAsString();
            }
            case LARGE -> {
                return getImage().get(2).getAsJsonObject().get("#text").getAsString();
            }
            case EXTRA_LARGE -> {
                return getImage().get(3).getAsJsonObject().get("#text").getAsString();
            }
        }
        return null;
    }
}
