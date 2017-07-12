import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Location {
  private int id;
  private String name;

  public Location(String name) {
    this.name = name;
    this.save();
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  private void save() {
    String sql = "INSERT INTO locations (name) VALUES (:name);";
    try(Connection con = DB.sql2o.open()) {
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
    }
  }

  public List<Bar> getBars() {
    String sql = "SELECT * FROM bars WHERE locationId=:id;";
    try(Connection con = DB.sql2o.open()) {
      //ADD TRY/CATCH TO RETURN NULL IF NONE
      return con.createQuery(sql)
      .addParameter("id", this.id)
      .executeAndFetch(Bar.class);
    }
  }

  public static Location find(int id) {
    String sql = "SELECT * FROM locations WHERE id=:id;";
    try(Connection con = DB.sql2o.open()) {
      Location location = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Location.class);
      return location;
    }
  }

  public static List<Location> all() {
    String sql = "SELECT id, name FROM locations;";
    try(Connection con = DB.sql2o.open()) {
      //ADD TRY/CATCH TO RETURN NULL IF NONE
      return con.createQuery(sql).executeAndFetch(Location.class);
    }
  }

  @Override
  public boolean equals(Object location) {
    if(!(location instanceof Location)) {
      return false;
    } else {
      Location newLocation = (Location) location;
      return this.getName().equals(newLocation.getName()) && this.getId() == newLocation.getId();
    }
  }
}
