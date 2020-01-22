package cat.paucasesnoves.sppsp;

import cat.paucasesnoves.sppsp.recursos.Filososfo;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Filososfo[] fliososfos = new Filososfo[5];
        Semaphore[] palillo = new Semaphore[fliososfos.length];
        int r = (int) (Math.random() * (fliososfos.length - 1)) + 1;
        for (int i = 0; i < fliososfos.length; i++) {
            palillo[i] = new Semaphore(1);
        }

        for (int i = 0; i < fliososfos.length; i++) {
            Semaphore leftFork = palillo[i];
            Semaphore rightFork = palillo[(i + 1) % palillo.length];

            if (i == r) {
                fliososfos[i] = new Filososfo(rightFork, leftFork);
            } else {
                fliososfos[i] = new Filososfo(leftFork, rightFork);
            }

            Thread t
                    = new Thread(fliososfos[i], "Philosopher " + (i + 1));
            t.start();

        }
    }
}