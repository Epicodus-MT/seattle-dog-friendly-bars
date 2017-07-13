import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Comment {
  private String comment;
  private Integer rating;
  private int id;
  private int barId;
  private String name;

  public Comment(String comment, Integer rating, int barId, String name) {
    this.comment = comment;
    this.rating = rating;
    this.barId = barId;
    this.name = name;
  }


}
