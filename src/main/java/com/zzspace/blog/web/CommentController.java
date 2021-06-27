package com.zzspace.blog.web;

import com.zzspace.blog.model.dto.CommentDTO;
import com.zzspace.blog.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 76973 on 2021/6/23 22:24
 */
@Controller
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable("blogId") Long blogId, Model model) {
        List<CommentDTO> commentDTOS = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", commentDTOS);
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String postComment(CommentDTO commentDTO, HttpSession session) {
        if (session.getAttribute("user") != null) {
            commentDTO.setAdminComment(true);
        }
        Integer res = commentService.postComment(commentDTO);
        return "redirect:/comments/" + commentDTO.getBlogId();
    }
}
