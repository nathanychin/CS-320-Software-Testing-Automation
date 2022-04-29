package ProjectOne;

public class Task {

	  private String taskId;
	  private String name;
	  private String description;

	  Task() {
	    taskId = "Initial";
	    name = "Initial";
	    description = "Initial description";
	  }

	  Task(String taskId) {
	    checkTaskId(taskId);
	    name = "Initial";
	    description = "Initial description";
	  }

	  Task(String taskId, String name) {
	    checkTaskId(taskId);
	    setName(name);
	    description = "Initial description";
	  }

	  Task(String taskId, String name, String desc) {
	    checkTaskId(taskId);
	    setName(name);
	    setDescription(desc);
	  }

	  public final String getTaskId() { return taskId; }

	  public final String getName() { return name; }

	  protected void setName(String name) {
	    if (name == null || name.length() > 20) {
	      throw new IllegalArgumentException(
	          "Invalid task name. Task name is empty or longer than 20 characters.");
	    } else {
	      this.name = name;
	    }
	  }

	  public final String getDescription() { return description; }

	  protected void setDescription(String taskDescription) {
	    if (taskDescription == null || taskDescription.length() > 50) {
	      throw new IllegalArgumentException(
	          "Invalid task description. Task description is empty or longer than 50 characters.");
	    } else {
	      this.description = taskDescription;
	    }
	  }

	  private void checkTaskId(String taskId) {
	    if (taskId == null || taskId.length() > 10) {
	      throw new IllegalArgumentException(
	          "Invalid task ID. Task ID is empty or longer than 10 characters");
	    } else {
	      this.taskId = taskId;
	    }
	  }
	}