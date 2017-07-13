import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Bar {
  private String name;
  private String street;
  private String city;
  private String state;
  private int zip;
  private int locationId;
  private int id;

  public Bar(String name, int locationId, String street, String city, String state, int zip) {
    this.name = name;
    this.locationId = locationId;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.save();
  }

  private void save() {
    String sql = "INSERT INTO bars (name, locationId, street, city, state, zip) VALUES (:name, :locationId, :street, :city, :state, :zip);";
    try(Connection con = DB.sql2o.open()) {
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("locationId", this.locationId)
      .addParameter("street", this.street)
      .addParameter("city", this.city)
      .addParameter("state", this.state)
      .addParameter("zip", this.zip)
      .executeUpdate()
      .getKey();
    }
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public static Bar find(int id) {
    String sql = "SELECT * FROM bars WHERE id=:id;";
    try(Connection con = DB.sql2o.open()) {
      Bar bar = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Bar.class);
      return bar;
    }
  }


  @Override
  public boolean equals(Object bar) {
    if(!(bar instanceof Bar)) {
      return false;
    } else {
      Bar newBar = (Bar) bar;
      return this.getName().equals(newBar.getName());
    }
  }
}
