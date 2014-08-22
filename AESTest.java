import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

class AESTest {
	public static void main(String[] args) {
//		String test = "1";
		try {
			int i = 0;
			String Mensajes[] = {"6bc1bee22e409f96e93d7e117393172a","ae2d8a571e03ac9c9eb76fac45af8e51",
					"30c81c46a35ce411e5fbc1191a0a52ef","f69f2445df4f9b17ad2b417be66c3710"};
			String Encriptado[] = {"3ad77bb40d7a3660a89ecaf32466ef97","f5d3d58503b9699de785895a96fdbaaf",
					"43b1cd7f598ece23881b00e3ed030688","7b0c785e27e8ad3f8223207104725dd4"};
			while (i<=3) {
			
				byte[] theKey = null;
				byte[] Mensaje = null; 
				byte[] theExp = null; 
		
				theKey = hexToBytes("2b7e151628aed2a6abf7158809cf4f3c");
				Mensaje = hexToBytes(Mensajes[i]);
				theExp = hexToBytes(Encriptado[i]);
				
				Cipher cf = Cipher.getInstance("AES");
				SecretKeySpec skeyspec = new SecretKeySpec(theKey, "AES");
				cf.init(Cipher.ENCRYPT_MODE, skeyspec);
				
				byte[] theCph = cf.doFinal(Mensaje);
				System.out.println("- - - - - - - - - - - - Prueba AES "+(i+1)+ "- - - - - - - - - - - - ");
				System.out.println("Key     : "+bytesToHex(theKey));
		         System.out.println("Message : "+bytesToHex(Mensaje));
		         System.out.println("Cipher  : "+bytesToHex(theCph).substring(0,32));
		         System.out.println("Expected: "+bytesToHex(theExp));;
				i++;
				
				System.out.println(theKey.length);
					
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
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