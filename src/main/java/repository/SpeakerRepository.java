package repository;

import model.Speaker;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SpeakerRepository extends PagingAndSortingRepository<Speaker, Long>
{
    @Query("select s from Spreaker s where s.name = :name")
    Speaker findByName(String name);

    List<Speaker> findByNameLike(String name);

    List<Speaker> findByNameEndingWith(String name, Sort sort);

    List<Speaker> findПожалуйстаByTalksTitleAndName(String title, String name);
}
