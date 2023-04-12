package org.aguzman.hilos.ejemplos.ejemploexecutor;

import org.aguzman.hilos.ejemplos.ejemplosync.Panaderia;
import org.aguzman.hilos.ejemplos.ejemplosync.runnable.Consumidor;
import org.aguzman.hilos.ejemplos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

/*
 *  El Callable => devuelve un valor a diferencia del Runnable
 * */
public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        var p = new Panaderia();
        Runnable productor =new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();//Se apaga
        System.out.println("Continuando con la ejecución del método main");


    }
}
