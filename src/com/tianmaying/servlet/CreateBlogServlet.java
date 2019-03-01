package com.tianmaying.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tianmaying.model.Blog;
import com.tianmaying.model.BlogRepository;
import com.tianmaying.model.BlogRepositoryByList;

@WebServlet("/create")
public class CreateBlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    BlogRepository blogRepository = BlogRepositoryByList.instance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create.jsp");
        dispatcher.forward(request, response);
    } 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String message = null;
        
        if (title == null || title.trim().length() == 0) {
            message = "博客标题不能为空";
        } else if (content == null || content.trim().length() == 0) {
            message = "博客内容不能为空";
        } else  {
            
            Blog blog = new Blog(title, content);
            blogRepository.add(blog);
            response.sendRedirect(request.getContextPath() + "/blog?id=" + blog.getId());
            return;
        }
       
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/create.jsp");
        dispatcher.forward(request, response);
    }
}
