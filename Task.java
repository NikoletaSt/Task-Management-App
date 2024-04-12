import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private int taskId; //encapsulation of the varables
    private String description;
    private Date dueDate;
    private int priority;
    private boolean completed;

    public Task(int taskId, String description, Date dueDate) {
        this.taskId = taskId;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
        this.priority = priority;
    }

    //getter methods for the variables 
    public Date getDueDate() {
        return dueDate;
    }
    
    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String formattedDueDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dueDate); //fomatting the date
    }
}
