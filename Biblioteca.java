import java.util.ArrayList;

public class Biblioteca {
	// Atributos
    private ArrayList<Libro> libros;
    private ArrayList<Miembro> miembros;

	// Constructor
    public Biblioteca(ArrayList<Libro> libros, ArrayList<Miembro> miembros) {
        this.libros = libros;
        this.miembros = miembros;
    }
	public Biblioteca() {
        this.libros = null;
        this.miembros = null;
    }

    //Setters & getters
	public ArrayList<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public ArrayList<Miembro> getMiembros() {
		return this.miembros;
	}

	public void setMiembros(ArrayList<Miembro> miembros) {
		this.miembros = miembros;
	}



}
