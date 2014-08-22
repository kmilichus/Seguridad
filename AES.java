
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.print.DocFlavor.STRING;


public class AES
{


	private static SecretKeySpec secretKey ;
	private static byte[] key ;

	private static String decryptedString;
	private static String encryptedString;


	public static void setKey(String myKey){


		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			System.out.println(key.length);
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16); // use only first 128 bit
			System.out.println(key.length);
			System.out.println(new String(key,"UTF-8"));
			secretKey = new SecretKeySpec(key, "AES");


		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	public static String getDecryptedString() {
		return decryptedString;
	}

	public static void setDecryptedString(String decryptedString) {
		AES.decryptedString = decryptedString;
	}

	public static String getEncryptedString() {
		return encryptedString;
	}

	public static void setEncryptedString(String encryptedString) {
		AES.encryptedString = encryptedString;
	}

	public static String encrypt(String strToEncrypt)
	{
		try
		{
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE, secretKey);


			setEncryptedString(bytesToHex((cipher.doFinal(strToEncrypt.getBytes("UTF-8")))));

		}
		catch (Exception e)
		{

			System.out.println("Error while encrypting: "+e.toString());
		}
		return null;

	}

	public static String decrypt(String strToDecrypt)
	{
		try
		{
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			setDecryptedString(new String(cipher.doFinal(hexToBytes(strToDecrypt))));

		}
		catch (Exception e)
		{

			System.out.println("Error while decrypting: "+e.toString());

		}
		return null;
	}


	public static void main(String args[])
	{

		String strToEncrypt = "";
		final String llave = "2b7e151628aed2a6abf7158809cf4f3c";
		int i = 0;	
		String Mensajes[] = {"6bc1bee22e409f96e93d7e117393172a","ae2d8a571e03ac9c9eb76fac45af8e51",
				"30c81c46a35ce411e5fbc1191a0a52ef","f69f2445df4f9b17ad2b417be66c3710"};
		String Encriptado[] = {"3ad77bb40d7a3660a89ecaf32466ef97","f5d3d58503b9699de785895a96fdbaaf",
				"43b1cd7f598ece23881b00e3ed030688","7b0c785e27e8ad3f8223207104725dd4"};
		
		while (i<4) {
			
			AES.setKey(llave);		
			strToEncrypt = Mensajes[i];
			AES.encrypt(strToEncrypt.trim());
			System.out.println("- - - - - - - - - - - - Prueba AES"+(i+1)+ "- - - - - - - - - - - - ");
			System.out.println("Key     : "+llave);
	         System.out.println("Message : "+strToEncrypt);
	         System.out.println("Cipher  : "+AES.getEncryptedString());
	         System.out.println("Expected: "+Encriptado[i]);
			i++;
			
		}
		
	
//
//		System.out.println("String to Encrypt: " + strToEncrypt); 
//		System.out.println("Encrypted: " + AES.getEncryptedString());
//
//		final String strToDecrypt =  AES.getEncryptedString();
//		AES.decrypt(strToDecrypt.trim());
//
//		System.out.println("String To Decrypt : " + strToDecrypt);
//		System.out.println("Decrypted : " + AES.getDecryptedString());

	}

	public static byte[] hexToBytes(String str) {
		if (str==null) {
			return null;
		} else if (str.length() < 2) {
			return null;
		} else {
			int len = str.length() / 2;
			byte[] buffer = new byte[len];
			for (int i=0; i<len; i++) {
				buffer[i] = (byte) Integer.parseInt(
						str.substring(i*2,i*2+2),16);
			}
			return buffer;
		}

	}
	public static String bytesToHex(byte[] data) {
		if (data==null) {
			return null;
		} else {
			int len = data.length;
			String str = "";
			for (int i=0; i<len; i++) {
				if ((data[i]&0xFF)<16) str = str + "0" 
				+ java.lang.Integer.toHexString(data[i]&0xFF);
				else str = str
				+ java.lang.Integer.toHexString(data[i]&0xFF);
			}
			return str.toUpperCase();
		}
	}            
}

