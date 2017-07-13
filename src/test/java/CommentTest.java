import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class CommentTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void comment_instanceOf_true() {
    Comment commentTest = new Comment("Shitty bar", 1, 1, "Joe");
    assertTrue(commentTest instanceof Comment);
  }
}
