package us.navonod.demo;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

@RestController
public class PagesController {
    @GetMapping("/math/pi")
    public String helloGet() {
        return "3.141592653589793";
    }

    @GetMapping("/math/calculate")
    public String operate(
            @RequestParam(value="operation", required=false, defaultValue="add") String operation,
            @RequestParam(value="x", required=true) String x,
            @RequestParam(value="y", required=true) String y
    ) {
        int xValue = parseInt(x);
        int yValue = parseInt(y);
        if (operation.equals("subtract")) {
            return x + " - " + y + " = " + (xValue - yValue);
        } else if (operation.equals("multiply")) {
            return x + " * " + y + " = " + (xValue * yValue);
        } else if (operation.equals("divide")) {
            return x + " / " + y + " = " + (xValue / yValue);
        } else if (operation.equals("add")) {
            return x + " + " + y + " = " + (xValue + yValue);
        }
        return null;
    }

    @PostMapping("/math/sum")
    public String sum(
            @RequestParam MultiValueMap<String, String> querystring
            ) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < querystring.get("n").size(); i++) {
            if (i == querystring.get("n").size() - 1) {
                result.append(querystring.get("n").get(i) + " = ");
            } else {
                result.append(querystring.get("n").get(i) + " + ");
            }
            sum += parseInt(querystring.get("n").get(i));
        }
        result.append(valueOf(sum));

        return result.toString();
    }

    @GetMapping("/name")
    public String getName(
            @RequestParam(value = "firstname", required=false, defaultValue="Benjamin") String firstName,
            @RequestParam(value = "lastname", required=false, defaultValue="Donovan") String lastName
    ) {
        return "Hello " + firstName + " " + lastName;
    }

    @GetMapping("/name-map")
    public String getMapParams(@RequestParam Map<String,String> querystring) {
        String firstName = querystring.get("firstname");
        String lastName = querystring.get("lastname");
        return "Hello " + firstName + " " + lastName + " from name-map";
    }


}
