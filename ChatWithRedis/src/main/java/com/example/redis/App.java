package com.example.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class App {
	    public static void main(String[] args) {
	        // Kết nối tới Redis server
	        Jedis jedis = new Jedis("localhost", 6379);
	        
	        // Gửi tin nhắn
	        jedis.lpush("messages", "Hello world");
	        
	        // Nhận tin nhắn
	        List<String> message = jedis.brpop(0, "messages");
	        if (!message.isEmpty()) {
	            System.out.println("Received message: " + message.get(1));
	        }
	        
	        // Đóng kết nối
	        jedis.close();
	    }
}
