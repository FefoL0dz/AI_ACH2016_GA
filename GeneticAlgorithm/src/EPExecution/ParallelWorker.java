package EPExecution;

import main.controllers.Handler;

public class ParallelWorker extends Thread {

    private Handler handler;
    private int index;

    public ParallelWorker(int index,
                          int populationSize,
                          int endOfTimes,
                          double mutationProbability,
                          double crossoverProbability) {
        this.index = index;

        this.handler = new Handler
                    (index,
                        populationSize,
                        endOfTimes,
                        mutationProbability,
                        crossoverProbability);
    }

    @Override
    public void run() {
        System.out.println(this.index + " - source file being created...\n");
        this.handler.run();
        System.out.println(this.index + " - source file was createad\n");
    }
}
