import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una lista de sucursales (bibliotecas)
        List<Biblioteca> sucursales = new ArrayList<>();
        boolean salir = false; // Variable para controlar el ciclo
        int nLibrosP = 0; // Variable para llevar control de libros prestados
        // Archivos CSV en el directorio
        String urlLibrosCSV = "libros.csv";
        String urlMiembrosCSV = "miembros.csv";

        while (!salir) {
            System.out.println("---- Sistema de Biblioteca ----");
            System.out.println("1. Agregar Sucursal");
            System.out.println("2. Agregar Libro a una Sucursal");
            System.out.println("3. Registrar Miembro en una Sucursal");
            System.out.println("4. Prestar Libro");
            System.out.println("5. Devolver un Libro");
            System.out.println("6. Análisis de Estadísticas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Agregar una nueva sucursal
                    System.out.print("Ingrese el nombre de la nueva sucursal: ");
                    String nombreSucursal = scanner.nextLine();
                    sucursales.add(new Biblioteca());
                    System.out.println("Sucursal " + nombreSucursal + " agregada.");
                    break;

                case 2:
                    // Agregar Libro a una Sucursal
                    if (sucursales.isEmpty()) {
                        System.out.println("No hay sucursales registradas. Agregue una primero.");
                        break;
                    }

                    System.out.print("Ingrese el ISBN (formato 978XXXXXXXXXX): ");
                    String isbn = scanner.nextLine();

                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Ingrese el año de publicación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el género: ");
                    String genero = scanner.nextLine();

                    Libro nuevoLibro = new Libro(isbn, titulo, autor, anio, genero);

                    // Array de Strings para escribir el csv
                    String[] filaLibro = { isbn, titulo, autor, String.valueOf(anio), genero, "0" };

                    escribirCsv(urlLibrosCSV, filaLibro);

                    sucursales.get(0).getLibros().add(nuevoLibro);
                    System.out.println("Libro agregado con éxito.");
                    break;

                case 3:
                    // Registrar Miembro
                    if (sucursales.isEmpty()) {
                        System.out.println("No hay sucursales registradas. Agregue una primero.");
                        break;
                    }

                    System.out.print("Ingrese el ID del miembro (4 dígitos): ");
                    int idMiembro = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el nombre del miembro: ");
                    String nombreMiembro = scanner.nextLine();
                    ArrayList<Libro> librosM = new ArrayList<>();

                    Miembro nuevoMiembro = new Miembro(idMiembro, nombreMiembro, librosM, null);
                    sucursales.get(0).getMiembros().add(nuevoMiembro);
                    System.out.println("Miembro registrado con éxito.");
                    break;

                case 4:
                    // Prestar un libro
                    System.out.println("Ingrese el ID del miembro (4 dígitos): ");
                    idMiembro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el ISBN del libro: ");
                    isbn = scanner.nextLine();
                    // scanner.nextLine();
                    LocalDateTime fechaPrestamo = LocalDateTime.now(); // Registrar fecha de préstamo

                    Miembro miembro = buscarMiembroPorID(sucursales.get(0).getMiembros(), idMiembro);
                    Libro libro = buscarLibroPorISBN(sucursales.get(0).getLibros(), isbn);

                    if (miembro != null && libro != null) {
                        boolean prestamoExitoso = miembro.prestarLibro(libro, fechaPrestamo);
                        if (prestamoExitoso) {
                            System.out.println("Préstamo exitoso.");
                            nLibrosP++;
                        } else {
                            System.out.println("El libro ya está prestado.");
                        }
                    } else {
                        System.out.println("Miembro o libro no encontrado.");
                    }
                    break;

                case 5:
                    // Devolver un libro
                    System.out.println("Ingrese el ID del miembro: ");
                    idMiembro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el ISBN del libro: ");
                    isbn = scanner.nextLine();
                    // scanner.nextLine();
                    LocalDateTime fechaDevolucion = LocalDateTime.now(); // Registrar fecha de devolución

                    miembro = buscarMiembroPorID(sucursales.get(0).getMiembros(), idMiembro);
                    libro = buscarLibroPorISBN(sucursales.get(0).getLibros(), isbn);

                    if (miembro != null && libro != null) {
                        boolean devolucionExitosa = miembro.devolverLibro(libro, fechaDevolucion);
                        if (devolucionExitosa) {
                            System.out.println("Devolución exitosa.");
                        } else {
                            System.out.println("El libro no estaba prestado.");
                        }
                    } else {
                        System.out.println("Miembro o libro no encontrado.");
                    }
                    break;

                case 6:
                    // Análisis de estadísticas
                    System.out.println("Total de libros prestados: " + nLibrosP);

                    for (Libro libroEstadisticas : sucursales.get(0).getLibros()) {
                        System.out.println("El libro '" + libroEstadisticas.getTitulo() + "' ha sido prestado "
                                + libroEstadisticas.getNPrestados() + " veces.");
                    }
                    break;

                case 7:
                    // Salir del ciclo
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static Miembro buscarMiembroPorID(ArrayList<Miembro> miembros, int id) {
        for (Miembro m : miembros) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    private static ArrayList<String[]> leerCsv(String urlCSV) {
        String fila_completa;
        String[] fila;
        ArrayList<String[]> filas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(urlCSV))) {
            while ((fila_completa = br.readLine()) != null) {
                // Usa el delimitador para dividir cada línea en columnas
                fila = fila_completa.split(",");

                filas.add(fila);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filas;
    }

    private static void escribirCsv(String urlCSV, String[] fila) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(urlCSV, true))) {
            // Escribe los datos de la fila como un mismo String seaparado por comas
            writer.write(String.join(",", fila));
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Función para buscar un libro en el ArrayList de la base de datos del csv
    private static String[] csvbuscarPorIsbn(ArrayList<String[]> filas, String isbn) {
        for (String[] fila : filas) {
            if (fila.length > 0 && fila[0].equals(isbn)) {
                return fila;
            }
        }
        return null;
    }

    private static Libro buscarLibroPorISBN(ArrayList<Libro> libros, String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }
}