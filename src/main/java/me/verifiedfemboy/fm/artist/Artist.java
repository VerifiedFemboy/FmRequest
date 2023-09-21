package me.verifiedfemboy.fm.artist;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.verifiedfemboy.fm.API;
import me.verifiedfemboy.fm.FMUtils;
import me.verifiedfemboy.fm.image.ImageSize;

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

    private JsonObject getBio(){
        return getArtist().getAsJsonObject("bio");
    }

    private JsonObject getStats(){
        return getArtist().getAsJsonObject("stats");
    }

    public Long getListeners() {
        return getStats().get("listeners").getAsLong();
    }

    public Long getPlayCount(){
        return getStats().get("playcount").getAsLong();
    }

    public String getSummary(){
        return getBio().get("summary").getAsString();
    }

    private JsonArray getImage(){
        return getArtist().getAsJsonArray("image");
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
