package org.aguzman.hilos.ejemplos.ejemplosync;

import org.aguzman.hilos.ejemplos.ejemplosync.runnable.Consumidor;
import org.aguzman.hilos.ejemplos.ejemplosync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        var p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
