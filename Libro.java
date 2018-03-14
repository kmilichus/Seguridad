
public class Libro {
	
	private final static boolean NACIONAL = true;
	
	private final static boolean INTERNACIONAL = false;

	private int dia;
	
	private int mes;
	
	private int anho;
	
	private boolean esNacional;
	
	private int cantidadPaginas;
	
	private String isbn;
	
	private String nombre;
	
	private String nombreAutor;
	
	private boolean editadoUltimoAnho;

	public Libro(int dia, int mes, int anho, boolean esNacional,
			int cantidadPaginas, String isbn, String nombre,
			String nombreAutor, boolean editadoUltimoAnho) {
		
		this.dia = dia;
		this.mes = mes;
		this.anho = anho;
		this.esNacional = esNacional;
		this.cantidadPaginas = cantidadPaginas;
		this.isbn = isbn;
		this.nombre = nombre;
		this.nombreAutor = nombreAutor;
		this.editadoUltimoAnho = editadoUltimoAnho;
	}

	/**
	 * @return the dia
	 */
	public int darDia() {
		return dia;
	}

	/**
	 * @param dia the dia to modificar
	 */
	public void modificarDia(int dia) {
		this.dia = dia;
	}

	/**
	 * @return the mes
	 */
	public int darMes() {
		return mes;
	}

	/**
	 * @param mes the mes to modificar
	 */
	public void modificarMes(int mes) {
		this.mes = mes;
	}

	/**
	 * @return the anho
	 */
	public int darAnho() {
		return anho;
	}

	/**
	 * @param anho the anho to modificar
	 */
	public void modificarAnho(int anho) {
		this.anho = anho;
	}

	/**
	 * @return the esNacional
	 */
	public boolean darEsNacional() {
		return esNacional;
	}

	/**
	 * @param esNacional the esNacional to modificar
	 */
	public void modificarEsNacional(boolean esNacional) {
		this.esNacional = esNacional;
	}

	/**
	 * @return the cantidadPaginas
	 */
	public int darCantidadPaginas() {
		return cantidadPaginas;
	}

	/**
	 * @param cantidadPaginas the cantidadPaginas to modificar
	 */
	public void modificarCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	/**
	 * @return the isbn
	 */
	public String darIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to modificar
	 */
	public void modificarIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the nombre
	 */
	public String darNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to modificar
	 */
	public void modificarNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nombreAutor
	 */
	public String darNombreAutor() {
		return nombreAutor;
	}

	/**
	 * @param nombreAutor the nombreAutor to modificar
	 */
	public void modificarNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	/**
	 * @return the editadoUltimoAnho
	 */
	public boolean darEditadoUltimoAnho() {
		return editadoUltimoAnho;
	}

	/**
	 * @param editadoUltimoAnho the editadoUltimoAnho to modificar
	 */
	public void modificarEditadoUltimoAnho(boolean editadoUltimoAnho) {
		this.editadoUltimoAnho = editadoUltimoAnho;
	}

	
	
	
	
	
	
	
}
