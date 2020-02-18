package com.casestudy2.backendblogging.controller;

import com.casestudy2.backendblogging.Modal.CommentBox;
import com.casestudy2.backendblogging.repository.CommentBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/comment")
public class CommentBoxController {
    @Autowired
    CommentBoxRepository commentBoxRepository;
    @PostMapping("/addcomment")
    public CommentBox  addcomment(@Valid @RequestBody CommentBox commentBox)
    {
        String pattern = "MMM dd,yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String date = dateFormat.format(new Date());
        commentBox.setDate(date);
       return commentBoxRepository.save(commentBox);
    }
}
