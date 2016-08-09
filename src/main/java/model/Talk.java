package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TALK")
public class Talk
{
    public static final String SPEAKER_LINK = "speaker";
    @Id
    @Column(name = "TALK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long talkId;

    @Column(name = "DATE")
    private Date when;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Speaker.class)
    @JoinColumn(name = "FK_SPEAKER_ID")
    private Speaker speaker;

    public Talk()
    {

    }

    public Talk(String title, Date when)
    {
        this.title = title;
        this.when = when;
    }

    public Long getTalkId()
    {
        return talkId;
    }

    public void setTalkId(Long talkId)
    {
        this.talkId = talkId;
    }

    public Date getWhen()
    {
        return when;
    }

    public void setWhen(Date when)
    {
        this.when = when;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Speaker getSpeaker()
    {
        return speaker;
    }

    public void setSpeaker(Speaker speaker)
    {
        this.speaker = speaker;
    }

    @Override
    public String toString()
    {
        return "Talk{" + "talkId=" + talkId + ", when=" + when + ", title='" + title + '\'' +  '}';
    }
}
