package com.example.ormi5projectteam4.service;

import com.example.ormi5projectteam4.domain.constant.ApproveStatus;
import com.example.ormi5projectteam4.domain.entity.Notice;
import com.example.ormi5projectteam4.domain.entity.Post;
import com.example.ormi5projectteam4.domain.entity.User;
import com.example.ormi5projectteam4.repository.NoticeRepository;
//import com.example.ormi5projectteam4.repository.UserRepository;
import com.example.ormi5projectteam4.repository.PostRepository;
import com.example.ormi5projectteam4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ormi5projectteam4.domain.constant.Role;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    NoticeRepository noticeRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public List<Post> getPostsByApproveStatus(ApproveStatus approveStatus){
        return postRepository.findByApproveStatus(approveStatus);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> searchUserByEmail(String email){
        return userRepository.findByEmailContaining(email);
    }

    public User changeUserRole(Long id, Role role){
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setRole(role);
            userRepository.save(user);
        }
        return user;
    }

    public Post changePostApproveStatus(Integer id, ApproveStatus approveStatus){
        Post post = postRepository.findById(id).orElse(null);
        
        if(post != null){
            post.setApproveStatus(approveStatus);
            postRepository.save(post);
        }

        return post;
    }

    public Notice saveNotice(Notice notice){
        return noticeRepository.save(notice);
    }

    public void deleteNotice(Integer id){
//        noticeRepository.deleteById(id);
    }

//    public Notice getNoticeById(Integer id){
//        return noticeRepository.findById(id).orElse(null);
//    }
    public List<Notice> getAllNotices(){
        return noticeRepository.findAll();
    }
}
