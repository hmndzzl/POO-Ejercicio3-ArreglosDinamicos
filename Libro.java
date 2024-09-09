public class Libro {
    private int isbn;
    private String Titulo;
    private String autor;
    private int anio; 
    private String genero;

    public Libro(int isbn, String titulo, String autor, int anio, String genero){
        this.isbn = isbn;
        this.Titulo = titulo;
		this.autor = autor;
		this.anio = anio;  // Por defecto, el año de publicación es 0
        this.genero = genero;
    }

    //Setter & Getters

    public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return this.Titulo;
	}

	public void setTitulo(String Titulo) {
		this.Titulo = Titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}

