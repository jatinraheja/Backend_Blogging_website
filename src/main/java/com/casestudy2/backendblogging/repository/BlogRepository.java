package com.casestudy2.backendblogging.repository;

import com.casestudy2.backendblogging.Modal.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blogs,Long> {

}
