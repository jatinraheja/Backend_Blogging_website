package com.casestudy2.backendblogging.controller;

import com.casestudy2.backendblogging.Modal.Blogs;
import com.casestudy2.backendblogging.exception.ResourceNotFoundException;
import com.casestudy2.backendblogging.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.BlockingDeque;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogRepository blogRepository;
    @PostMapping(path = "/add",consumes = "Application/Json")
    public Blogs addblog(@Valid @RequestBody Blogs blog)
    {
        blogRepository.save(blog);
        return blog;
    }
    @GetMapping(path = "/get")
    public List<Blogs> getblogs(){
        return blogRepository.findAll();
    }
    @GetMapping("/get/{id}")
    public Blogs getblog(@PathVariable("id") Long id){
        return blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blogs","Id",id));
    }
    @GetMapping("/get/cat/{cat}")
    public List<Blogs> getblogsbycategory(@PathVariable("cat") String cat)
    {
        return blogRepository.findAllByCategory(cat);
    }
    @GetMapping("/get/writer/{writer}")
    public List<Blogs> getblogsbywriter(@PathVariable("writer") String writer)
    {
        return blogRepository.findAllByWriter(writer);
    }
}
