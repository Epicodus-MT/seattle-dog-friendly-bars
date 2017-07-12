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
    Bar testBar1 = new Bar("Flatstick", testLocation.getId(), "240 2nd Ave S, Seattle, WA 98104");
    Bar testBar2 = new Bar("Dutchess", testLocation.getId(), "240 2nd Ave S, Seattle, WA 98104");
    Bar[] bars = new Bar[] { testBar1, testBar2 };
    assertTrue(testLocation.getBars().containsAll(Arrays.asList(bars)));
  }
}
