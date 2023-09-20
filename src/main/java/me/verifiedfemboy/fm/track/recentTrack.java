package me.verifiedfemboy.fm.track;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.verifiedfemboy.fm.API;
import me.verifiedfemboy.fm.FMUtils;
import me.verifiedfemboy.fm.image.ImageSize;

import java.io.IOException;

public class recentTrack {

    JsonObject jsonObject;

    public recentTrack(String userName, API api) throws IOException {
        String url = "http://ws.audioscrobbler.com/2.0/?method=user.getrecenttracks&user=" + userName + "&api_key=" + api.getAPI_KEY() + "&format=json";
        jsonObject = FMUtils.getJson().fromJson(FMUtils.sendRequest(url), JsonObject.class);
    }
    public JsonObject recentTracks(){
        return jsonObject.get("recenttracks").getAsJsonObject();
    }
    public JsonObject Track(){
        JsonArray track_array =  recentTracks().get("track").getAsJsonArray();
        return track_array.get(0).getAsJsonObject();
    }
    public String getTrackName(){
        return Track().get("name").getAsString();
    }
    public JsonObject getArtist() {
        return Track().get("artist").getAsJsonObject();
    }
    public String getArtistName(){
        return getArtist().get("#text").getAsString();
    }
    public JsonObject getAlbum(){
        return Track().get("album").getAsJsonObject();
    }
    public String getAlbumName(){
        return getAlbum().get("#text").getAsString();
    }
    public JsonArray getImage(){
        return Track().get("image").getAsJsonArray();
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
            case EXTRALARGE -> {
                return getImage().get(3).getAsJsonObject().get("#text").getAsString();
            }
        }
        return null;
    }
}
