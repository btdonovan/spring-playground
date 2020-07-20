package us.navonod.demo;

import org.springframework.web.bind.annotation.*;

import static java.lang.Integer.parseInt;

@RestController
//@RequestMapping("/math/volume/{length}/{width}/{height}")
public class VolumeController {
    @GetMapping("/math/volume/{length}/{width}/{height}")
//    @GetMapping("/")
    public String volume(
            @PathVariable(value="length") String length,
            @PathVariable(value="width") String width,
            @PathVariable(value="height") String height
    ) {
        StringBuilder result = new StringBuilder("");
        result.append("The volume of a " + length + "x" + width + "x" + height + " rectangle is " + (parseInt(length) * parseInt(width) * parseInt(height)));
        return result.toString();
    }

    @PostMapping("/math/volume/{length}/{width}/{height}")
//    @PostMapping("/")
    public String volumePost(
            @PathVariable(value="length") String length,
            @PathVariable(value="width") String width,
            @PathVariable(value="height") String height
    ) {
        StringBuilder result = new StringBuilder("");
        result.append("The volume of a " + length + "x" + width + "x" + height + " rectangle is " + (parseInt(length) * parseInt(width) * parseInt(height)));
        return result.toString();
    }

    @PatchMapping("/math/volume/{length}/{width}/{height}")
//    @PatchMapping("/")
    public String volumePatch(
                @PathVariable(value="length") String length,
                @PathVariable(value="width") String width,
                @PathVariable(value="height") String height
    ) {
        StringBuilder result = new StringBuilder("");
        result.append("The volume of a " + length + "x" + width + "x" + height + " rectangle is " + (parseInt(length) * parseInt(width) * parseInt(height)));
        return result.toString();
    }

}
