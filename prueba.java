import java.security.Key;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class prueba {
	public static void main(String[] args) {
//		String test = "1";
		try {
			int i = 0;
			String Mensajes[] = {"0000000000000001","0000000000000002","0000000000000004",
					"0000000000000008","0000000000000010"};
			String Encriptado[] = {"166B40B44ABA4BD6","06E7EA22CE92708F","D2FD8867D50D2DFE",
					"CC083F1E6D9E85F6","5B711BC4CEEBF2EE"};
			while (i<=4) {
			
				byte[] theKey = null;
				byte[] MensajeEncriptado = null; 
				byte[] theExp = null; 
		
				theKey = hexToBytes("0101010101010101");
				MensajeEncriptado = hexToBytes(Mensajes[i]);
				theExp = hexToBytes(Encriptado[i]);
				
				KeySpec ks = new DESKeySpec(theKey);
				SecretKeyFactory kf 
				= SecretKeyFactory.getInstance("DES");
				SecretKey ky = kf.generateSecret(ks);
				Cipher cf = Cipher.getInstance("DES/ECB/NoPadding");
				cf.init(Cipher.ENCRYPT_MODE,ky);
				byte[] theCph = cf.doFinal(MensajeEncriptado);
				System.out.println("- - - - - - - - - - - - Prueba"+(i+1)+ "- - - - - - - - - - - - ");
				System.out.println("Llave:"+bytesToHex(theKey));
				System.out.println("Mensaje Encriptado:"+bytesToHex(MensajeEncriptado));
				System.out.println("Mensaje Desencriptado:"+bytesToHex(theCph));
				System.out.println("Esperado:"+bytesToHex(theExp));
				i++;
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