package cat.paucasesnoves.sppsp;

import cat.paucasesnoves.sppsp.clases.Filosofo;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Filosofo[] filosofos = new Filosofo[5];
        Semaphore[] palillos = new Semaphore[filosofos.length];

        for (int i = 0; i < palillos.length; i++){
            palillos[i] = new Semaphore(1);
        }

        for (int i = 0; i < filosofos.length; i++){
            Semaphore palilloIzquierdo = palillos[i];
            Semaphore palilloDerecho = palillos[(i + 1) % palillos.length];

            if (i == filosofos.length - 1)
            {
                filosofos[i] = new Filosofo(palilloDerecho,palilloIzquierdo,i);
            }else{
                filosofos[i] = new Filosofo(palilloIzquierdo,palilloDerecho,i);
            }
        }

        for(Filosofo f : filosofos){
            f.start();
        }

    }
}
