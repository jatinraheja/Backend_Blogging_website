package com.casestudy2.backendblogging.repository;

import com.casestudy2.backendblogging.Modal.CommentBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentBoxRepository extends JpaRepository<CommentBox,Long> {

}
