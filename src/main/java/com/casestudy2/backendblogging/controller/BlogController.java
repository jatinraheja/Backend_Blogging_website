package com.casestudy2.backendblogging.controller;

import com.casestudy2.backendblogging.Modal.Blogs;
import com.casestudy2.backendblogging.exception.ResourceNotFoundException;
import com.casestudy2.backendblogging.repository.BlogRepository;
import com.casestudy2.backendblogging.service.blogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingDeque;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    blogservice blogservice;
    @PostMapping("/add")
    public Blogs addblog(@Valid @RequestBody Blogs blog)
    {
        String pattern = "MMM dd,yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String data = simpleDateFormat.format(new Date());
        blog.setLastupdated(data);
        return blogRepository.save(blog);

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
    @GetMapping(path ="/get/owner")
    public List<Blogs> getblogbyowner(Principal principal)
    {
    return blogservice.getEmail(principal);
    }
    @GetMapping("/get/writer/{writer}")
    public List<Blogs> getblogsbywriter(@PathVariable("writer") String writer)
    {
        return blogRepository.findAllByWriterLike("%"+writer+"%");
    }
    @GetMapping("/get/heading/{heading}")
    public List<Blogs> getblogsbyheading(@PathVariable("heading") String heading)
    {
        return blogRepository.findAllByHeadingLike("%"+heading+"%");
    }
    @GetMapping("/get/lastupdated/{lastupdated}")
    public List<Blogs> getblogsbylastupdated(@PathVariable("lastupdated") String lastupdated)
    {
        return blogRepository.findAllByLastupdatedLike("%"+lastupdated+"%");
    }
    @GetMapping(path = "/delete/{id}")
    public void deleteblog(@PathVariable("id") Long id)
    {
         blogRepository.deleteById(id);
    }
    @PutMapping(path = "/updateblog/{id}")
    public Blogs updateblog(@PathVariable("id") Long id, @RequestBody Blogs updatedblog)
    {
        Blogs blog = blogRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Blogs","Id",id));
        blog.setName(updatedblog.getName());
        blog.setCategory(updatedblog.getCategory());
        blog.setHeading(updatedblog.getHeading());
        blog.setDetail1(updatedblog.getDetail1());
        blog.setDetail11(updatedblog.getDetail11());
        blog.setDetail12(updatedblog.getDetail12());
        blog.setH1(updatedblog.getH1());
        blog.setDetailh1(updatedblog.getDetailh1());
        blog.setDetailh11(updatedblog.getDetailh11());
        blog.setDetailh12(updatedblog.getDetailh12());
        blog.setH2(updatedblog.getH2());
        blog.setDetailh2(updatedblog.getDetailh2());
        blog.setDetailh21(updatedblog.getDetailh21());
        blog.setDetailh22(updatedblog.getDetailh22());
        blog.setImg(updatedblog.getImg());
        blog.setStatus(updatedblog.getStatus());
        String pattern = "MMM dd,yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String data = simpleDateFormat.format(new Date());
        blog.setLastupdated(data);
        return blogRepository.save(blog);
    }
}
