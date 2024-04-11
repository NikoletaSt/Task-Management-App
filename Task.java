import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private int taskId;
    private String description;
    private Date dueDate;
    private boolean completed;
    private int priority;

    public Task(int taskId, String description, Date dueDate) {
        this.taskId = taskId;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
        this.priority = priority;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String formattedDueDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dueDate);
    }
}
