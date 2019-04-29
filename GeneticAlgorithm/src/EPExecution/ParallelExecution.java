package EPExecution;

import main.controllers.Handler;
import main.utils.io.folder.FolderNamesList;

import java.util.Scanner;

public class ParallelExecution {
    ParallelExecution() {
    }


    public void execute(int firstPopulationSize, int lastPopulationSize, int numberOfExecutions,
                        int generationsNumber,
                        double mutationProbability,
                        double crossoverProbability) {
        int populationSize = firstPopulationSize;
        int inc = (lastPopulationSize - firstPopulationSize) / (numberOfExecutions -1);
        this.pool = new Thread[numberOfExecutions];

        for(int i = 0; i < numberOfExecutions; i++) {
            pool[i] = new ParallelWorker(i + 1, populationSize, generationsNumber, mutationProbability, crossoverProbability);

            populationSize = populationSize + inc;
        }

        for(int i = 0; i < numberOfExecutions; i++)
        {
            pool[i].start();
        }

        for(int i = 0; i < numberOfExecutions; i++)
        {
            try {
                pool[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("It`s Over! Now you can check on: " +
                FolderNamesList.ROOT_PATH_ORIGIN + " your execution Logs!");
    }

    private Thread[] pool;

    public static void main(String[] args) {
        int firstPopulationSize = 500;
        int lastPopulationSize = 5000;
        int numberOfExecutions = 10;
        int generationsNumber = 20;
        double mutationProbability = 0.3;
        double crossoverProbability = 0.75;

        ParallelExecution execution = new ParallelExecution();
        execution.execute
                (firstPopulationSize,
                        lastPopulationSize,
                        numberOfExecutions,
                        generationsNumber,
                        mutationProbability,
                        crossoverProbability);
    }
}
