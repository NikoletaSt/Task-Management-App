import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskManager {
        private Task[] tasks;
        private int taskCount;

        // Constructor
        public TaskManager(int capacity) {
            tasks = new Task[capacity];
            taskCount = 0;
        }

        // Method to add a task
        public void addTask(Task task) {
            if (taskCount < tasks.length) {
                tasks[taskCount++] = task;
                System.out.println("Task added successfully.");
            } else {
                System.out.println("Task manager is full. Cannot add more tasks.");
            }
        }

    public void deleteTask(int taskId) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i] != null && tasks[i].getTaskId() == taskId) {
                tasks[i] = null;
                // Move tasks to fill the gap
                for (int j = i; j < taskCount - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                taskCount--;
                System.out.println("Task deleted successfully.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // Method to mark a task as completed
        public void markTaskCompleted(int taskId) {
            for (Task task : tasks) {
                if (task != null && task.getTaskId() == taskId) {
                    task.setCompleted(true);
                    System.out.println("Task marked as completed.");
                    return;
                }
            }
            System.out.println("Task not found.");
        }

        // Method to view all tasks
        public void viewAllTasks() {
            if (taskCount == 0) {
                System.out.println("No tasks to display.");
            } else {
                System.out.println("All Tasks:");
                for (Task task : tasks) {
                    if (task != null) {
                        System.out.println("Task ID: " + task.getTaskId());
                        System.out.println("Description: " + task.getDescription());
                        System.out.println("Due Date: " + task.formattedDueDate());
                        System.out.println("Priority: " + task.getPriority());
                        System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
                        System.out.println();
                    }
                }
            }
        }

        // Method to generate reports for tasks due today
        public void generateReportForTasksDueToday() {
            Date today = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String todayStr = dateFormat.format(today);
            System.out.println("Tasks Due Today (" + todayStr + "):");
            boolean found = false;
            for (Task task : tasks) {
                if (task != null && task.getDueDate().equals(today)) {
                    System.out.println("Task ID: " + task.getTaskId());
                    System.out.println("Description: " + task.getDescription());
                    System.out.println("Due Date: " + task.formattedDueDate());
                    System.out.println("Priority: " + task.getPriority());
                    System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
                    System.out.println();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No tasks due today.");
            }
        }

    public void generateReportForTasksWithMissedDueDates() {
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Tasks With Missed Due Dates:");
        boolean found = false;
        for (Task task : tasks) {
            if (task != null && task.getDueDate().before(today) && !task.isCompleted()) {
                System.out.println("Task ID: " + task.getTaskId());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Due Date: " + task.formattedDueDate());
                System.out.println("Priority: " + task.getPriority());
                System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks with missed due dates.");
        }
    }
}
