package dk.tec.todolistfinal;
import android.location.Location;

import java.time.LocalDateTime;
import java.util.List;

public class TodoItem {
    public enum Priority {HIGH, NORMAL, LOW}

    int id;
    String name;
    String imageBeforeFile;
    String imageAfterFile;
    String description;
    LocalDateTime plannedStartTime;
    LocalDateTime plannedEndTime;
    LocalDateTime startTime;
    LocalDateTime endTime;
    int ticksSpend;
    Tasktype tasktype;
    Priority priority;
    Location location;
    List<TodoItem> todoItemsBlockersList;
    Boolean isCompleted = false;
    Boolean isRepeatable;
    int xp;
    int comboBoostXP;
    int streakBonus;
    String area;

    // Getters and Setters for all the attributes
    // ... existing getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageBeforeFile() {
        return imageBeforeFile;
    }

    public void setImageBeforeFile(String imageBeforeFile) {
        this.imageBeforeFile = imageBeforeFile;
    }

    public String getImageAfterFile() {
        return imageAfterFile;
    }

    public void setImageAfterFile(String imageAfterFile) {
        this.imageAfterFile = imageAfterFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPlannedStartTime() {
        return plannedStartTime;
    }

    public void setPlannedStartTime(LocalDateTime plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public LocalDateTime getPlannedEndTime() {
        return plannedEndTime;
    }

    public void setPlannedEndTime(LocalDateTime plannedEndTime) {
        this.plannedEndTime = plannedEndTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getTicksSpend() {
        return ticksSpend;
    }

    public void setTicksSpend(int ticksSpend) {
        this.ticksSpend = ticksSpend;
    }

    public Tasktype getTasktype() {
        return tasktype;
    }

    public void setTasktype(Tasktype tasktype) {
        this.tasktype = tasktype;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<TodoItem> getTodoItemsBlockersList() {
        return todoItemsBlockersList;
    }

    public void setTodoItemsBlockersList(List<TodoItem> todoItemsBlockersList) {
        this.todoItemsBlockersList = todoItemsBlockersList;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public Boolean getRepeatable() {
        return isRepeatable;
    }

    public void setRepeatable(Boolean repeatable) {
        isRepeatable = repeatable;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getComboBoostXP() {
        return comboBoostXP;
    }

    public void setComboBoostXP(int comboBoostXP) {
        this.comboBoostXP = comboBoostXP;
    }

    public int getStreakBonus() {
        return streakBonus;
    }

    public void setStreakBonus(int streakBonus) {
        this.streakBonus = streakBonus;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

