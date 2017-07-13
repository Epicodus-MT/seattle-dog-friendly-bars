import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class BarTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void bar_instantiatesBarCorrectly_true() {
    Bar testBar = new Bar("Flatstick", 1, "240 2nd Ave S", "Seattle", "WA", 98104);
    assertTrue(testBar instanceof Bar);
  }

  @Test
  public void equals_barEqualsMethodWorks_true() {
    Location testLocation1 = new Location("Ballard");
    Bar testBar1 = new Bar("Flatstick", testLocation1.getId(), "240 2nd Ave S", "Seattle", "WA", 98104);
    Bar testBar2 = new Bar("new bar", testLocation1.getId(), "240 2nd Ave S", "Seattle", "WA", 98104);
    assertTrue(testLocation1.getBars().get(1).equals(testBar2));
  }

  @Test
  public void getId_returnsId_2() {
    Bar testBar1 = new Bar("Flatstick", 1, "240 2nd Ave S", "Seattle", "WA", 98104);
    Bar testBar2 = new Bar("Flatstick", 1, "240 2nd Ave S", "Seattle", "WA", 98104);
    assertEquals(testBar1.getId() + 1, testBar2.getId());
  }
}
