
package poe_part_3;
import org.apache.commons.lang3.ArrayUtils;
import javax.swing.JOptionPane;


public class Report {
      // Arrays to store task details
    public static String[] cloneTaskNameArray;
    public static int[] cloneTaskNumberArray;
    public static String[] cloneTaskDescriptionArray;
    public static String[] cloneDeveloperDetailsArray;
    public static int[] cloneTaskDurationArray;
    public static String[] cloneTaskIDArray;
    public static String[] cloneStatusArray;
     static String TaskName ;

    // Initialize arrays with the number of tasks
    public static String[] Initialization() {
        cloneTaskNameArray = new String[Task.howManyTasks];
        cloneTaskNumberArray = new int[Task.howManyTasks];
        cloneTaskDescriptionArray = new String[Task.howManyTasks];
        cloneDeveloperDetailsArray = new String[Task.howManyTasks];
        cloneTaskDurationArray = new int[Task.howManyTasks];
        cloneTaskIDArray = new String[Task.howManyTasks];
        cloneStatusArray = new String[Task.howManyTasks];
        
        return cloneDeveloperDetailsArray = new String[Task.howManyTasks];
    }

    // Copy task data from Task class to the clone arrays
    public static void arraycopy() {
        System.arraycopy(Task.taskNameArray, 0, cloneTaskNameArray, 0, Task.howManyTasks);
        System.arraycopy(Task.taskNumberArray, 0, cloneTaskNumberArray, 0, Task.howManyTasks);
        System.arraycopy(Task.taskDescriptionArray, 0, cloneTaskDescriptionArray, 0, Task.howManyTasks);
        System.arraycopy(Task.developerDetailsArray, 0, cloneDeveloperDetailsArray, 0, Task.howManyTasks);
        System.arraycopy(Task.taskDurationArray, 0, cloneTaskDurationArray, 0, Task.howManyTasks);
        System.arraycopy(Task.taskIDArray, 0, cloneTaskIDArray, 0, Task.howManyTasks);
        System.arraycopy(Task.statusArray, 0, cloneStatusArray, 0, Task.howManyTasks);
    }

    // Print details of finished tasks
    public static String printFinishedTasks() {
         StringBuilder message = new StringBuilder();
        for (int i = 0; i < Task.howManyTasks; i++) {
            if ("Done".equals(cloneStatusArray[i])) {
               
                message.append(cloneDeveloperDetailsArray[i]).append("\n")
                       .append(cloneTaskNameArray[i]).append("\n")
                       .append(cloneTaskDurationArray[i]).append("\n");
                JOptionPane.showMessageDialog(null, message.toString());
            }
        }
        return message.toString();
    }

    // Display the developer with the highest task duration
    public static String HighestDuration() {
        int holdDuration = Integer.MIN_VALUE;
        String holdDeveloper = "";
        for (int i = 0; i < cloneTaskDurationArray.length; i++) {
            if (cloneTaskDurationArray[i] > holdDuration) {
                holdDuration = cloneTaskDurationArray[i];
                holdDeveloper = cloneDeveloperDetailsArray[i];
            }
        }
        JOptionPane.showMessageDialog(null,holdDeveloper + " , " + holdDuration);
        return   holdDeveloper + " , " + holdDuration;
    }

    // Search for a task by name
    public static String taskNameSearch() {
        String HoldString = "" ;
         StringBuilder message = new StringBuilder();
         TaskName = JOptionPane.showInputDialog("What is the task name you are looking for?");
        for (int i = 0; i < cloneTaskNameArray.length; i++) {
            if (TaskName.equals(cloneTaskNameArray[i])) {
                HoldString = cloneDeveloperDetailsArray[i]+" , "+cloneTaskNameArray[i];
                JOptionPane.showMessageDialog(null, HoldString);
            }
        }
         return HoldString;
    }

    // Display tasks assigned to a specific developer
    public static String developerTasks() {
          String HoldString = "" ;
         
        String Developer = JOptionPane.showInputDialog("What is the surname and name of the developer?");
        for (int i = 0; i < cloneDeveloperDetailsArray.length; i++) {
            if (Developer.equals(cloneDeveloperDetailsArray[i])) {
                HoldString = cloneTaskNameArray[i];
                JOptionPane.showMessageDialog(null, cloneTaskNameArray[i]);
                 
            }
        }
         return HoldString;
    }

    // Delete a task by name
    public static String taskNameDelete() {
        TaskName = JOptionPane.showInputDialog("What is the task name you are looking for?");
        for (int i = 0; i < cloneTaskNameArray.length; i++) {
            if (TaskName.equals(cloneTaskNameArray[i])) {
                cloneTaskNameArray = ArrayUtils.removeElement(cloneTaskNameArray, cloneTaskNameArray[i]);
                cloneTaskIDArray = ArrayUtils.removeElement(cloneTaskIDArray, cloneTaskIDArray[i]);
                cloneTaskDurationArray = ArrayUtils.removeElement(cloneTaskDurationArray, cloneTaskDurationArray[i]);
                cloneStatusArray = ArrayUtils.removeElement(cloneStatusArray, cloneStatusArray[i]);
                
                 JOptionPane.showMessageDialog(null,"Entry"+TaskName+"successfully deleted");
            }
            
        }
        return "Entry "+TaskName+" successfully deleted";
    }

    // Display a report of all tasks
    public static String taskReport() {
          StringBuilder message = new StringBuilder();
        for (int i = 0; i < cloneTaskNameArray.length; i++) {
          
            message.append(cloneTaskNameArray[i]).append("\n")
                   .append(cloneTaskIDArray[i]).append("\n")
                   .append(cloneTaskDurationArray[i]).append("\n")
                   .append(cloneStatusArray[i]).append("\n");
            JOptionPane.showMessageDialog(null, message.toString());
        }
         return message.toString();
    }
   
}
