
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author KAREN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
     private static ArrayList<Contacto> Contactos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);   
    public static void main(String[] args) {
       int opcion;

        do {
            Menu();
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // salto de línea 

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    mostrarListaContactos();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    ordenarPorNombre();
                    break;
                case 5:
                    ordenarPorNumeroTelefono();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void Menu() {
        System.out.println("****** Zona Virtual S.A.********");
        System.out.println("******* Aplicación de Lista de Contactos ********");
        System.out.println("1. Agregar un Nuevo Contacto");
        System.out.println("2. Mostrar Lista de Contactos");
        System.out.println("3. Buscar contacto por nombre");
        System.out.println("4. Ordenar por Burbuja a partir de los nombres");
        System.out.println("5. Ordenar por Inserción a partir de los números Telefónicos");
        System.out.println("6. Salir");
    }

    private static void agregarContacto() {
           
        System.out.println("Ingrese el nombre del contacto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el número de teléfono del contacto:");
        int numeroTelefono = scanner.nextInt();
        scanner.nextLine(); 

        Contacto nuevoContacto = new Contacto(nombre, numeroTelefono);
        Contactos.add(nuevoContacto);
        System.out.println("El contacto fue agregado correctamente.");
            
        
    }

    private static void mostrarListaContactos() {
        if (Contactos.isEmpty()) {
            System.out.println("La lista de contactos está vacía.");
        } else {
            System.out.println("Lista de contactos:");
            for (int i = 0; i < Contactos.size(); i++) {
                System.out.println((i + 1) + ". " + Contactos.get(i).getNombre() + " - " + Contactos.get(i).getNumero());
            }
        }
    }

    private static void buscarContacto() {
        System.out.println("Ingrese el nombre del contacto a buscar:");
        String Buscar = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < Contactos.size(); i++) {
            if (Contactos.get(i).getNombre().equalsIgnoreCase(Buscar)) {
                System.out.println("Contacto encontrado:");
                System.out.println(Contactos.get(i).getNombre() + " - " + Contactos.get(i).getNumero());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static void ordenarPorNombre() {
         for (int i = 0; i < Contactos.size() - 1; i++) {
        for (int j = 0; j < Contactos.size() - i - 1; j++) {
            if (Contactos.get(j).getNombre().compareToIgnoreCase(Contactos.get(j + 1).getNombre()) > 0) {
                
                Contacto temp = Contactos.get(j);
                Contactos.set(j, Contactos.get(j + 1));
                Contactos.set(j + 1, temp);
            }
        }
    }

    System.out.println("Lista de contactos ordenada por nombre (burbuja):");
    mostrarListaContactos();
    }

    private static void ordenarPorNumeroTelefono() {
        for (int i = 1; i < Contactos.size(); i++) {
        Contacto clave = Contactos.get(i);
        int j = i - 1;
        while (j >= 0 && Contactos.get(j).getNumero() > clave.getNumero()) {
            Contactos.set(j + 1, Contactos.get(j));
            j = j - 1;
        }
        Contactos.set(j + 1, clave);
    }

    System.out.println("Lista de contactos ordenada por número de teléfono (inserción):");
    mostrarListaContactos();
    }
    
}
