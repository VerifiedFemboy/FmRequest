package me.verifiedfemboy.fm.stats;

import com.google.gson.JsonObject;

public class Stats {

    protected JsonObject jsonObject;

    public Stats(JsonObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public Long getListeners(){
        return jsonObject.get("listeners").getAsLong();
    }

    public Long getPlayCount(){
        return jsonObject.get("playcount").getAsLong();
    }
}
