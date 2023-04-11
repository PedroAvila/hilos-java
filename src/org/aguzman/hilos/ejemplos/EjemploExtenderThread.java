package org.aguzman.hilos.ejemplos;

import org.aguzman.hilos.ejemplos.thread.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new  NombreThread("Jhon Doe");
        hilo.start();
        //Thread.sleep(100);

        Thread hilo2 = new NombreThread("María");
        hilo2.start();

        NombreThread hilo3 = new NombreThread("Pepe Gay");
        hilo3.start();
        System.out.println(hilo.getState());
    }
}
