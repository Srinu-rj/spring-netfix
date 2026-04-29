package com.web.app.backend_netflix.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductionCacheErrorHandler implements CacheErrorHandler {

    private static final Logger log =
            LoggerFactory.getLogger(ProductionCacheErrorHandler.class);

    @Override
    public void handleCacheGetError(RuntimeException e,
                                    Cache cache, Object key) {
        // Log but DON'T throw — fall through to DB
        log.error("Cache GET error | cache={} key={} error={}",
                cache.getName(), key, e.getMessage());
    }

    @Override
    public void handleCachePutError(RuntimeException e,
                                    Cache cache, Object key, Object value) {
        log.error("Cache PUT error | cache={} key={}", cache.getName(), key);
    }

    @Override
    public void handleCacheEvictError(RuntimeException e,
                                      Cache cache, Object key) {
        log.error("Cache EVICT error | cache={} key={}", cache.getName(), key);
    }

    @Override
    public void handleCacheClearError(RuntimeException e, Cache cache) {
        log.error("Cache CLEAR error | cache={}", cache.getName());
    }
}
