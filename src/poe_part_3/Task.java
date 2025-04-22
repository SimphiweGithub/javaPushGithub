
package poe_part_3;

import javax.swing.JOptionPane;

public class Task {
       
    public static int numberOfTasks = -1; // Keeps track of the total number of tasks//minus one so that it starts at 0
    public static  int howManyTasks; // Keeps track of the number of tasks requested by the user
    public static String[] taskNameArray; // Array to store task names
    public static int[] taskNumberArray; // Array to store task numbers
    public static String[] taskDescriptionArray; // Array to store task descriptions
    public static String[] developerDetailsArray; // Array to store developer details
    public static int[] taskDurationArray; // Array to store task durations
    public static String[] taskIDArray; // Array to store task IDs
    public static String[] statusArray; // Array to store task statuses
    public static boolean decision ;//:( why this method wanna run twice)(: fixed now lets go)
    public static String taskDescriptionStore;
    // by the way this decision boolean comes from the first part of the poe which is my main class here 
    // Main method
    public static void main(String[] args) {
        
       initializeArrays(); // Initializes arrays
         if(decision){String Message = "Welcome to EasyKanban";
            JOptionPane.showMessageDialog(null, Message);}
        loginRequired(); // Starts the login process
        
  }

    // Handles user login
    public static void loginRequired() {

         while (decision) {
            
            int userChoice = Integer.parseInt(JOptionPane.showInputDialog("Option 1) Add Tasks\nOption 2) Show report \nOption 3) Quit"));
            switch (userChoice) {
                case 1:
                    howManyTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks do you want?"));
                    initializeArrays(); // Reinitializes arrays based on the new number of tasks requested
                    addTask(); // Adds tasks based on user input
                    printTaskDetails(); // Prints task details
                    returnTotalHours(); // Calculates and displays total task duration
                    break;
                case 2:
                    //JOptionPane.showMessageDialog(null, "This feature is in development and is coming soon");
                    Report.Initialization();
                    Report.arraycopy();
                    Report.printFinishedTasks();
                    Report.HighestDuration();
                    Report.taskNameSearch();
                    Report.developerTasks();
                    Report.taskNameDelete();
                    Report.taskReport();
                   
                    break;
                case 3:
                    System.exit(0); // Exits the program
                default:
                    JOptionPane.showMessageDialog(null, "Choose a valid number between one and three");
                    break;
            }
        }
    }

    // Initializes arrays based on the number of tasks requested(Instantialized by howManyTasks)
    public static void initializeArrays() {
        taskNameArray = new String[howManyTasks];
        taskNumberArray = new int[howManyTasks];
        taskDescriptionArray = new String[howManyTasks];
        developerDetailsArray = new String[howManyTasks];
        taskDurationArray = new int[howManyTasks];
        taskIDArray = new String[howManyTasks];
        statusArray = new String[howManyTasks];
    }

    // Adds tasks based on user input
    public static void addTask() {
        for (int i = 0; i < howManyTasks; i++) {
            taskNameArray[i] = taskName(); // Prompts the user to enter the task name
            developerDetailsArray[i] = developerDetails(); // Prompts the user to enter the developer details
            taskDurationArray[i] = taskDuration(); // Prompts the user to enter the task duration
            taskDescriptionArray[i] = takeTaskDescription(); // Prompts the user to enter the task description
            statusArray[i] = status(); // Prompts the user to select the task status
            taskNumberArray[i] = ++numberOfTasks; // Increments the task number
            taskIDArray[i] = createTaskID(taskNameArray[i], developerDetailsArray[i]); // Generates a unique task ID
        }
    }

    // Prompts the user to enter the task name
    public static String taskName() {
        return JOptionPane.showInputDialog(null, "What is the purpose of this task?");
    }

    // Prompts the user to enter the task description
    public static String takeTaskDescription() {
        taskDescriptionStore = JOptionPane.showInputDialog("Please enter a short description of the task that is less than 50 characters");
        while (!checkTaskDescription(taskDescriptionStore)) {//while loop to force correct input
            JOptionPane.showMessageDialog(null, "Please enter a task description that is less than 50 characters long");
            taskDescriptionStore = JOptionPane.showInputDialog("Please enter a short description of the task that is less than 50 characters");
        }//will only return if successful
        JOptionPane.showMessageDialog(null, "Task successfully captured");
        return taskDescriptionStore;
    }

    // Checks if the task description is valid
    public static boolean checkTaskDescription(String taskDescriptionStore) {
        return taskDescriptionStore.length() <= 50;
    }

    // Prompts the user to enter the developer details
    public static String developerDetails() {
        String enterDevLastName = JOptionPane.showInputDialog("Please enter developer Last Name");
        String enterDevName = JOptionPane.showInputDialog("Please enter the developer Name");
        return enterDevLastName + " " + enterDevName;
    }

    // Prompts the user to enter the task duration
    public static int taskDuration() {
       int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("What is the duration of the Task in hours")); 
        while(taskDuration<=0){
            JOptionPane.showMessageDialog(null, "Please don't enter a negative value for the duration");
        taskDuration = Integer.parseInt(JOptionPane.showInputDialog("What is the duration of the Task in hours"));
        }
        return taskDuration;
    }

    // Creates a unique task ID based on task name and developer details
    public static String createTaskID(String nameOfTask, String devDetails) {
        String substringNameOfTask = nameOfTask.substring(0, 2);
        String substringDevDetails = devDetails.substring(devDetails.length() - 3);
        String taskkID = substringNameOfTask + ":" + numberOfTasks + ":" + substringDevDetails;
        return taskkID.toUpperCase();
    }

    // Prompts the user to select the task status
    public static String status() {
        
        return JOptionPane.showInputDialog("Please select from the list below\nTo Do\nDoing\nDone");
    }

    // Prints and returns task details
    public static String printTaskDetails() {
        StringBuilder taskDetailsPrintt = new StringBuilder();
        for (int i = 0; i < howManyTasks; i++) {
            taskDetailsPrintt.append("The Task ID is: ").append(taskIDArray[i]).append("\n") 
                             .append("The Task Number is: ").append(taskNumberArray[i]).append("\n")
                             .append("The Task Status is:  ").append(statusArray[i]).append("\n")
                             .append("The Task Descripion is: ").append(taskDescriptionArray[i]).append("\n")
                             .append("The Task Name is: ").append(taskNameArray[i]).append("\n")
                             .append("The Developer Details are: ").append(developerDetailsArray[i]).append("\n")
                             .append("The Task duration is:  ").append(taskDurationArray[i]).append(" hours").append("\n\n");
        }
        JOptionPane.showMessageDialog(null, taskDetailsPrintt.toString());
        
        return taskDetailsPrintt.toString();
    }

   // Calculate and then returns total task duration
    public static int returnTotalHours() {
        int totalHours = 0;
        //JOptionPane.showMessageDialog(null, "Total tasks: " +howManyTasks);
        for (int i = 0; i < howManyTasks; i++) {
            totalHours =totalHours + taskDurationArray[i];
        }
        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
        return totalHours;
}

}
