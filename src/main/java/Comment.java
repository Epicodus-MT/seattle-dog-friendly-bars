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
    this.save();
  }

  public String getComment() {
    return comment;
  }

  public String getName() {
    return name;
  }

  public int getRating() {
    return rating;
  }

  public int getId() {
    return id;
  }

  private void save() {
    String sql = "INSERT INTO comments (name, barId, rating, comment) VALUES (:name, :barId, :rating, :comment);";
    try(Connection con = DB.sql2o.open()) {
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("barId", this.barId)
      .addParameter("rating", this.rating)
      .addParameter("comment", this.comment)
      .executeUpdate()
      .getKey();
    }
  }

  @Override
  public boolean equals(Object comment) {
    if(!(comment instanceof Comment)) {
      return false;
    } else {
      Comment newComment = (Comment) comment;
      return this.getComment().equals(newComment.getComment());
    }
  }
}
