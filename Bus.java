import java.util.Random;
import java.util.Scanner;


public class Bus{
    
    private static final Random random = new Random(); // This will assign a random city location to each individual  
    private static final String[] individualStopsList = {"Stop 1", "Stop 2", "Stop 3", "Stop 4", "Stop 5"};// this will be the name of each location already

    public static void main(String[] args){
      int peopleCount = 60; // the number of people to be assigned to a city location already fixed
      Scanner scanner = new Scanner(System.in);  
      Queue busQueue = new Queue(peopleCount); // Queue array for individual 
      Stack stopStack = new Stack( individualStopsList.length); // Stack arrayy for stops  
          
        //for (int i = 0; i < peopleCount.size; i++){
         System.out.println("Enter the number of individuals to be assigned to stops:");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number:");
            scanner.next(); // Clear the invalid input
        }
        peopleCount = scanner.nextInt();// Read the number of individuals from user input

        if (peopleCount > 60) { // Validate the maximum number of individuals
            System.out.println("The maximum number of individuals is 60. Please enter a valid number.");
            scanner.close();
            return;
        }
          System.out.println("\nYou entered: " + peopleCount);
          System.out.println(peopleCount + " Assigned Stop:\n");
          
          // Assign stops to individuals and add them to the queue
        for (int i = 0; i < peopleCount; i++) {
            String randomStop = individualStopsList[random.nextInt(individualStopsList.length)];
            String individual = "Individual " + (i + 1) + " (" + randomStop + ")";
            System.out.println(individual + " is assigned to " + randomStop);
            busQueue.enqueue(individual); // Add individuals to the queue
        }
        for(String stop : individualStopsList) { // push stops into stack  
          stopStack.push(stop); 
        }
        System.out.println("\nBording Time!\n");
        
        //Copy individuals from the bus queue to the stop process queue
        Queue stopProcessQueue = new Queue(peopleCount); // Queue arrayy for stops
        while (!busQueue.isEmpty()) { // Dequeue individuals from the bus queue
            // Check if the bus queue is empty
            // If the bus queue is empty, break the loop
            String individual = busQueue.dequeue(); // Get the next individual from the queue
            System.out.println(individual + " is boarding the bus.");
            stopProcessQueue.enqueue(individual); // Add individuals to the stop process queue
        }
        System.out.println("\nThe bus is ready. The bus will now leave the station.\n");
        

        while (!stopStack.isEmpty()) {
            String stopToProcess = stopStack.pop(); // Get the next stop from the stack
            System.out.println("The bus has reached " + stopToProcess + ". Individuals getting off:");

            // Check the queue for individuals assigned to the current stop
            Queue tempQueue = new Queue(peopleCount); // Temporary queue for individuals not getting off
            while (!stopProcessQueue.isEmpty()) { // Dequeue individuals from the stop process queue
                
                // Check if the individual is getting off at the current stop
                // If the individual is getting off, print a message and do not enqueue them back
                String individual = stopProcessQueue.dequeue(); // Get the next individual from the queue
                if (individual.contains(stopToProcess)) { //  
                    System.out.println(individual + " has gotten off the bus.");
                } else {
                    tempQueue.enqueue(individual); // Add back individuals not getting off
                }
            }

            // Restore the remaining individuals back to the main queue
            while (!tempQueue.isEmpty()) {
                stopProcessQueue.enqueue(tempQueue.dequeue());
            }

            System.out.println("The bus has left " + stopToProcess + " and is on its way to the next stop.\n");
        }

        System.out.println("All stops have been processed. The bus has completed its journey.");
        scanner.close(); // Close the scanner to avoid resource leaks
    }
}