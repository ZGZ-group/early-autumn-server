package com.zgz.group.util;

import com.google.gson.Gson;
import com.google.gson.internal.Primitives;

public class JsonUtil {

    private static Gson gson = GsonSingleton.INSTANCE.getInstance();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static <T> T parseJson(String json, Class<T> tClass) {
        return Primitives.wrap(tClass).cast(gson.fromJson(json, tClass));
    }

    public enum GsonSingleton {
        INSTANCE;
        private Gson gson;

        GsonSingleton() {
            gson = new Gson();
        }

        public Gson getInstance() {
            return gson;
        }
    }


}
