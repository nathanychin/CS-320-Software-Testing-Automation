package ProjectOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {

  private String id, name, description;
  private String longId, longName, longDescription;

  @BeforeEach
  void setUp() {
    id = "1234567890";
    name = "Testing Task";
    description = "Required description";
    longId = "123456789000000001";
    longName = "This is to test for a very, very, very long name.";
    longDescription = "Description contains more than 50 characters. This is not allowed.";
  }

  @Test
  void getTaskIdTest() {
    Task task = new Task(id);
    Assertions.assertEquals(id, task.getTaskId());
  }

  @Test
  void getNameTest() {
    Task task = new Task(id, name);
    Assertions.assertEquals(name, task.getName());
  }

  @Test
  void getDescriptionTest() {
    Task task = new Task(id, name, description);
    Assertions.assertEquals(description, task.getDescription());
  }

  @Test
  void setNameTest() {
    Task task = new Task();
    task.setName(name);
    Assertions.assertEquals(name, task.getName());
  }

  @Test
  void setDescriptionTest() {
    Task task = new Task();
    task.setDescription(description);
    Assertions.assertEquals(description, task.getDescription());
  }

  @Test
  void TaskIdTooLongTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(longId));
  }

  @Test
  void setTooLongNameTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setName(longName));
  }

  @Test
  void setTooLongDescriptionTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setDescription(longDescription));
  }

  @Test
  void TaskIdNullTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(null));
  }

  @Test
  void TaskNameNullTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setName(null));
  }

  @Test
  void TaskDescriptionNullTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setDescription(null));
  }
}