package ProjectOne;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

  private String id, name, description;
  private String longName, longDescription;

  @BeforeEach
  void testInfo() {
    id = "1234567890";
    name = "Testing Task";
    description = "Required description.";
    longName = "This is to test for a very, very, very long name.";
    longDescription = "Description contains more than 50 characters. This is not allowed.";
  }

  @Test
  void newTaskTest() {
    TaskService service = new TaskService();
    service.newTask();
    Assertions.assertNotNull(service.getTaskList().get(0).getTaskId());
    Assertions.assertNotEquals("Initial",
                               service.getTaskList().get(0).getTaskId());
  }

  @Test
  void newTaskNameTest() {
    TaskService service = new TaskService();
    service.newTask(name);
    Assertions.assertNotNull(service.getTaskList().get(0).getName());
    Assertions.assertEquals(name, service.getTaskList().get(0).getName());
  }

  @Test
  void newTaskDescriptionTest() {
    TaskService service = new TaskService();
    service.newTask(name, description);
    Assertions.assertNotNull(service.getTaskList().get(0).getDescription());
    Assertions.assertEquals(description,
                            service.getTaskList().get(0).getDescription());
  }

  @Test
  void newTaskTooLongNameTest() {
    TaskService service = new TaskService();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> service.newTask(longName));
  }

  @Test
  void newTaskTooLongDescriptionTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class,
                 () -> service.newTask(name, longDescription));
  }

  @Test
  void newTaskNameNullTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
  }

  @Test
  void newTaskDescriptionNullTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class,
                 () -> service.newTask(name, null));
  }

  @Test
  void deleteTaskTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertEquals(1, service.getTaskList().size());
    service.deleteTask(service.getTaskList().get(0).getTaskId());
    assertEquals(0, service.getTaskList().size());
  }

  @Test
  void deleteTaskNotFoundTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertEquals(1, service.getTaskList().size());
    assertThrows(Exception.class, () -> service.deleteTask(id));
    assertEquals(1, service.getTaskList().size());
  }

  @Test
  void updateNameTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    service.updateName(service.getTaskList().get(0).getTaskId(), name);
    assertEquals(name, service.getTaskList().get(0).getName());
  }

  @Test
  void updateDescriptionTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    service.updateDescription(service.getTaskList().get(0).getTaskId(),
                              description);
    assertEquals(description, service.getTaskList().get(0).getDescription());
  }

  @Test
  void updateNameNotFoundTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertThrows(Exception.class, () -> service.updateName(id, name));
  }

  @Test
  void updateDescriptionNotFoundTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertThrows(Exception.class,
                 () -> service.updateDescription(id, description));
  }

  @RepeatedTest(4)
  void UuidTest() {
    TaskService service = new TaskService();
    service.newTask();
    service.newTask();
    service.newTask();
    assertEquals(3, service.getTaskList().size());
    assertNotEquals(service.getTaskList().get(0).getTaskId(),
                    service.getTaskList().get(1).getTaskId());
    assertNotEquals(service.getTaskList().get(0).getTaskId(),
                    service.getTaskList().get(2).getTaskId());
    assertNotEquals(service.getTaskList().get(1).getTaskId(),
                    service.getTaskList().get(2).getTaskId());
  }
}