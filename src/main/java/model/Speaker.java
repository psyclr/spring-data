package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SPEAKER")
public class Speaker
{
    @Id
    @Column(name = "SPEAKER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speakerId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Talk.class, mappedBy = Talk.SPEAKER_LINK)
    private Set<Talk> talks;

    public Speaker()
    {

    }

    public Speaker(String name)
    {
        this.name = name;
    }

    public void addTalk(Talk talk)
    {
        if (talks == null) talks = new HashSet<Talk>();
        talk.setSpeaker(this);
        talks.add(talk);
    }

    public Long getSpeakerId()
    {
        return speakerId;
    }

    public String getName()
    {
        return name;
    }

    public Set<Talk> getTalks()
    {
        return talks;
    }

    @Override
    public String toString()
    {
        return "Speaker{" + "speakerId=" + speakerId + ", name='" + name + '\'' + '}';
    }
}
