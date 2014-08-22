import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class verificacion {

	private static String linea = "";
	private static String comparar = "";
	private static String lineahash;
	private static String compararHash;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*Se crea un objeto BufferedReader para leer por consola los nombre del archivo de prueba y el archivo donde se encuentra la funci�n hash del archivo de prueba */

		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("por favor digite nombre del archivo de prueba");
		String archivoprueba = br.readLine();
		System.out.println("por favor digite nombre del archivo donde esta la funcion hash del archivo de prueba ");
		String archivoConHash= br.readLine();

		/* Se preparan los objetos para leer el archivo que ser� resumido mediante la funci�n hash */			
		try {

			// Abrir el archivo de prueba
			FileInputStream archivo = new FileInputStream(archivoprueba);

			// Crear el objeto de entrada
			DataInputStream entrada = new DataInputStream(archivo);

			// Crear el Buffer de Lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));

			// Leer el archivo de prueba l�nea por l�nea					
			String infoLectura="";
			while ((linea = buffer.readLine()) != null) {
				//comparar = comparar + hash(linea.getBytes());
				infoLectura = infoLectura+"\n"+linea;
			}

			/* Se genera el Hash del archivo de prueba */			
			comparar = hash(infoLectura.getBytes());
			System.out.println("\n"+"Hash generado del archivo de prueba: " +comparar);
			FileInputStream archivoHash = new FileInputStream(archivoConHash);

			/* Ahora se procede a leer la informaci�n del archivo que contiene el resumen del archivo de prueba */

			// Crear el objeto de entrada
			DataInputStream entradahash = new DataInputStream(archivoHash);

			// Crear el Buffer de Lectura
			BufferedReader bufferHash = new BufferedReader(
					new InputStreamReader(entradahash));
			entrada.close();

			// Leer el archivo l�nea por l�nea
			while ((lineahash = bufferHash.readLine()) != null) {

				// Imprimir la l�nea por consola
				compararHash = lineahash;
				System.out.println( "Hash leido de archivo: "+compararHash);
			}
			// Cerrar el archivo
			entradahash.close();
		} catch (Exception e) { 
			System.err.println("Ocurrio un error: " + e.getMessage());
		}
		if (comparar.equals(compararHash)) {
			System.out.println("\n"+"El archivo no ha sido modificado");
		} else {
			System.out.println("\n"+"ATENCION: El archivo ha sido modificado");
		}

	}

	public static String hash(byte[] msg) {

		try {

			/*Se crea el objeto MessageDigest instanci�ndolo con el tipo de algoritmo que se usar� en este caso SHA1 */
			MessageDigest algorithm = MessageDigest.getInstance("SHA1");

			/* se limpia el objeto creado por medio del m�todo reset() */
			algorithm.reset();

			/*se carga por medio del m�todo update() el arreglo de bytes al cual se desea obtener la funci�n hash */
			algorithm.update(msg);

			/*mediante el m�todo digest() se obtiene un nuevo arreglo de bytes que contiene el hash */
			byte messageDigest[] = algorithm.digest();

			/*se convierte el arreglo de bytes a hexadecimal y se retorna como cadena */
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException i) {
			return null;
		}
	}
}

