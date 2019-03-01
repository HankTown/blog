package com.tianmaying.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tianmaying.model.Blog;
import com.tianmaying.model.BlogRepository;
import com.tianmaying.model.BlogRepositoryByList;

@WebServlet("/blogs")
public class BlogsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private BlogRepository blogRepository = BlogRepositoryByList.instance();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        List<Blog> blogs = blogRepository.getAll();
        request.setAttribute("blogs", blogs);
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/WEB-INF/jsp/list.jsp");
        dispatcher.forward(request, response);
    }
}
