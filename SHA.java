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

public class SHA {

	private static String cadenaHash = "";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {


		/*Se crea un objeto BufferedReader para leer por consola los nombres del archivo de prueba que se desea aplicar la función hash y el archivo donde se guardará el hash */
		BufferedReader in = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("por favor digite nombre del archivo de prueba");
		String archivoprueba = in.readLine();
		System.out.println("por favor digite nombre del archivo donde se guardara la funcion hash generada apartir del archivo de prueba ");
		String archivoConHash= in.readLine();

		/* Se preparan los objetos para leer el archivo que será resumido mediante la función hash */
		try {

			/* Abrir el archivo */
			FileInputStream archivo = new FileInputStream(archivoprueba);


			/* Crear el objeto de entrada */
			DataInputStream entrada = new DataInputStream(archivo);

			/* Crear el Buffer de Lectura */
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));
			String lectura;

			/* Crear el archivo donde se guardará el hash del archivo de prueba */	
			File archivoHash;
			archivoHash = new File(archivoConHash);

			/* Escritura */
			try {
				FileWriter escritorFichero = new FileWriter(archivoHash);
				BufferedWriter escritorBuffer = new BufferedWriter(
						escritorFichero);
				PrintWriter imprimir = new PrintWriter(escritorBuffer);

				/* Leer el archivo linea por linea */				
				String infoLectura="";
				while ((lectura = buffer.readLine()) != null) {

					infoLectura = infoLectura+"\n"+lectura;
				}

				cadenaHash = hash(infoLectura.getBytes());

				/* Escribe el hash obtenido */
				imprimir.write(cadenaHash);
				System.out.println("\n"+"Este es el hash generado a partir del archivo de prueba: "+cadenaHash);

				/* Cerrar el archivo y el escritor*/
				entrada.close();
				imprimir.close();
				escritorBuffer.close();
			} catch (IOException e) {
			}
			;
		} catch (Exception e) {
			System.err.println("Ocurrio un error: " + e.getMessage());
		}

	}

	public static String hash(byte[] msg) {

		try {

			/* Se crea el objeto MessageDigest instanciándolo con el tipo de algoritmo que se usará en este caso SHA1 */
			MessageDigest algorithm = MessageDigest.getInstance("SHA1");

			/* se limpia el objeto creado por medio del método reset() */
			algorithm.reset();

			/* se carga por medio del método update() el arreglo de bytes al cual se desea obtener la función hash */
			algorithm.update(msg);

			/* mediante el método digest() se obtiene un nuevo arreglo de bytes que contiene el hash */
			byte messageDigest[] = algorithm.digest();

			/*se convierte el arreglo de bytes a hexadecimal y se retorna como una cadena */
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
