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
    testLocation.save();
    assertTrue(Location.all().get(0).equals(testLocation));
  }

  @Test
  public void all_returnsAllLocations_true() {
    Location testLocation1 = new Location("Ballard");
    testLocation1.save();
    Location testLocation2 = new Location("Capital Hill");
    testLocation2.save();
    assertTrue(Location.all().get(0).equals(testLocation1));
    assertTrue(Location.all().get(1).equals(testLocation2));
  }

  @Test
  public void equals_returnsTrueIfLocationsEqual_true() {
    Location testLocation1 = new Location("Ballard");
    Location testLocation2 = new Location("Ballard");
    assertTrue(testLocation1.equals(testLocation2));
  }

  @Test
  public void getId_returnsId_true() {
    Location testLocation = new Location("Ballard");
    testLocation.save();
    assertTrue(testLocation.getId() > 0);
  }
}
