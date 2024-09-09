import java.time.LocalDateTime;
import java.util.ArrayList;

public class Miembro {
	// Atributos
	private int id;
	private String nombre;
	private ArrayList<Libro> libros;
	private LocalDateTime fechaP;
	private LocalDateTime fechaD;

	// Constructor
	public Miembro(int id, String nombre, ArrayList<Libro> libros, LocalDateTime fecha) {
		this.id = id;
		this.nombre = nombre;
		this.libros = libros;
		this.fechaP = fecha;
		this.fechaD = LocalDateTime.now();
	}

	// Methods
	public boolean prestarLibro(Libro libro, LocalDateTime fechaP) {
		// Verifica si el libro ya está en la lista de libros prestados por el miembro
		if (!libros.contains(libro)) {
			libros.add(libro); // Añade el libro a la lista de libros prestados
			this.fechaP = fechaP; // Guarda la fecha de préstamo
			libro.incrementarPrestados();
			return true; // Retorna true si el préstamo fue exitoso
		}
		return false; // Retorna false si el libro ya estaba prestado
	}

	public boolean devolverLibro(Libro libro, LocalDateTime fechaD) {
		// Verifica si el libro está en la lista de libros prestados
		if (libros.contains(libro)) {
			libros.remove(libro); // Elimina el libro de la lista de libros prestados
			this.fechaD = fechaD; // Guarda la fecha de devolución
			return true; // Retorna true si la devolución fue exitosa
		}
		return false; // Retorna false si el libro no estaba prestado
	}

	// Setters & getters
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public LocalDateTime getFechaP() {
		return this.fechaP;
	}

	public void setFechaP(LocalDateTime fechaP) {
		this.fechaP = fechaP;
	}

	public LocalDateTime getFechaD() {
		return this.fechaD;
	}

	public void setFechaD(LocalDateTime fechaD) {
		this.fechaD = fechaD;
	}

}
