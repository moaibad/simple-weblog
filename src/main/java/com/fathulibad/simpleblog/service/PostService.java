package com.fathulibad.simpleblog.service;

import java.util.List;
import java.util.Optional;

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
	
	public boolean savePost(Post post) {
        try {
            postRepository.save(post);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean deletePost(Long id) {
		Optional<Post> result = postRepository.findById(id);
	    
	    if (result.isPresent()) {
	        postRepository.deleteById(id);
	        return true; // Deletion successful
	    } else {
	        return false; // Post with the given ID not found
	    }
    }
	
	public boolean updatePost(Post post) {
		Optional<Post> optionalPost = postRepository.findById(post.getId());
	    
	    if (optionalPost.isPresent()) {
	        Post result = optionalPost.get();
	        boolean changes = false;
	        
	        if (post.getTitle() != null && !post.getTitle().isEmpty()) {
	            result.setTitle(post.getTitle());
	            changes = true;
	        }
	        
	        if (post.getContent() != null && !post.getContent().isEmpty()) {
	            result.setContent(post.getContent());
	            changes = true;
	        }
	        
	        if(changes == true) {
	        	result.setUpdtDate(post.getUpdtDate());
	        }
	        
	        postRepository.save(result);
	        
	        return true; 
	    } else {	    	
	        return false;
	    }
		
	}
}
