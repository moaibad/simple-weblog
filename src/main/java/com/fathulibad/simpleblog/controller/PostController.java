package com.fathulibad.simpleblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fathulibad.simpleblog.service.PostService;
import com.fathulibad.simpleblog.vo.Post;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/post")
	public Post getPost(@RequestParam("id") Long id) {
		Post post = postService.getPost(id);
		return post;
	}
	
	@GetMapping("/posts")
	public List<Post> getPosts() {
		List<Post> posts = postService.getPosts();
		return posts;
	}
	
	@GetMapping("/post/{id}")
	public Post getPostPathParam(@PathVariable("id") Long id) {
		Post post = postService.getPost(id);
		return post;
	}
	
	@GetMapping("/posts/updtdate/asc")
	public List<Post> getPostsOrderByUpdtAsc(){
		return postService.getPostsOrderByUpdtAsc();
	}
	
	@GetMapping("/posts/regdate/desc")
	public List<Post> getPostsOrderByRegDesc(){
		return postService.getPostsOrderByRegDesc();
	}
	
	@GetMapping("/posts/search/title")
	public List<Post> searchByTitle(@RequestParam("query") String query){
		return postService.searchPostByTitle(query);
	}
	
	@GetMapping("/posts/search/content")
	public List<Post> searchByContent(@RequestParam("query") String query){
		return postService.searchPostByContent(query);
	}
	
}
