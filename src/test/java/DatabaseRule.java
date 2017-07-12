import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {
  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/dog_bar_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open();) {
      String deleteLocationsQuery = "DELETE FROM locations *;";
      String deleteBarsQuery = "DELETE FROM bars *;";
      con.createQuery(deleteLocationsQuery).executeUpdate();
      con.createQuery(deleteBarsQuery).executeUpdate();
    }
  }
}
