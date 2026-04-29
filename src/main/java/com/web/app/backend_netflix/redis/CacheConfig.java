package com.web.app.backend_netflix.redis;


import com.github.benmanes.caffeine.cache.Caffeine;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final Duration USER_TTL    = Duration.ofMinutes(30);
    public static final Duration PRODUCT_TTL = Duration.ofHours(1);
    public static final Duration SHORT_TTL   = Duration.ofMinutes(5);

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // 1. Configure Cluster Nodes
        RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration();

        List<RedisNode> nodes = Arrays.asList(
                new RedisNode("host1", 7000),
                new RedisNode("host2", 7001),
                new RedisNode("host3", 7002)
        );
        clusterConfig.setClusterNodes(nodes);
        clusterConfig.setMaxRedirects(5); // Optional: max cluster redirections
        clusterConfig.setPassword("yourPassword"); // Optional: authentication

        // 2. Configure Client Options (Optional but recommended)
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(2))
                .readFrom(io.lettuce.core.ReadFrom.REPLICA_PREFERRED) // Read from replicas
                .build();

        // 3. Create Factory
        return new LettuceConnectionFactory(clusterConfig, clientConfig);
    }

    @Bean
    public GenericObjectPoolConfig<?> redisPoolConfig() {
        GenericObjectPoolConfig<?> pool = new GenericObjectPoolConfig<>();
        pool.setMaxTotal(50);       // max connections
        pool.setMaxIdle(20);
        pool.setMinIdle(5);
        pool.setMaxWait(Duration.ofSeconds(2));
        pool.setTestOnBorrow(true);
        pool.setTestWhileIdle(true);
        return pool;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // String serializer for keys
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        // JSON serializer for values
        JacksonJsonRedisSerializer<Object> jsonSerializer = new JacksonJsonRedisSerializer<>(Object.class);
        template.setValueSerializer(jsonSerializer);
        template.setHashValueSerializer(jsonSerializer);

        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager manager = new CaffeineCacheManager();
        manager.setCaffeine(Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(Duration.ofMinutes(5))
                .recordStats());   // enables hit/miss metrics
        return manager;
    }
}
