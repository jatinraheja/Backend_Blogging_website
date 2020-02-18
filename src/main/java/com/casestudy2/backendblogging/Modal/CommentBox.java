package com.casestudy2.backendblogging.Modal;

import javax.persistence.*;

@Entity
public class CommentBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String comment;
    private String date;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


}
