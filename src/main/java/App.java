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

    post("/bars", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String barName = request.queryParams("name");
      Integer locationId = Integer.parseInt(request.queryParams("locationId"));
      String street = request.queryParams("street");
      String city = request.queryParams("city");
      String state = request.queryParams("state");
      Integer zip = Integer.parseInt(request.queryParams("zip"));
      Bar newBar = new Bar(barName, locationId, street, city, state, zip);
      String url = String.format("/location/%d", locationId);
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
