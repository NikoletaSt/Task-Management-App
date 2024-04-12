import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(10);

        while (true) { //while loop for re-appearing of the menu every time the user finishes using a certain feature 
            System.out.println("Your Task Management App:");
            System.out.println("1. Add New Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Delete Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Generate Report for Tasks Due Today");
            System.out.println("6. View Tasks With Missed Due Dates");
            System.out.println("7. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Number ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Description of the Task: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Due Date (yyyy-MM-dd): ");
                    String dueDateStr = scanner.nextLine();
                    System.out.print("Enter Number Priority: ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date dueDate = dateFormat.parse(dueDateStr);
                        Task newTask = new Task(taskId, description, dueDate);
                        taskManager.addTask(newTask);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Task was not added."); //try-catch for input validation and user-friendly program; in case of a wrongly input date, user will be notified
                    }
                    break;
                case 2:
                    System.out.print("Enter Task ID to mark as done: ");
                    int taskIdToComplete = scanner.nextInt();
                    taskManager.markTaskCompleted(taskIdToComplete);
                    break;
                case 3:
                    System.out.print("Enter Task ID to delete: ");
                    int taskIdToDelete = scanner.nextInt();
                    taskManager.deleteTask(taskIdToDelete);
                    break;
                case 4:
                    taskManager.viewAllTasks();
                    break;
                case 5:
                    taskManager.generateReportForTasksDueToday();
                    break;
                case 6:
                    taskManager.generateReportForTasksWithMissedDueDates();
                    break;
                case 7:
                    System.out.println("Exiting the App");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid. Please enter a number 1 - 7."); //default case if the user does not enter a valid menu number 
            }
        }
    }
}
