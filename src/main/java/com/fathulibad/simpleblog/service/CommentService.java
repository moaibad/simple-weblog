package com.fathulibad.simpleblog.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fathulibad.simpleblog.repository.CommentRepository;
import com.fathulibad.simpleblog.vo.Comment;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	public boolean saveComment(Comment comment) {
		try {
			commentRepository.save(comment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public List<Comment> getCommentList(Long post_id){
		return commentRepository.findComments(post_id);
	}
	
	public Comment getComment(Long id) {
		return commentRepository.findById(id);
	}
	
	public boolean deleteComment(Long id) {
		Comment result = commentRepository.findById(id);
	    
	    if (result != null) {
	        commentRepository.deleteById(id);
	        return true; // Deletion successful
	    } else {
	        return false; // Post with the given ID not found
	    }
    }
	
	public List<Comment> searchComments(Long post_id, String query) {
        return commentRepository.searchComments(post_id, query);
    }
	
}
