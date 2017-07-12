import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Bar {
  private String name;
  private String address;
  // private float rating;
  private List<String> comments;
  private int locationId;
  private int id;

  public Bar(String name, int locationId, String address) {
    this.name = name;
    this.locationId = locationId;
    this.address = address;
  }
}
