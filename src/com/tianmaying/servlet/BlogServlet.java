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

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private BlogRepository blogRepository = BlogRepositoryByList.instance();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       String id = request.getParameter("id");

        if (id != null) {
            try {
                long blogId = Long.parseLong(id);
                Blog blog = blogRepository.getBlogById(blogId);
                if (blog != null) {
                    request.setAttribute("blog", blog);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            } catch (Exception e) {
                //
            }
            
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/404.jsp");
        dispatcher.forward(request, response);
        
    }
}
