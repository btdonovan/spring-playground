package us.navonod.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

    List<Lesson> findByDeliveredOnBetween(Date date1, Date date2);

    Lesson findByTitle(String title);

}
