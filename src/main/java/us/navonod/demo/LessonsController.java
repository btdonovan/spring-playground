package us.navonod.demo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    // Create
    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    // Read
    @GetMapping("/{id}")
    public Lesson read(@PathVariable(value="id") Long id) {
        return this.repository.findById(id).orElse(new Lesson());
    }

    // Update
    @PatchMapping("/{id}")
    public Lesson update(
            @PathVariable(value="id") Long id,
            @RequestBody Lesson newLesson
    ) {
        Optional<Lesson> oldLesson = this.repository.findById(id);
        if (newLesson.getTitle() != null) {
            oldLesson.get().setTitle(newLesson.getTitle());
        }
        if (newLesson.getDeliveredOn() != null) {
            oldLesson.get().setDeliveredOn(newLesson.getDeliveredOn());
        }
        return this.repository.save(oldLesson.get());
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable(value="id") Long id
    ) {
        Optional<Lesson> lesson = this.repository.findById(id);
        if (lesson.isPresent()) {
            String title = lesson.get().getTitle();
            this.repository.delete(lesson.get());
            return "The lesson titled " + title + " has been deleted.";
        } else {
            return "No lesson was found with the given id. No lesson deleted.";
        }
    }

    // List
    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();

    }

    @GetMapping("/find/{title}")
    public Lesson findByTitle(
            @PathVariable(value="title") String title
    ) {
        Optional<Lesson> lesson = Optional.ofNullable(this.repository.findByTitle(title));
        if (lesson.isPresent()) {
            return lesson.get();
        }
        return new Lesson();
    }

    @GetMapping("/between")
    public List<Lesson> findByDeliveredOnBetween(
            @RequestParam(value="date1", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date1,
            @RequestParam(value="date2", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date2
    ) {
        return this.repository.findByDeliveredOnBetween(date1, date2);
    }

}
