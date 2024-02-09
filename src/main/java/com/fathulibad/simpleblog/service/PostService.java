package com.fathulibad.simpleblog.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fathulibad.simpleblog.repository.PostRepository;
import com.fathulibad.simpleblog.vo.Post;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public Post getPost(Long id) {
		return postRepository.getOne(id);
	}
	
	public List<Post> getPosts() {
		return postRepository.findPost();
	}
	
	public List<Post> getPostsOrderByUpdtAsc(){
		return postRepository.findPostsOrderByUpdtAsc();
	}
	
	public List<Post> getPostsOrderByRegDesc(){
		return postRepository.findPostOrderByRegDateDesc();
	}
	
	public List<Post> searchPostByTitle(String query){
		return postRepository.findPostLikeTitle(query);
	}
	
	public List<Post> searchPostByContent(String query){
		return postRepository.findPostLikeContent(query);
	}
}
