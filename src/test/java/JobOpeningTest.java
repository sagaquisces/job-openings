import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class JobOpeningTest {

  @Test
  public void JobOpening_instantiatesCorrectly_true() {
    JobOpening myJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    assertEquals(true, myJobOpening instanceof JobOpening);
  }

  @Test
  public void JobOpening_instantiatesWithTitle_String() {
    JobOpening myJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    assertEquals("Junior Accountant", myJobOpening.getTitle());
  }

  @Test
  public void JobOpening_instantiatesWithDescription_String() {
    JobOpening myJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    assertEquals("Handles the money", myJobOpening.getDescription());
  }

  @Test
  public void JobOpening_instantiatesWithName_String() {
    JobOpening myJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    assertEquals("Jay Walker", myJobOpening.getName());
  }

  @Test
  public void JobOpening_instantiatesWithEmail_String() {
    JobOpening myJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    assertEquals("jay@jay.com", myJobOpening.getEmail());
  }

  @Test
  public void isFilled_isFalseAfterInstantiation_false() {
    JobOpening myJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    assertEquals(false, myJobOpening.isFilled());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    JobOpening myJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    assertEquals(LocalDateTime.now().getDayOfWeek(),
    myJobOpening.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfJobOpening_true() {
    JobOpening firstJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    JobOpening secondJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    assertEquals(true, JobOpening.all().contains(firstJobOpening));
    assertEquals(true, JobOpening.all().contains(secondJobOpening));
  }

  @Test
  public void clear_emptiesAllJobOpeningsFromArrayList_0() {
    JobOpening myJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    JobOpening.clear();
    assertEquals(0, JobOpening.all().size());
  }

  @Test
  public void getId_jobOpeningsInstantiateWithAnID_1() {
    JobOpening.clear();
    JobOpening myJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    assertEquals(1, myJobOpening.getId());
  }

  @Test
  public void find_returnsJobOpeningWithSameId_secondTask() {
    JobOpening firstJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    JobOpening secondJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    assertEquals(JobOpening.find(secondJobOpening.getId()), secondJobOpening);
  }
}
