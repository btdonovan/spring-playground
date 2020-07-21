package us.navonod.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class SerializationController {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Person{
        @JsonIgnore
        private String firstName;
        @JsonProperty("last-name")
        private String lastName;
        @JsonFormat(pattern = "yyyy-MM-dd")
        @JsonProperty("birth-date")
        private Date birthDate;

        public Person(String firstName, String lastName, Date birthDate) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
        }

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = null;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Date getBirthDate() {
            return birthDate;
        }

    }

    @GetMapping("/person")
    public Person getPerson() {

        String firstName = "Steve";
        String lastName = "Austin";
        Date birthDate = new Date();
        Person person = new Person(firstName, lastName, birthDate);

        return person;
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        Person person1 = new Person("Scott", "Hall", new Date());
        Person person2 = new Person("Kevin", "Nash");
        return Arrays.asList(person1, person2);
    }
}
