/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.java.arbolbinario;

/**
 *
 * @author liamy
 */
public class ArbolBinario<T extends Comparable<T>> {
    private Nodo<T> raiz;
    public static void main(String[] args) {
        ArbolBinario<Integer> arbolEnteros = new ArbolBinario<>();
        arbolEnteros.agregar(5);
        arbolEnteros.agregar(3);
        arbolEnteros.agregar(8);
        arbolEnteros.mostrar();

//        ArbolBinario<String> arbolCadenas = new ArbolBinario<>();
//        arbolCadenas.agregar("Hola");
//        arbolCadenas.agregar("Mundo");
//        arbolCadenas.mostrar();

    }

    private static class Nodo<T> {
        private T dato;
        private Nodo<T> izquierdo;
        private Nodo<T> derecho;

        public Nodo(T dato) {
            this.dato = dato;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public void mostrar() {
        mostrarRecursivo(raiz);
    }

    private void mostrarRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.println("Izq");
            mostrarRecursivo(nodo.izquierdo);
            System.out.println(nodo.dato);
            System.out.println("Der");            
            mostrarRecursivo(nodo.derecho);
        }
    }

    public void agregar(T dato) {
        raiz = agregarRecursivo(raiz, dato);
    }

    private Nodo<T> agregarRecursivo(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return new Nodo<>(dato);
        }

        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izquierdo = agregarRecursivo(nodo.izquierdo, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.derecho = agregarRecursivo(nodo.derecho, dato);
        }

        return nodo;
    }

    public void eliminar(T dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    private Nodo<T> eliminarRecursivo(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, dato);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            nodo.dato = encontrarMinimo(nodo.derecho);
            nodo.derecho = eliminarRecursivo(nodo.derecho, nodo.dato);
        }

        return nodo;
    }

    private T encontrarMinimo(Nodo<T> nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }

        return nodo.dato;
    }
}
//// Ejemplo implementacion clase Comparable
//public class Empleado implements Comparable<Empleado> {
//    private int codigo;
//    // otros atributos y métodos de la clase
//
//    public int compareTo(Empleado otroEmpleado) {
//        // Comparar por el código de empleado
//        return Integer.compare(this.codigo, otroEmpleado.codigo);
//    }
//}
