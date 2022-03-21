package com.example.playground.models;

import com.example.playground.types.Medium;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long contentId;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private Medium type;
    private int bookmark;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    private int rating;

    public Content(){}

    public long getContentId() {
        return contentId;
    }

    public User getUser() {
        return user;
    }

    public Medium getType() {
        return type;
    }

    public int getBookmark() {
        return bookmark;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public int getRating() {
        return rating;
    }
}
