package me.verifiedfemboy.fm.artist;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.verifiedfemboy.fm.FM;
import me.verifiedfemboy.fm.FMUtils;
import me.verifiedfemboy.fm.image.ImageSize;
import me.verifiedfemboy.fm.stats.Stats;

import java.io.IOException;

public class Artist {

    protected JsonObject jsonObject;

    public Artist(String name, FM FM) throws IOException {
        name = name.replace(" ", "%20");
        String url = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=" + name + "&api_key=" + FM.getAPI_KEY() + "&format=json";
        jsonObject = FMUtils.getJson().fromJson(FMUtils.sendRequest(url), JsonObject.class);
    }

    private JsonObject getArtist(){
        return jsonObject.getAsJsonObject("artist");
    }

    private JsonObject getBio(){
        return getArtist().getAsJsonObject("bio");
    }

    public Stats getStats(){
        return new Stats(getArtist().getAsJsonObject("stats"));
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
