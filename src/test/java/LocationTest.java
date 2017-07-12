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
}
