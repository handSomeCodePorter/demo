package com.cloud.zhpt.config.cache;

import com.cloud.zhpt.dto.UserDto;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 包装redis cache抽象
 *
* @ClassName: redisCacheManager
* @Description:  redisCacheManager
* @author
*
 */
@Service
public class RedisCacheManager implements CacheManager {

    @Autowired
    private RedisTemplate redisTemplate;

    private long expireTime = 2 * 60 * 60 ;// 缓存的超时时间，单位为s

    @SuppressWarnings("unchecked")
    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {

        return new RedisCache(expireTime,redisTemplate);
    }


    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    @SuppressWarnings("rawtypes")
    static class RedisCache<K, V> implements Cache<K, V> {

        private long expireTime = 2 * 60 * 60 ;// 缓存的超时时间，单位为s

        private RedisTemplate<K, V> redisTemplate;// 通过构造方法注入该对象

        public RedisCache() {
            super();
        }

        public RedisCache(long expireTime, RedisTemplate<K, V> redisTemplate) {
            super();
            this.expireTime = expireTime;
            this.redisTemplate = redisTemplate;
        }

        @Override
        public V get(Object key) throws CacheException {
            return redisTemplate.opsForValue().get(key);
        }

        @Override
        public V put(K key, V value) throws CacheException {
            redisTemplate.opsForValue().set(key, value, this.expireTime, TimeUnit.SECONDS);
            return value;
        }

        @Override
        public V remove(K key) throws CacheException {
            V v = redisTemplate.opsForValue().get(key);
            redisTemplate.opsForValue().getOperations().delete(key);
            return v;
        }

        @Override
        public void clear() throws CacheException {

        }

        @Override
        public int size() {
            throw new UnsupportedOperationException("invoke spring cache abstract size method not supported");
        }

        @Override
        public Set keys() {
            throw new UnsupportedOperationException("invoke spring cache abstract keys method not supported");
        }

        @Override
        public Collection<V> values() {
            throw new UnsupportedOperationException("invoke spring cache abstract values method not supported");
        }
    }
}
