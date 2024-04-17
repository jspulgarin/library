import java.util.HashMap;
import java.util.Map;

public class Libreria {

    private HashMap<String, Libro> inventario;


    public Libreria() {
        this.inventario = new HashMap<>();
    }


    public void agregarLibro(Libro libro) {
        if (!inventario.containsKey(libro.getTitulo())) {
            inventario.put(libro.getTitulo(), libro);
            System.out.println("Libro agregado: " + libro.getTitulo());
        } else {
            System.out.println("El libro ya existe.");
        }
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        return inventario.get(titulo);
    }

    public Libro buscarLibroPorAutor(String autor) {
        for (Libro libro : inventario.values()) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                return libro;
            }
        }
        return null;
    }

    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (Map.Entry<String, Libro> entry : inventario.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}

