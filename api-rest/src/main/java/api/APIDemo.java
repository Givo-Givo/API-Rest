package api;
import org.json.JSONObject;

import static spark.Spark.*;

public class APIDemo {
    public static String hallo(){

        return "_Hello World_";
    }
    public static JSONObject json(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", "Givo");
        return jsonObject;
    }

    public static void main(String[] args) {

        get("/hello", (req, res) -> hallo());
        get("/json", (req, res) -> json());
        // go to => http://localhost:4567/hello
        // get parameters
        get("/:name", (request, response) -> {
            return "Hello: " +"<h2 style='color:red'>" +request.params(":name")+"</h2>" +"\n"
                    +"<p style='color:blue'>Your job is </p>"+ "<p style='color:green'>"+ request.queryParams("job")+ "</p>";

        });
    }
}
