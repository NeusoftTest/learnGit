package com.web.neusoft.test.utils;

import java.net.ConnectException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class JedisUtil {

	@Resource(name="jedisPool")
	private JedisPool jedisPool;
	
	/**
	 * 从jedisPool获取jedis
	 * @return jedis
	 */
	public synchronized Jedis getResourse(){
		
		Jedis jedis = null;
		int currentTime = 0;
		try {
			
			jedis = jedisPool.getResource();
			
		} catch (JedisConnectionException e) {
			// TODO: handle exception
			while(currentTime<Constants.CyCLES_TIMES){
				try{
				
					jedis = this.jedisPool.getResource();
				}catch(JedisConnectionException exception){
					continue;
				}
				if(jedis != null)
					break;
				else
					continue;
			}
		}
		return jedis;
	}
	/**
	 * 给指定的key设置过期时间
	 * @param key
	 * @param seconds
	 * @return
	 */
	public long expire(String key, int seconds){
		
		if(key==null||" ".equalsIgnoreCase(key))
			return 0;
		
		Jedis jedis = null;
		try {
			
			jedis = this.getResourse();
			return jedis.expire(key, seconds);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return 0;
	}
	/**
	 * 向key中设置field<-->value
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	public long hset(String key,String field, String value){

		Jedis jedis = null;
		Long val = null;
		if(key==null||"".equalsIgnoreCase(key)){
			return 0;
		}
		
		try {
			
			jedis = this.getResourse();
			if(jedis!=null)
				val = jedis.hset(key, field, value);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			this.returnResourse(jedis);
		}
		return val;
	}
	/**
	 * 获取指定key中的field所存值
	 * @param key
	 * @param field
	 * @return
	 */
	public String hget(String key, String field){
		
		Jedis jedis = null;
		String value = null;
		
		try {
			
			jedis = this.getResourse();
			if(jedis != null){
				value = jedis.hget(key, field);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return value;
	}
	/**
	 * 删除指定的key中fild所对应的值
	 * @param key
	 * @param field
	 * @return
	 */
	public long hdel(String key, String field){
		
		Jedis jedis = null;
		Long value = null;
		
		try {
			
			jedis = this.getResourse();
			if(jedis!=null)
				value = jedis.hdel(key, field);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			this.returnResourse(jedis);
		}
		
		return value;
	}
	/**
	 * 获取指定key中所有的值，结果为list集合
	 * @param key
	 * @return
	 */
	public List<String> hvals(String key){
		
		List<String> list = null;
		Jedis jedis = null;
		
		try {
			
			jedis = this.getResourse();
			if(jedis!=null)
				jedis.hvals(key);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			this.returnResourse(jedis);
		}
		
		return list;
	}
	/**
	 * 获取key所对应的所有值field、value
	 * @param key
	 * @return
	 */
	public Map<String, String> hgetall(String key){
		
		Map<String, String> map = null;
		Jedis jedis = null;
		
		try {
			
			jedis = this.getResourse();
			if(jedis!=null)
				map = jedis.hgetAll(key);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			this.returnResourse(jedis);
		}
		
		return map;
	}
	/**
	 * 获取String类型值
	 * @param key
	 * @return
	 */
	public String read(String key){
		
		String str = new String();
		Jedis jedis = null;
		try{
			jedis = this.getResourse();
			str = jedis.get(key);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			this.returnResourse(jedis);
		}
		
		return str;
		
	}
	
	/**
	 * 将jedis归还pool
	 * @param jedis
	 */
	public void returnResourse(Jedis jedis){
		
		try {

			this.jedisPool.returnResource(jedis);		//将对象归还至jedisPool中
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			this.jedisPool.returnBrokenResource(jedis);	//归还失败时，强制销毁该连接
		}
	}
}
