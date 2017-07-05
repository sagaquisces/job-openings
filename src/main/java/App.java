import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("jobopening", request.session().attribute("jobopening"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/job-openings", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String name = request.queryParams("name");
      String email = request.queryParams("email");

      JobOpening newJobOpening = new JobOpening(title, description, name, email);
      request.session().attribute("jobopening", newJobOpening);
      model.put("jobopening",request.session().attribute("jobopening"));
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
