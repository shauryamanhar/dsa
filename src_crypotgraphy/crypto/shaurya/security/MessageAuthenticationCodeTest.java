package crypto.shaurya.security;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

//https://www.tutorialspoint.com/java_cryptography/java_cryptography_creating_mac.htm
public class MessageAuthenticationCodeTest {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		SecureRandom secureRandomNumber = new SecureRandom();
		
		keyGen.init(secureRandomNumber);
		
		Key key = keyGen.generateKey();
		
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(key);
		
		String message = "Hello world";
		byte[] bytes = message.getBytes();
		byte[] macResult = mac.doFinal(bytes);
		
		System.out.println("Message<"+message+">");
		System.out.println("Mac Result:<"+new String(macResult)+">");
	}//main

}
