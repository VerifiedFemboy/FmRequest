package me.verifiedfemboy.fm.track;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.verifiedfemboy.Utils;
import me.verifiedfemboy.fm.API;

import java.io.IOException;

public class recentTrack{

    JsonObject jsonObject;


    public recentTrack(String userName, API api) throws IOException {
        String url = "http://ws.audioscrobbler.com/2.0/?method=user.getrecenttracks&user=" + userName + "&api_key=" + api.getAPI_KEY() + "&format=json";
        jsonObject = Utils.getJson().fromJson(Utils.sendRequest(url), JsonObject.class);
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
}
