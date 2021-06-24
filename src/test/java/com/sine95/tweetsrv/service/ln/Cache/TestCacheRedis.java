package com.sine95.tweetsrv.service.ln.Cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.cache.ConversorCache;
import org.sine95.kernel.base.cache.RedisCache;
import org.sine95.kernel.base.cache.UtilRedis;

import com.sine95.tweetsrv.config.RedisConfiguration;
import com.sine95.tweetsrv.enums.AreasCache;

/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApp.class)
@Transactional*/
class TestCacheRedis {

	@Test
	void testGetInstance() {
		RedisCache<String> instance = getRedisCache();
		
		assertNotEquals(null, instance);
	}

	@Test
	void testIsVacio() {
		RedisCache<String> redis = getRedisCache();
		
		redis.set("Prueba","Test");
		
		assertEquals(false,redis.isVacio());
		redis.reset();
		assertEquals(true,redis.isVacio());
	}

	@Test
	void testGet() {
		RedisCache<String> redis = getRedisCache();
		
		
		redis.set("Prueba","Test");
		assertEquals(true, redis.get("Prueba").isOk());
		assertEquals("Test", redis.get("Prueba").getData());

	}

	@Test
	void testSet() {
		RedisCache<String> redis = getRedisCache();
		
		
		redis.set("Prueba","Test");
		assertEquals(true, redis.get("Prueba").isOk());
		assertEquals("Test", redis.get("Prueba").getData());
	}

	

	@Test
	void testGetAll() {
		RedisCache<String> redis = getRedisCache();
		
		redis.set("Prueba1","Test1");
		redis.set("Prueba2","Test2");
		
		Result<Map<Object,String>> all = redis.getAll();
		assertEquals(true, all.isOk());
		Map<Object,String> map=all.getData();
		
		assertEquals("Test1", map.get("Prueba1"));
		assertEquals("Test2", map.get("Prueba2"));
	}

	@Test
	void testSetAll() {
		RedisCache<String> redis = getRedisCache();
		Map<Object,String> mapIn=new HashMap<Object, String>();
		
		mapIn.put("Prueba1","Test1");
		mapIn.put("Prueba2","Test2");
		
		redis.setAll(mapIn);
		
		Result<Map<Object,String>> all = redis.getAll();
		assertEquals(true, all.isOk());
		Map<Object,String> map=all.getData();
		
		assertEquals("Test1", map.get("Prueba1"));
		assertEquals("Test2", map.get("Prueba2"));
	}

	@Test
	void testReset() {
		RedisCache<String> redis = getRedisCache();
		
		redis.set("Prueba","Test");
		
		assertEquals(false,redis.isVacio());
		redis.reset();
		assertEquals(true,redis.isVacio());
		
	}

	@Test
	void testRemove() {
		RedisCache<String> redis = getRedisCache();
		
		redis.set("Prueba","Test");
		
		assertEquals(false,redis.isVacio());
		
		redis.remove("Prueba");
		
		//assertEquals(true,redis.isVacio());
		Result<String> res = redis.get("Prueba");
		assertEquals(true,res.isOk());
		assertEquals(null,res.getData());
	}
	
	private RedisCache<String> getRedisCache() {
		
		RedisConfiguration redisConfiguration=new RedisConfiguration("tweetsrvTest","192.168.1.89", 6379, "5sp9/EBsaUQKrmgUJFUIRURoVgdo7tusr9TmYMs/2MeBCo8sTNcsOyG9H2poBvlEIHndQ5jLmTN4Ac+p",128,128,16,true,true,true,60,30,3,true);
		
	    
		UtilRedis.set(redisConfiguration);
	    
		RedisCache<String> redis = RedisCache.getInstance(AreasCache.CachePrueba);
		redis.setConversor(new ConversorCache<String>() {
			
			@Override
			public Object convertFromObjToCacheData(String datum) {
				
				return datum;
			}
			
			@Override
			public String convertCacheDataToObj(Object datum) {

				return (String)datum;
			}
		});
		redis.reset();
		return redis;
	}

}
