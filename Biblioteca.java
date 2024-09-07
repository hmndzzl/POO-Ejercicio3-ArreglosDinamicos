public class Biblioteca {
    private Libro libros;
    private Miembro miembro;

    public Biblioteca(Libro libros, Miembro miembro) {
        this.libros = libros;
        this.miembro = miembro;
    }

    //Setters & getters
    
    public Libro getLibros() {
		return this.libros;
	}

	public void setLibros(Libro libros) {
		this.libros = libros;
	}

	public Miembro getMiembro() {
		return this.miembro;
	}

	public void setMiembro(Miembro miembro) {
		this.miembro = miembro;
	}


}
