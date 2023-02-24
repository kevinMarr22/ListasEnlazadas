package com.company;

import java.util.Scanner;

public class Principal {

    static Scanner teclado = new Scanner(System.in);
    static String textoIngresado;
    static String selec;
    static String selecKeep;
    static int seguir = 1;
    static int numeroSelec;
    static funciones<String> listaDoble = new funciones<>();

    public static void main(String[] args) {
        System.out.println("Bienvenido");

        while (seguir == 1){

            System.out.println("Ingrese una opcion");
            System.out.println("1. Ingresar al principio de la fila");
            System.out.println("2. Ingresar al final de la fila");
            System.out.println("3. Recorrer la fila hacia adelante");
            System.out.println("4. Recorrer la fila hacia atras");
            System.out.println("5. Mostrar el tamaño");
            System.out.println("6. y si la lista esta vacia?");
            System.out.println("7. Buscar un elemento por valor");
            System.out.println("8. Buscar un elemento por indice");
            System.out.println("9. Borrar un elemento");


            selec = teclado.nextLine();

            switch (selec) {
                case "1" -> {
                    System.out.println("Ingrese un texto al principio de la fila");
                    textoIngresado = teclado.nextLine();
                    listaDoble.insertAtHead(textoIngresado);
                    System.out.println("Se ingreso el texto " + textoIngresado + " al inicio de" +
                            " la lista");
                }
                case "2" -> {
                    System.out.println("Ingrese un texto al final de la fila");
                    textoIngresado = teclado.nextLine();
                    listaDoble.insertAtTail(textoIngresado);
                    System.out.println("El texto: " + textoIngresado + " al final de" +
                            " la lista");

                }
                case "3" -> {
                    System.out.println("Se recorre la fila hacia adelante");
                    listaDoble.traverseForward();

                }
                case "4" -> {
                    System.out.println("Se recorre la fila hacia atras");
                    listaDoble.traverseBackward();

                }
                case "5" -> System.out.println("El tamaño de la lista es: " + listaDoble.size());

                case "6" -> {
                    System.out.println("La lista esta vacia?");
                    if (!listaDoble.isEmpty()) {
                        System.out.println("No esta vacia");
                    } else {
                        System.out.println("Esta vacia");
                    }

                }
                case "7" -> {
                    System.out.println("Se buscara el texto ingresado");
                    textoIngresado = teclado.nextLine();
                    var Hola = listaDoble.searchByValue(textoIngresado);

                    if (Hola != null) {
                        System.out.println("El texto: "
                                + listaDoble.searchByValue(textoIngresado) + " se ha encontrado");
                    } else {

                        System.out.println("No se encontro el texto");
                    }

                }
                case "8" -> {
                    System.out.println("Se buscara el texto por el indice");
                    System.out.println("El indice empieza en 0 y termina en " + (listaDoble.size() - 1));
                    textoIngresado = teclado.nextLine();
                    numeroSelec = Integer.parseInt(textoIngresado);

                    if (numeroSelec == -1) {
                        numeroSelec++;

                    }else if(numeroSelec < -1){
                        System.out.println("No se puede buscar numeros negativos");
                    }

                    if (numeroSelec >= listaDoble.size()) {
                        System.out.println("Ese indice supera el de la lista");
                    } else {
                        System.out.println("El texto esta en " + numeroSelec
                                + " y es " + listaDoble.searchByIndex(numeroSelec));
                    }

                }
                case "9" -> {System.out.println("Se borrara un texto");
                    System.out.println("Elija la posicion que desea borrar");
                    System.out.println("1. El principio");
                    System.out.println("2. El final");
                    System.out.println("3. Una posicion entre el principio y el final");
                    textoIngresado = teclado.nextLine();

                    if (textoIngresado.equals("1")){
                        System.out.println("Se borrara el primer elemento de la lista");
                        listaDoble.deleteFromHead();

                    }else if (textoIngresado.equals("2")){
                        System.out.println("Se borrara el elemento final de la lista");
                        listaDoble.deleteFromTail();

                    }else if(textoIngresado.equals("3")){
                        if (listaDoble.size() <= 2){
                            System.out.println("No se puede utilizar esta opcion con una lista de 2 elementos o menos");

                        }else{
                            System.out.println("Ingrese el indice del elemento a borrar");
                            System.out.println("Advertencia de no borrar el principio o final de la lista");
                            textoIngresado = teclado.nextLine();
                            numeroSelec = Integer.parseInt(textoIngresado);
                            if (numeroSelec < 1 || numeroSelec >= (listaDoble.size())){
                                System.out.println("Seleccion invalida");
                            }else{
                                System.out.println("Se borro el texto " + listaDoble.searchByIndex(numeroSelec));
                                listaDoble.deleteFromPosition(numeroSelec);
                            }
                        }
                    }else{
                        System.out.println("Error");
                    }
                }
            }

            System.out.println("\n Quiere volver al menu");
            System.out.println("1. Si   2. No");
            selecKeep = teclado.nextLine();
            if (selecKeep.equals("1")){
                System.out.println("Regresando al menu principal \n");
            }else if (selecKeep.equals("2")){
                System.out.println("hasta la otra");
                seguir++;
            }else {
                System.out.println("Error");
            }
        }

    }
}
