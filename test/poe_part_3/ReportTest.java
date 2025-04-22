
package poe_part_3;


import org.junit.Test;
import static org.junit.Assert.*;
import static poe_part_3.Report.TaskName;


public class ReportTest {
    
  
    
   

   
    @Test
    public void testArrayInitialization() {
        Task.numberOfTasks = 4;
        Report.cloneDeveloperDetailsArray = new String[4];
        Report.cloneDeveloperDetailsArray[0] = "Mike Smith";
        Report.cloneDeveloperDetailsArray[1] = "Edward Harrison";
        Report.cloneDeveloperDetailsArray[2] = "Samantha Paulson";
        Report.cloneDeveloperDetailsArray[3] = "Glenda Oberholzer"; 
        System.out.println("arrayInitialization");
       
      assertArrayEquals(
            new String[] { "Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer" },
            Report.cloneDeveloperDetailsArray
        );
        }

  

  
    @Test
    public void testHighestDuration() {
        Task.numberOfTasks = 4;
        Report.cloneTaskDurationArray = new int[4];
        Report.cloneTaskDurationArray[0] = 5;
        Report.cloneTaskDurationArray[1] = 8;
        Report.cloneTaskDurationArray[2] = 2;
        Report.cloneTaskDurationArray[3] = 11;
        
        Report.cloneStatusArray = new String[4];
        Report.cloneStatusArray[0] = "To Do";
        Report.cloneStatusArray[1] = "Doing";
        Report.cloneStatusArray[2] = "Done";
        Report.cloneStatusArray[3] = "To Do";
        
        Report.cloneDeveloperDetailsArray = new String[4];
        Report.cloneDeveloperDetailsArray[0] = "Mike Smith";
        Report.cloneDeveloperDetailsArray[1] = "Edward Harrison";
        Report.cloneDeveloperDetailsArray[2] = "Samantha Paulson";
        Report.cloneDeveloperDetailsArray[3] = "Glenda Oberholzer"; 
        
        Report.cloneTaskNameArray = new String[4];
        Report.cloneTaskNameArray[0] = "Create Login";
        Report.cloneTaskNameArray[1] = "Create add features";
        Report.cloneTaskNameArray[2] = "Create Reports";
        Report.cloneTaskNameArray[3] = "Add Arrays";
        
        
        
        System.out.println("HighestDuration");
        String result = Report.HighestDuration();
        String expresult = "Glenda Oberholzer , 11";
        
       assertEquals(expresult, result);
    }

   
    @Test
    public void testTaskNameSearch() {
        
        
        Report.TaskName = "Create Login";
        Task.numberOfTasks = 4;
          
        Report.cloneDeveloperDetailsArray = new String[4];
        Report.cloneDeveloperDetailsArray[0] = "Mike Smith";
        Report.cloneDeveloperDetailsArray[1] = "Edward Harrison";
        Report.cloneDeveloperDetailsArray[2] = "Samantha Paulson";
        Report.cloneDeveloperDetailsArray[3] = "Glenda Oberholzer"; 
        
        Report.cloneTaskNameArray = new String[4];
        Report.cloneTaskNameArray[0] = "Create Login";
        Report.cloneTaskNameArray[1] = "Create add features";
        Report.cloneTaskNameArray[2] = "Create Reports";
        Report.cloneTaskNameArray[3] = "Add Arrays";
        
        
        System.out.println("taskNameSearch");
        String result = Report.taskNameSearch();
        String expresult = "Mike Smith , Create Login";
        
       assertEquals(expresult, result);
    }

    
    @Test
    public void testDeveloperTasks() {
        
         Task.numberOfTasks = 4;
        Report.cloneTaskDurationArray = new int[4];
        Report.cloneTaskDurationArray[0] = 5;
        Report.cloneTaskDurationArray[1] = 8;
        Report.cloneTaskDurationArray[2] = 2;
        Report.cloneTaskDurationArray[3] = 11;
        
        Report.cloneStatusArray = new String[4];
        Report.cloneStatusArray[0] = "To Do";
        Report.cloneStatusArray[1] = "Doing";
        Report.cloneStatusArray[2] = "Done";
        Report.cloneStatusArray[3] = "To Do";
        
        Report.cloneDeveloperDetailsArray = new String[4];
        Report.cloneDeveloperDetailsArray[0] = "Mike Smith";
        Report.cloneDeveloperDetailsArray[1] = "Edward Harrison";
        Report.cloneDeveloperDetailsArray[2] = "Samantha Paulson";
        Report.cloneDeveloperDetailsArray[3] = "Glenda Oberholzer"; 
        
        Report.cloneTaskNameArray = new String[4];
        Report.cloneTaskNameArray[0] = "Create Login";
        Report.cloneTaskNameArray[1] = "Create add features";
        Report.cloneTaskNameArray[2] = "Create Reports";
        Report.cloneTaskNameArray[3] = "Add Arrays";
        
        
        
        System.out.println("developerTasks");
        String result = Report.developerTasks();
        String expresult = "Create Reports";
        
       assertEquals(expresult, result);
        
    }

    
    @Test
    public void testTaskNameDelete() {
        Report.TaskName = "Create Login";
         Task.numberOfTasks = 4;
        Report.cloneTaskDurationArray = new int[4];
        Report.cloneTaskDurationArray[0] = 5;
        Report.cloneTaskDurationArray[1] = 8;
        Report.cloneTaskDurationArray[2] = 2;
        Report.cloneTaskDurationArray[3] = 11;
        
        Report.cloneStatusArray = new String[4];
        Report.cloneStatusArray[0] = "To Do";
        Report.cloneStatusArray[1] = "Doing";
        Report.cloneStatusArray[2] = "Done";
        Report.cloneStatusArray[3] = "To Do";
        
        Report.cloneDeveloperDetailsArray = new String[4];
        Report.cloneDeveloperDetailsArray[0] = "Mike Smith";
        Report.cloneDeveloperDetailsArray[1] = "Edward Harrison";
        Report.cloneDeveloperDetailsArray[2] = "Samantha Paulson";
        Report.cloneDeveloperDetailsArray[3] = "Glenda Oberholzer"; 
        
        Report.cloneTaskNameArray = new String[4];
        Report.cloneTaskNameArray[0] = "Create Login";
        Report.cloneTaskNameArray[1] = "Create add features";
        Report.cloneTaskNameArray[2] = "Create Reports";
        Report.cloneTaskNameArray[3] = "Add Arrays";
        
        Report.cloneTaskIDArray = new String[4];
        Report.cloneTaskIDArray[0] = "" ;
        Report.cloneTaskIDArray[1] = "" ;
        Report.cloneTaskIDArray[2] = "" ;
        Report.cloneTaskIDArray[3] = "" ;
        
        
        System.out.println("taskNameDelete");
        String result = Report.taskNameDelete();
        String expresult = "Entry"+TaskName+"successfully deleted";
        
       assertEquals(expresult, result);
    }

    
    @Test
    public void testTaskReport() {
         Task.numberOfTasks = 4;
         
         Report.cloneTaskIDArray = new String[4];
        Report.cloneTaskIDArray[0] = "" ;
        Report.cloneTaskIDArray[1] = "" ;
        Report.cloneTaskIDArray[2] = "" ;
        Report.cloneTaskIDArray[3] = "" ;
        
        Report.cloneTaskDurationArray = new int[4];
        Report.cloneTaskDurationArray[0] = 5;
        Report.cloneTaskDurationArray[1] = 8;
        Report.cloneTaskDurationArray[2] = 2;
        Report.cloneTaskDurationArray[3] = 11;
        
        Report.cloneStatusArray = new String[4];
        Report.cloneStatusArray[0] = "To Do";
        Report.cloneStatusArray[1] = "Doing";
        Report.cloneStatusArray[2] = "Done";
        Report.cloneStatusArray[3] = "To Do";
        
        Report.cloneDeveloperDetailsArray = new String[4];
        Report.cloneDeveloperDetailsArray[0] = "Mike Smith";
        Report.cloneDeveloperDetailsArray[1] = "Edward Harrison";
        Report.cloneDeveloperDetailsArray[2] = "Samantha Paulson";
        Report.cloneDeveloperDetailsArray[3] = "Glenda Oberholzer"; 
        
        Report.cloneTaskNameArray = new String[4];
        Report.cloneTaskNameArray[0] = "Create Login";
        Report.cloneTaskNameArray[1] = "Create add features";
        Report.cloneTaskNameArray[2] = "Create Reports";
        Report.cloneTaskNameArray[3] = "Add Arrays";
        
        System.out.println("taskReport");
        Report.taskReport();
        StringBuilder message = new StringBuilder();
        
        message.append(Report.cloneTaskNameArray[0]).append("\n")
                   .append(Report.cloneTaskIDArray[0]).append("\n")
                   .append(Report.cloneTaskDurationArray[0]).append("\n")
                   .append(Report.cloneStatusArray[0]).append("\n");
     
        String man = message.toString();
         assertEquals(man, Report.taskReport() );
        
        
    }
    
}
