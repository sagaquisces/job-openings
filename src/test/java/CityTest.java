import org.junit.*;
import static org.junit.Assert.*;

public class CityTest {

  @Test
  public void city_instantiatesCorrectly_true() {
    City testCity = new City("Pasadena");
    assertEquals(true, testCity instanceof City);
  }

  @Test
  public void getName_cityInstantiatesWithName_Pasadena() {
    City testCity = new City("Pasadena");
    assertEquals("Pasadena", testCity.getName());
  }

  @Test
  public void all_returnsAllInstancesOfCity_true() {
    City firstCity = new City("Pasadena");
    City secondCity = new City("New York");
    assertEquals(true, City.all().contains(firstCity));
    assertEquals(true, City.all().contains(secondCity));
  }

  @Test
  public void clear_emptiesAllCitiesFromList_0() {
    City testCity = new City("Pasadena");
    City.clear();
    assertEquals(City.all().size(), 0);
  }

  @Test
  public void getId_citiesInstantiateWithAnId_1() {
    City testCity = new City("Pasadena");
    assertEquals(1, testCity.getId());
  }

  @Test
  public void find_returnsCityWithSameId_secondCity() {
    City.clear();
    City firstCity = new City("Pasadena");
    City secondCity = new City("New York");
    assertEquals(City.find(secondCity.getId()), secondCity);
  }

  @Test
    public void getJobOpenings_initiallyReturnsEmptyList_ArrayList() {
    City.clear();
    City testCategory = new City("Pasadena");
    assertEquals(0, testCategory.getJobOpenings().size());
  }

  @Test
  public void addJobOpening_addsJobOpeningToList_true() {
    City testCity = new City("Pasadena");
    JobOpening testJobOpening = new JobOpening("Junior Accountant","Handles the money","Jay Walker","jay@jay.com");
    testCity.addJobOpening(testJobOpening);
    assertTrue(testCity.getJobOpenings().contains(testJobOpening));
  }
}
