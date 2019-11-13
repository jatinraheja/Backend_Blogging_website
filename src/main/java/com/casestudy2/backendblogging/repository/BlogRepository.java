package com.casestudy2.backendblogging.repository;

import com.casestudy2.backendblogging.Modal.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blogs,Long> {
    List<Blogs> findAllByCategory(String cat);
    List<Blogs> findAllByWriter(String writer);
}
