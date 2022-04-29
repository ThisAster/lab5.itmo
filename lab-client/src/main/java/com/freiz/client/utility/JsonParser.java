package com.freiz.client.utility;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.freiz.client.data.SpaceMarine;

import java.lang.reflect.Type;

import java.time.ZonedDateTime;
import java.util.HashSet;

public final class JsonParser {
    private JsonParser() {
    }
    public static HashSet<SpaceMarine> toData(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeDeserializer())
                .setPrettyPrinting().create();
        Type typeToken = new TypeToken<HashSet<SpaceMarine>>() {
        }.getType();
        return gson.fromJson(json.trim(), typeToken);
    }

    public static String toJson(HashSet<SpaceMarine> collectionData) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeSerializer())
                .setPrettyPrinting().create();
        return gson.toJson(collectionData);
    }
}
