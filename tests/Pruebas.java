package tests;
import src.*;

public class Pruebas{

    public static void main(String[] args) {

        HashTable hash = new HashTable<>(7);

        /* Pruebas requeridas para la practica */

        // Prueba 1
        System.out.println("\n**** Prueba no.1: Tabla vacía ****\n");
        System.out.println("Se ejecuto: buscar(10)");
        var val0 = hash.buscar(10);
        System.out.println("Resultado: " + val0);

        // Prueba 2
        System.out.println("\n**** Prueba no.2: inserción básica ****\n");
        System.out.println("Se ejecuto: insertar(18, Ana)");
        hash.insertar(18, "Ana");
        System.out.println("Se ejecuto: insertar(18, Luis)");
        hash.insertar(10, "Luis");
        System.out.println("Se ejecuto: insertar(18, Elena)");
        hash.insertar(23, "Elena");

        System.out.println("\nSe ejecuto: buscar(18)");
        var val1 = hash.buscar(18);
        System.out.println("Resultado: " + val1);

        System.out.println("Se ejecuto: buscar(10)");
        var val2 = hash.buscar(10);
        System.out.println("Resultado: " + val2);
        
        System.out.println("Se ejecuto: buscar(23)");
        var val3 = hash.buscar(23);
        System.out.println("Resultado: " + val3);

        // Prueba 3
        System.out.println("\n**** Prueba no.3: colisiones ****");
        System.out.println("Se ejecuto: insertar(24, Maria)");
        hash.insertar(24, "Maria");
        System.out.println("Se ejecuto: insertar(31, Carlos)");
        hash.insertar(31, "Carlos");

        System.out.println("\nSe ejecuto: buscar(10)");
        var val4 = hash.buscar(10);
        System.out.println("Resultado: " + val4);

        System.out.println("Se ejecuto: buscar(24)");
        var val5 = hash.buscar(24);
        System.out.println("Resultado: " + val5);

        System.out.println("Se ejecuto: buscar(31)");
        var val6 = hash.buscar(31);
        System.out.println("Resultado: " + val6);

        // Prueba 4
        System.out.println("\n**** Prueba no.4: eliminación con colisión ****");

        System.out.println("\nSe ejecuto: eliminar(24)");
        hash.eliminar(24);
        
        System.out.println("\nSe ejecuto: buscar(24)");
        var val7 = hash.buscar(24);
        System.out.println("Resultado: " + val7);


        System.out.println("Se ejecuto: buscar(10)");
        var val8 = hash.buscar(10);
        System.out.println("Resultado: " + val8);

        System.out.println("Se ejecuto: buscar(31)");
        var val9 = hash.buscar(31);
        System.out.println("Resultado: " + val9);

        // Prueba 5
        System.out.println("\n**** Prueba 5: llave inexistente ****");

        System.out.println("\nSe ejecutó eliminar(999)");
        hash.eliminar(999);

        // Prueba 6
        System.out.println("\n**** Prueba 6: actualización de llave existente ****");

        System.out.println("\nSe ejecutó insertar(18, Ana Maria)");
        hash.insertar(18, "Ana Maria");
        System.out.println("Se ejecutó: buscar(18)");
        var val10 = hash.buscar(18);
        System.out.println("Resultado: " + val10);
        


        System.out.println("\n**** Tabla final ****");
        System.out.println(hash);
        
        


    }
}