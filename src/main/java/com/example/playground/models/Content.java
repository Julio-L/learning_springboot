package com.example.playground.models;

import com.example.playground.types.Medium;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long contentId;

    @JsonIgnore
    @ManyToOne
    private User user;

    private String title;

    @Enumerated(EnumType.STRING)
    private Medium type;
    private int bookmark;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    private int rating;

    @Column(nullable = false)
    private String notes;

    public Content(){}

    public Content(String title, Medium type, int bookmark, int rating){
        this.title = title;
        this.type = type;
        this.bookmark = bookmark;
        this.rating = rating;
        this.notes = "";
    }

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

    public String getNotes() {
        return notes;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setType(Medium type) {
        this.type = type;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTitle() {
        return title;
    }
}
