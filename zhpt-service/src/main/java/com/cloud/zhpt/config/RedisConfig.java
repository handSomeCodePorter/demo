package com.cloud.zhpt.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableAutoConfiguration
public class RedisConfig {
	private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

	@Value("#{'${spring.redis.cluster.nodes}'.split(',')}")
	private List<String> clusterNodes;

	@Value("#{'${spring.redis.sentinel.nodes}'.split(',')}")
	private  List<String> nodes;

	@Value("${spring.redis.password}")
	private String passwd;

	@Value("${spring.redis.lettuce.pool.max-active}")
	private int max_active;

	@Value("${spring.redis.lettuce.pool.max-wait}")
	private long max_wait;

	@Value("${spring.redis.lettuce.pool.max-idle}")
	private int max_idle;

	@Value("${spring.redis.lettuce.pool.min-idle}")
	private int min_idle;

	@Bean
	public GenericObjectPoolConfig poolConfig() {
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxIdle(max_idle);
		config.setMinIdle(min_idle);
		config.setMaxTotal(max_active);
		config.setMaxWaitMillis(max_wait);
		return config;
	}
	@Bean
	public LettucePoolingClientConfiguration lettuceClientConfiguration(GenericObjectPoolConfig poolConfig) {
		LettucePoolingClientConfiguration poolingClientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(poolConfig).build();
		return poolingClientConfiguration;
	}


	@Bean
	public  RedisSentinelConfiguration redisSentinelConfiguration(){
		RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
		//配置matser的名称
		redisSentinelConfiguration.master("mymaster");
		//配置redis的哨兵sentinel
		Set<RedisNode> redisNodeSet = new HashSet<>();
		nodes.forEach(x->{
			redisNodeSet.add(new RedisNode(x.split(":")[0],Integer.parseInt(x.split(":")[1])));
		});
		logger.info("redisNodeSet -->"+redisNodeSet);
		redisSentinelConfiguration.setSentinels(redisNodeSet);
		redisSentinelConfiguration.setPassword(RedisPassword.of(passwd));
		return redisSentinelConfiguration;
	}

	@Bean
	public RedisClusterConfiguration redisClusterConfiguration() {
		RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
		Set<RedisNode> redisNodeSet = new HashSet<>();
		clusterNodes.forEach(x->{
			redisNodeSet.add(new RedisNode(x.split(":")[0],Integer.parseInt(x.split(":")[1])));
		});
		logger.info("redisNodeSet -->"+redisNodeSet);
		redisClusterConfiguration.setPassword(RedisPassword.of(passwd));
		redisClusterConfiguration.setClusterNodes(redisNodeSet);

		return redisClusterConfiguration;
	}

	@Bean
	public LettuceConnectionFactory lettuceConnectionFactory(RedisClusterConfiguration redisClusterConfiguration,LettucePoolingClientConfiguration configuration) {
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisClusterConfiguration,configuration);
		return lettuceConnectionFactory;
	}


	@Bean("RedisTemplateCustom")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		//使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
		Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

		ObjectMapper om = new ObjectMapper();
		// 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		// 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jacksonSeial.setObjectMapper(om);

		// 值采用json序列化
		template.setValueSerializer(jacksonSeial);
		//使用StringRedisSerializer来序列化和反序列化redis的key值
		template.setKeySerializer(new StringRedisSerializer());

		// 设置hash key 和value序列化模式
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(jacksonSeial);
		template.afterPropertiesSet();

		return template;
	}





}
