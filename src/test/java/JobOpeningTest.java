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
}
