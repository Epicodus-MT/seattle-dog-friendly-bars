import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("locations", Location.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/locations", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String locationName = request.queryParams("name");
      Location newLocation = new Location(locationName);
      response.redirect("/");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/location/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/location.vtl");
      Location routeLocation = Location.find(Integer.parseInt(request.params(":id")));
      model.put("location", routeLocation);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
