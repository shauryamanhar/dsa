package crypto.shaurya.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String message = "Hello world";
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(message.getBytes());
		
		
		byte[] digest = md.digest();
		
		StringBuffer hexString = new StringBuffer();
		for(int i=0;i<digest.length;i++) {
			hexString.append(Integer.toHexString(0xFF & digest[i]));
		}
		System.out.println("Message: <"+message+">");
		System.out.println("Hash:<"+hexString+">");
		
	}//main
}
