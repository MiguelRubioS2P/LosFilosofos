package cat.paucasesnoves.sppsp.recursos;

import java.util.concurrent.Semaphore;

public class Filososfo implements Runnable {

    private Semaphore left;
    private Semaphore right;

    public Filososfo(Semaphore left, Semaphore right) {
        this.left = left;
        this.right = right;
    }
    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 1000)));
    }
    @Override
    public void run() {
        try {
            while (true) {
                //pensar
                doAction("Pensando . . .");
                try {
                    left.acquire();

                    doAction("Cojo el palillo izquierdo");
                    try {
                        right.acquire();
                        doAction("Cojo el palillo derecho - Empiezo a comer . . .");
                        doAction("Dejo el palillo derecho");
                        right.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    doAction("Dejo el palillo izquierdo");
                    left.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}