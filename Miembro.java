import java.time.LocalDateTime;
import java.util.ArrayList;

public class Miembro {
    private int id;
    private String nombre;
    private ArrayList<Libro> libros;
    private LocalDateTime fechaP;
    private LocalDateTime fechaD;

    public Miembro(int id, String nombre, ArrayList<Libro> libros, LocalDateTime fecha) {
        this.id = id;
        this.nombre = nombre;
        this.libros = libros;
        this.fechaP = fecha;
        this.fechaD = LocalDateTime.now();
    }

    //Methods 
    public void prestarLibro(Libro libro, LocalDateTime fechaP) {
    
    }

    public void devolverLibro(Libro libro, LocalDateTime fechaD) {
    
    }


    //Setters & getters

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
