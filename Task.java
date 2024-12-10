package task_tracker_cli;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
	private static int lastId = 0;  // Static variable to keep track of the last ID assigned
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // DateTimeFormatter for serializing/deserializing dates
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }
    
    public String getDesc() {
    	return description;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public String getCreatedAt() {
    	return createdAt.toString();
    }
    
    public String getUpdatedAt() {
    	return updatedAt.toString();
    }

    public void markInProgress() {
        this.status = Status.IN_PROGRESS;
        this.updatedAt = LocalDateTime.now();
    }

    public void markDone() {
        this.status = Status.DONE;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "id: " + id + ", description: " + description.strip() + ", status: " + status.toString() +
                ", createdAt: " + createdAt.format(formatter) + ", updatedAt: " + updatedAt.format(formatter);
    }
    
}
