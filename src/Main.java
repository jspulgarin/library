import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Libreria libreria = new Libreria();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        do {

            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Agregar Nuevo Libro");
            System.out.println("2. Buscar Libro por Título");
            System.out.println("3. Buscar Libro por Autor");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Realizar Préstamo");
            System.out.println("6. Devolver Libro Prestado");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");


            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {

                scanner.nextLine();
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:

                    agregarNuevoLibro(libreria, scanner);
                    break;
                case 2:

                    buscarLibroPorTitulo(libreria, scanner);
                    break;
                case 3:

                    buscarLibroPorAutor(libreria, scanner);
                    break;
                case 4:

                    libreria.mostrarInventario();
                    break;
                case 5:

                    realizarPrestamo(libreria, scanner);
                    break;
                case 6:

                    devolverLibroPrestado(libreria, scanner);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }
        } while (opcion != 7);

        scanner.close();
    }


    private static void agregarNuevoLibro(Libreria libreria, Scanner scanner) {
        System.out.println("Ingrese los detalles del libro:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anioPublicacion = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        Libro libro = new Libro(titulo, autor, isbn, editorial, anioPublicacion, precio);
        libreria.agregarLibro(libro);
    }


    private static void buscarLibroPorTitulo(Libreria libreria, Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String tituloBusqueda = scanner.nextLine();
        Libro libroEncontrado = libreria.buscarLibroPorTitulo(tituloBusqueda);
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado:");
            System.out.println(libroEncontrado);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }


    private static void buscarLibroPorAutor(Libreria libreria, Scanner scanner) {
        System.out.print("Ingrese el autor del libro: ");
        String autorBusqueda = scanner.nextLine();
        Libro libroEncontradoPorAutor = libreria.buscarLibroPorAutor(autorBusqueda);
        if (libroEncontradoPorAutor != null) {
            System.out.println("Libro encontrado:");
            System.out.println(libroEncontradoPorAutor);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

   
    private static void realizarPrestamo(Libreria libreria, Scanner scanner) {
        System.out.print("Ingrese el título del libro a prestar: ");
        String tituloPrestamo = scanner.nextLine();
        Libro libroPrestamo = libreria.buscarLibroPorTitulo(tituloPrestamo);
        if (libroPrestamo != null) {

            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }


    private static void devolverLibroPrestado(Libreria libreria, Scanner scanner) {
        System.out.print("Ingrese el título del libro a devolver: ");
        String tituloDevolucion = scanner.nextLine();
        System.out.println("Libro devuelto con éxito.");
    }
}
