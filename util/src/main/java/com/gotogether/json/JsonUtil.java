package com.gotogether.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> toMap(Object obj) {
        String json = JsonUtil.toJSON(obj);
        return JsonUtil.toClassFromJSON(json, Map.class);
    }

    public static String toJSON(Object object) {
        try {
            return toJson(object);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static byte[] toByteJson(Object object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        objectMapper.writeValue(baos, object);
        baos.close();
        return baos.toByteArray();
    }

    public static byte[] toByteJSON(Object object) {
        try {
            return toByteJson(object);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> T fromByteJsone(byte[] data, Class<T> clazz) throws IOException {
        return objectMapper.readValue(data, clazz);
    }

    public static <T> T fromByteJSON(byte[] data, Class<T> clazz) {
        try {
            return fromByteJsone(data, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> T fromByteJsone(byte[] data, TypeReference clazz) throws IOException {
        return objectMapper.readValue(data, clazz);
    }

    public static <T> T fromByteJSON(byte[] data, TypeReference clazz) {
        try {
            return objectMapper.readValue(data, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> T fromByteJsone(byte[] data, int offset, int len, Class<T> clazz) throws IOException {
        return objectMapper.readValue(data, offset, len, clazz);
    }

    public static <T> T toClassFromJson(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }

    public static <T> T toClassFromJSON(String json, Class<T> clazz) {
        try {
            return toClassFromJson(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> T toClassFromJson(InputStream inputStream, Class<T> clazz) throws IOException {
        return objectMapper.readValue(inputStream, clazz);
    }

    public static <T> T toClassFromJson(String json, TypeReference clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }

    public static <T> T convertObject(Object object, Class<T> clazz) {
        return objectMapper.convertValue(object, clazz);
    }

    public static <T> T convertObject(Object object, TypeReference<T> clazz) {
        return objectMapper.convertValue(object, clazz);
    }

}
