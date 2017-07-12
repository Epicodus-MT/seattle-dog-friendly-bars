import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class BarTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void bar_instantiatesBarCorrectly_true() {
    Bar testBar = new Bar("Flatstick", 1, "240 2nd Ave S, Seattle, WA 98104");
    assertTrue(testBar instanceof Bar);
  }
}
