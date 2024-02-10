package com.fathulibad.simpleblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fathulibad.simpleblog.vo.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	Post getOne(Long id);
	
	@Query("SELECT p FROM Post p ORDER BY updt_date DESC")
    public List <Post> findPost();
	
	@Query("SELECT p FROM Post p ORDER BY updt_date ASC")
    public List <Post> findPostsOrderByUpdtAsc();
	
	@Query("SELECT p FROM Post p ORDER BY reg_date DESC")
    public List <Post> findPostOrderByRegDateDesc();
	
	@Query("SELECT p FROM Post p WHERE title LIKE %:query%")
    public List <Post> findPostLikeTitle(
		@Param("query") String query);
	
	@Query("SELECT p FROM Post p WHERE content LIKE %:query%")
    public List <Post> findPostLikeContent(
		@Param("query") String query);

}
