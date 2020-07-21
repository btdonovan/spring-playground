package us.navonod.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class FlightController {


    static class Flight {
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonProperty("Departs")
        private Date departs;
        @JsonProperty("Tickets")
        private List<Ticket> tickets;

        public Date getDeparts() {
            return departs;
        }

        public void setDeparts(Date departs) {
            this.departs = departs;
        }

        public List<Ticket> getTickets() {
            return tickets;
        }

        public void setTickets(List<Ticket> tickets) {
            this.tickets = tickets;
        }
    }


    static class Ticket {
        @JsonProperty("Passenger")
        private Passenger passenger;
        @JsonProperty("Price")
        private int price;

        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Passenger {
        @JsonProperty("FirstName")
        private String firstName;
        @JsonProperty("LastName")
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    @GetMapping("/flights/flight")
    public Flight flight() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(2017, 4,21,8,34,0);
        Flight flight = new Flight();
        flight.setDeparts(cal.getTime());
        Ticket ticket = new Ticket();
        ticket.setPrice(200);
        Passenger passenger = new Passenger();
        passenger.setFirstName("Some name");
        passenger.setLastName("Some other name");
        ticket.setPassenger(passenger);
        List<Ticket> tickets = Arrays.asList(ticket);
        flight.setTickets(tickets);

        return flight;
    }

    @GetMapping("/flights")
    public List<Flight> flights() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(2017, 4,21,8,34,0);
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        flight1.setDeparts(cal.getTime());
        flight2.setDeparts(cal.getTime());
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        ticket1.setPrice(200);
        ticket2.setPrice(400);
        Passenger passenger1 = new Passenger();
        Passenger passenger2 = new Passenger();
        passenger1.setFirstName("Some name");
        passenger1.setLastName("Some other name");
        passenger2.setFirstName("Some other first name");
        ticket1.setPassenger(passenger1);
        ticket2.setPassenger(passenger2);
        List<Ticket> tickets1 = Arrays.asList(ticket1);
        List<Ticket> tickets2 = Arrays.asList(ticket2);
        flight1.setTickets(tickets1);
        flight2.setTickets(tickets2);

        List<Flight> flights = Arrays.asList(flight1, flight2);

        return flights;
    }
}
