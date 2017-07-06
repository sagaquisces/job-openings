import java.util.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("jobOpenings", JobOpening.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("job-openings/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/job-opening-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/job-openings", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("jobOpenings", JobOpening.all());
      model.put("template", "templates/city-job-openings-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/job-openings/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      JobOpening jobOpening = JobOpening.find(Integer.parseInt(request.params(":id")));
      model.put("jobopening", jobOpening);
      model.put("template", "templates/job-opening.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/job-openings", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.queryParams("cityId")));

      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String name = request.queryParams("name");
      String email = request.queryParams("email");

      JobOpening newJobOpening = new JobOpening(title, description, name, email);

      city.addJobOpening(newJobOpening);

      model.put("city", city);
      model.put("template", "templates/city-job-openings-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/city-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      City newCity = new City(name);
      model.put("template", "templates/city-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("cities", City.all());
      model.put("template", "templates/cities.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", city);
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id/job-openings/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", city);
      model.put("template", "templates/city-job-openings-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
