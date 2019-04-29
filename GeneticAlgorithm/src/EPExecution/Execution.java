package EPExecution;

import java.util.Scanner;

import main.controllers.Handler;
import main.utils.io.folder.FolderNamesList;

public class Execution {

   private Handler handler;

    Execution() {
    }
    
    
   public void execute(int firstPopulationSize, int lastPopulationSize, int numberOfExecutions,
		   int generationsNumber, 
		   double mutationProbability,
		   double crossoverProbability) {
	   int populationSize = firstPopulationSize;

	   this.handler = new Handler
			   (0,
               populationSize,
			   generationsNumber,
			   mutationProbability,
			   crossoverProbability);
	   
	   System.out.println("\n");
	   
	   System.out.println(1 + "� source file being created...\n");
	   this.handler.run();
	   System.out.println(1 + "� source file was createad\n");

	   int inc = (lastPopulationSize - firstPopulationSize) / (numberOfExecutions -1);

	   for(int i = 0; i < numberOfExecutions - 1; i++) {
		   populationSize = populationSize + inc;
		   
		   this.handler = new Handler
				   (i + 1,
                   populationSize,
				   generationsNumber,
				   mutationProbability,
				   crossoverProbability);
		   
		   System.out.println(i + 2 + "� source file being created...\n");
		   this.handler.run();
		   System.out.println(i + 2 + "� source file was createad\n");
	   } 
	   
	   System.out.println("It`s Over! Now you can check on: " +
       FolderNamesList.ROOT_PATH_ORIGIN + " your execution Logs!");
   }

   public static void main(String[] args) {
	 int firstPopulationSize = 100;
	 int lastPopulationSize = 1000;
	 int numberOfExecutions = 10;
	 int generationsNumber = 10;
	 double mutationProbability = 0.3;
	 double crossoverProbability = 0.75;
	 
     Execution execution = new Execution();
     execution.execute
                (firstPopulationSize,
        		 lastPopulationSize,
        		 numberOfExecutions, 
        		 generationsNumber, 
        		 mutationProbability,
        		 crossoverProbability);
   }
}
