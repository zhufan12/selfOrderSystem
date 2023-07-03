package com.morgen.order.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    public static String toJsonString(Object obj) {
        if (obj == null) return null;
        ObjectMapper mapper = SpringUtil.getBean(ObjectMapper.class);
        String result = null;
        try {
            result = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static <T> T parseObject(String jsonStr, Class<T> clazz) {
        if (StringUtils.isBlank(jsonStr) || clazz == null) return null;
        ObjectMapper mapper = SpringUtil.getBean(ObjectMapper.class);
        T t = null;
        try {
            t = mapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }


    public static <T> List<T> parseList(String listJsonStr, Class<T> clazz) {
        if (StringUtils.isBlank(listJsonStr) || clazz == null) return Collections.emptyList();
        ObjectMapper mapper = SpringUtil.getBean(ObjectMapper.class);
        List<T> list = Collections.emptyList();
        try {
            list = mapper.readValue(listJsonStr, List.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return list;
    }



    public static <K,V> Map<K,V> parseMap(String mapJsonStr, Class<K> kClazz, Class<V> vClazz) {
        if (StringUtils.isBlank(mapJsonStr) || kClazz == null || vClazz == null) return Collections.emptyMap();
        ObjectMapper mapper = SpringUtil.getBean(ObjectMapper.class);
        Map<K,V> map = Collections.EMPTY_MAP;
        try {
            map = mapper.readValue(mapJsonStr, mapper.getTypeFactory().constructParametricType(Map.class, kClazz, vClazz));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return map;
    }


    public static Object fromJson(String jsonStr, TypeReference typeReference){
        if (StringUtils.isBlank(jsonStr) || typeReference == null) return null;
        ObjectMapper mapper = SpringUtil.getBean(ObjectMapper.class);
        try {
           return mapper.readValue(jsonStr, typeReference);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
