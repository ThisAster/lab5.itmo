package com.freiz.client.utility;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;

public class ZonedDateTimeSerializer implements JsonSerializer<ZonedDateTime> {
    @Override
    public JsonElement serialize(ZonedDateTime zonedDateTime, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(zonedDateTime.toString());
    }
}
