package com.casestudy2.backendblogging.Modal;

import javax.persistence.*;

@Entity
public class CommentMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    private CommentBox commentBox;
    @ManyToOne
    private Blogs blogs;
    @ManyToOne
    private Users users;
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public CommentBox getCommentBox() {
        return commentBox;
    }

    public void setCommentBox(CommentBox commentBox) {
        this.commentBox = commentBox;
    }

    public Blogs getBlogs() {
        return blogs;
    }

    public void setBlogs(Blogs blogs) {
        this.blogs = blogs;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }



}
