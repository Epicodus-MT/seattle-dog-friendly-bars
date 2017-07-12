import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class LocationTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void location_instantiatesCorrectly_true() {
    Location testLocation = new Location("Ballard");
    assertEquals(true, testLocation instanceof Location);
  }

  @Test
  public void getName_returnsLocationName_Ballard() {
    Location testLocation = new Location("Ballard");
    assertEquals("Ballard", testLocation.getName());
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Location testLocation = new Location("Ballard");
    assertTrue(Location.all().get(0).equals(testLocation));
  }

  @Test
  public void all_returnsAllLocations_true() {
    Location testLocation1 = new Location("Ballard");
    Location testLocation2 = new Location("Capital Hill");
    assertTrue(Location.all().get(0).equals(testLocation1));
    assertTrue(Location.all().get(1).equals(testLocation2));
  }

  @Test
  public void equals_returnsTrueIfLocationsEqual_true() {
    Location testLocation1 = new Location("Ballard");
    Location testLocation2 = new Location("Ballard");
    assertTrue(Location.all().get(1).equals(testLocation2));
  }

  @Test
  public void getId_returnsId_true() {
    Location testLocation = new Location("Ballard");
    assertTrue(testLocation.getId() > 0);
  }

  @Test
  public void find_returnsSpecificLocation_true() {
    Location testLocation1 = new Location("Ballard");
    Location testLocation2 = new Location("Capital Hill");
    assertEquals(testLocation2, Location.find(testLocation2.getId()));
  }

  @Test
  public void getBars_retrieveAllBarsFromDatabase_barList() {
    Location testLocation = new Location("Ballard");
    Bar testBar1 = new Bar("Flatstick", testLocation.getId(), "240 2nd Ave S", "Seattle", "WA", 98104);
    Bar testBar2 = new Bar("Another Bar", testLocation.getId(), "240 2nd Ave S", "Seattle", "WA", 98104);
    Bar[] bars = new Bar[] { testBar1, testBar2 };
    System.out.println("bars array: " + bars[0].getName());
    System.out.println("bars array: " + bars[1].getName());
    System.out.println("location get bars method: " + testLocation.getBars().get(0).getName());
    // assertEquals(Arrays.asList(bars), testLocation.getBars());
    assertTrue(testLocation.getBars().get(0).equals(testBar1));
    assertTrue(testLocation.getBars().get(1).equals(testBar2));
  }
}
