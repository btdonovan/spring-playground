package us.navonod.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlightControllerTests {
    FlightController controller;
    @BeforeEach
    public void setController() { controller = new FlightController(); }

    @Test
    public void testFlight() {
        FlightController.Flight flight = new FlightController.Flight();
    }
}
