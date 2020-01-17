package cat.paucasesnoves.sppsp.clases;

import java.util.concurrent.Semaphore;

public class Filosofo extends Thread{

    private Semaphore palilloIzquierdo;
    private Semaphore palilloDerecho;
    private int nombre;

    public Filosofo(Semaphore palilloIzquierdo, Semaphore palilloDerecho,int nombre) {
        this.palilloIzquierdo = palilloIzquierdo;
        this.palilloDerecho = palilloDerecho;
        this.nombre = nombre;
    }

    @Override
    public void run() {

        //No funciona
        /*while(true){
                System.out.println("Estoy pensando filósofo " + nombre);
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Quiero mi palillo izquierdo, soy el filósofo " + nombre);
                try {
                    palilloIzquierdo.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Tengo mi palillo izquierdo, soy el filósofo " + nombre);
                System.out.println("Quiero mi palillo derecho, soy el filósofo " + nombre);
                try {
                    palilloDerecho.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Tengo mi palillo derecho, soy el filósofo " + nombre);
                System.out.println("Estoy listo para comer, soy el filósofo " + nombre);
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Dejo el palillo derecho, soy el filósofo " + nombre);
                palilloDerecho.release();
                System.out.println("Dejo el palillo izquierdo, soy el filósofo " + nombre);

            }*/

        //En principio funciona, pero creo que no se ponen a comer varios al mismo tiempo
        while(true){
            System.out.println("Estoy pensando, filósofo " + nombre);
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
            synchronized (palilloIzquierdo){
                System.out.println("Tengo mi palillo izquierdo, filósofo " + nombre);
                synchronized (palilloDerecho){
                    System.out.println("Tengo mi palillo derecho, filósofo " + nombre);
                    System.out.println("Ya puedo comer, filósofo " + nombre);
                    /*try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println("Dejo mi palillo derecho, filósofo " + nombre);
                }
                System.out.println("Dejo mi palillo izquierdo, filósofo " + nombre);
            }
        }


    }
}
