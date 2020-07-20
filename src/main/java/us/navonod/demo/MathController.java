package us.navonod.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

@RestController
public class MathController {

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String volume(
            @PathVariable(value="length") String length,
            @PathVariable(value="width") String width,
            @PathVariable(value="height") String height
    ) {
        StringBuilder result = new StringBuilder("");
        result.append("The volume of a " + length + "x" + width + "x" + height + " rectangle is " + (parseInt(length) * parseInt(width) * parseInt(height)));
        return result.toString();
    }

    @PostMapping("/math/area")
    public String area(@RequestParam Map<String, String> params) {
        if (!params.containsKey("type")) {
            return "Invalid";
        } else if (params.get("type").equals("circle")) {
            if (!params.containsKey("radius") || params.containsKey("width") || params.containsKey("height")) {
                return "Invalid";
            } else {
                String result = String.format("Area of a circle with a radius of %s is %.5f", params.get("radius"), (Math.PI * Math.pow(parseFloat(params.get("radius")), 2)));
//                return "Area of a circle with a radius of " + params.get("radius") + " is " + (Math.PI * Math.pow(parseFloat(params.get("radius")), 2));
                return result;
            }
        } else if (params.get("type").equals("rectangle")) {
            if (!params.containsKey("width") || !params.containsKey("height") || params.containsKey("radius")) {
                return "Invalid";
            } else {
                String result = String.format("Area of a %s%s%s rectangle is %d", params.get("width"), "x", params.get("height"), (parseInt(params.get("width")) * parseInt(params.get("height"))));
//                return "Area of a " + params.get("width") + "x" + params.get("height") + " rectangle is " + (parseFloat(params.get("width")) * parseFloat(params.get("height")));
                return result;
            }
        }
        return params.toString();
    }
}
