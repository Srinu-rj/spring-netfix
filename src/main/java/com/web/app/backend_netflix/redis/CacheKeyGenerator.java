package com.web.app.backend_netflix.redis;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CacheKeyGenerator implements KeyGenerator {


    @Override
    public Object generate(Object target, Method method, Object... params) {
        // Format: ClassName:methodName:param1:param2
        String className  = target.getClass().getSimpleName();
        String methodName = method.getName();
        String paramKey   = Arrays.stream(params)
                .map(p -> p != null ? p.toString() : "null")
                .collect(Collectors.joining(":"));

        return className + ":" + methodName + ":" + paramKey;
    }
}
