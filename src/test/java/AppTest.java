import model.Speaker;
import model.Talk;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repository.SpeakerRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class AppTest
{
    private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);
    @Autowired
    private SpeakerRepository speakerRepository;

    @Before
    @Rollback(false)
    public void setUp()
    {
        Speaker pasha = new Speaker("Pavel Lapko");
        pasha.addTalk(new Talk("Maven", new Date()));
        pasha.addTalk(new Talk("The Spring Data", new Date()));

        Speaker sasha  = new Speaker("Aliaksandr Kot");
        sasha.addTalk(new Talk("The Spring Data", new Date()));

        Speaker sasha2  = new Speaker("BBBB Kot");

        Speaker ivan  = new Speaker("Ivan Kotov");

        speakerRepository.save(Arrays.asList(pasha, sasha, sasha2, ivan));
    }

    @Test
    public void findAll()
    {
        for (Speaker speaker : speakerRepository.findAll())
        {
            System.out.println(speaker);
        }
    }

    @Test
    public void findByName()
    {
       Speaker speaker = speakerRepository.findByName("Aliaksandr Kot");
        System.out.println(speaker);
    }

    @Test
    public void findByNameLike()
    {
        for (Speaker speaker : speakerRepository.findByNameLike("%Kot%"))
        {
            System.out.println(speaker);
        }
    }

    @Test
    public void findByNameEndingWith()
    {
        for (Speaker speaker : speakerRepository.findByNameEndingWith("% Kot", new Sort(Sort.Direction.DESC, "name")))
        {
            System.out.println(speaker);
        }
    }

    @Test
    public void findByTalkTitle()
    {
        List<Speaker> speakers = speakerRepository.findПожалуйстаByTalksTitleAndName("The Spring Data", "Aliaksandr Kot");
        for (Speaker speaker : speakers) {
            System.out.println(speaker);
        }


    }

//    @Test
//    public void findByNameLike()
//    {
//        for (Speaker speaker : speakerRepository.findByNameLike("%Kot%"))
//        {
//            System.out.println(speaker);
//        }
//    }
}
