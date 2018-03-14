
public class Libreria {

	private final static int CANTIDAD_MAXIMA_LIBROS = 500;

	private String nombre;

	private String direccion;

	private String nit;

	private Libro[] libros;

	public Libreria(String nom, String dir, String elNit) {

		nombre = nom;
		direccion = dir;
		nit = elNit;
		libros = new Libro[CANTIDAD_MAXIMA_LIBROS];

	}


	// agregar libro

	public boolean agregarLibro (int dia, int mes, int anho, boolean esNacional,
			int cantidadPaginas, String isbn, String nombre,
			String nombreAutor, boolean editadoUltimoAnho){
		
		boolean seAgrego = false;
		
		Libro nuevoLibro = new Libro(dia, mes, anho, esNacional, cantidadPaginas, isbn, nombre, nombreAutor, editadoUltimoAnho);
		
		for (int i = 0; i < libros.length && !seAgrego; i++) {
			
			if (libros[i]==null) {
				libros[i]= nuevoLibro;
				seAgrego = true;
			}
			
		}


		return seAgrego;
	}
	
	//dar libro
	
	public Libro darLibro(int pos){
		Libro librito = null;
		
		if (pos>=0 && pos <CANTIDAD_MAXIMA_LIBROS) {
			
			librito= libros[pos];
		}
		
		return librito;
	}
	
	// esta libro
	
	public boolean estaLibro (String nombre){
		boolean esta = false;
		int indice =0;
		while (indice<CANTIDAD_MAXIMA_LIBROS && !esta) {
			Libro temporal = libros[indice];
			
			if (temporal != null && temporal.darNombre().equals(nombre)) {
				esta= true;
			}
			
			indice++;
		}
		return esta;
	}
	
	
	public Libro libroMasViejo(){
		
		Libro masViejo = null;
		
		int i = 0;
		
		while(i<libros.length){
			
			if(libros[i]!=null){
			
				if(masViejo == null){
					masViejo = libros[i];
				}else{
					if(libros[i].darAnho()< masViejo.darAnho()){
						masViejo = libros[i];
					}else if (libros[i].darAnho() == masViejo.darAnho() && libros[i].darMes() < masViejo.darMes() ){
						masViejo = libros[i];
					}else if (libros[i].darAnho() == masViejo.darAnho() && libros[i].darMes() == masViejo.darMes() && libros[i].darDia()< masViejo.darDia() ){
						masViejo = libros[i];
					}
				}	
			}
			i++;
		}
		
		return masViejo;
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
	 * @return the direccion
	 */
	public String darDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to modificar
	 */
	public void modificarDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the nit
	 */
	public String darNit() {
		return nit;
	}

	/**
	 * @param nit the nit to modificar
	 */
	public void modificarNit(String nit) {
		this.nit = nit;
	}

	/**
	 * @return the libros
	 */
	public Libro[] darLibros() {
		return libros;
	}

	/**
	 * @param libros the libros to modificar
	 */
	public void modificarLibros(Libro[] libros) {
		this.libros = libros;
	}







}
