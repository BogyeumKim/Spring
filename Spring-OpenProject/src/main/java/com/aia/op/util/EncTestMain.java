package com.aia.op.util;

import java.io.UnsupportedEncodingException;

public class EncTestMain {

	public static void main(String[] args)  {

		
		String str = "Hello~Java";
		
		// 단방향 암호화 객체 생성 : SHA-256
		Sha256 sha256 = new Sha256();
		
		String encStr = sha256.encrypt(str);
		
		System.out.println("평문 : " + str);
		System.out.println("SHA-256 암호화 : " + encStr);
		System.out.println(sha256.encrypt("1"));
		System.out.println(sha256.encrypt("1"));
		System.out.println(sha256.encrypt("123456789abcedfg"));
		
		
		// 양방향 암호화 객체 : AES
		// key : 16자리
		String key = "000000000000001";
		try {
			AES256Util aes256 = new AES256Util(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
