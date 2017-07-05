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
}
