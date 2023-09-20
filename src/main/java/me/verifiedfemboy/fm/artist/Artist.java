package me.verifiedfemboy.fm.artist;

import com.google.gson.JsonObject;
import me.verifiedfemboy.fm.API;
import me.verifiedfemboy.fm.FMUtils;

import java.io.IOException;

public class Artist {

    JsonObject jsonObject;

    public Artist(String name, API api) throws IOException {
        String url = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=" + name + "&api_key=" + api.getAPI_KEY() + "&format=json";
        jsonObject = FMUtils.getJson().fromJson(FMUtils.sendRequest(url), JsonObject.class);
    }

    public JsonObject getArtist(){
        return jsonObject.getAsJsonObject("artist");
    }

    public JsonObject getBio(){
        return getArtist().getAsJsonObject("bio");
    }

    public String getSummary(){
        return getBio().get("summary").getAsString();
    }
}
