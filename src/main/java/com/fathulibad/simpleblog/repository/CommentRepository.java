package com.fathulibad.simpleblog.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fathulibad.simpleblog.vo.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Serializable> {
	Comment findById(Long id);
	
	@Query("SELECT c FROM Comment c WHERE post_id = :post_id ORDER BY reg_date DESC")
    public List <Comment> findComments(
    	@Param("post_id") Long post_id);
	
	@Query("SELECT c FROM Comment c WHERE c.post_id = ?1 AND c.comment LIKE %?2%")
    List<Comment> searchComments(Long post_id, String query);

}
