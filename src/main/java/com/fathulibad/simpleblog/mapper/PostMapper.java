//package com.fathulibad.simpleblog.mapper;
//
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import com.fathulibad.simpleblog.vo.Post;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Component
//public class PostMapper implements RowMapper<Post> {
//    
//    @Override
//    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Post post = new Post();
//        
//        post.setId(rs.getLong("id"));
//        post.setUser(rs.getString("user"));
//        post.setTitle(rs.getString("title"));
//        post.setContent(rs.getString("content"));
//        post.setRegDate(rs.getDate("regDate"));
//        post.setUpdtDate(rs.getDate("updtDate"));
//        
//        return post;
//    }
//}
