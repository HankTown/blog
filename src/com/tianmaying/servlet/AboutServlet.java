package com.tianmaying.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tianmaying.model.Project;
import com.tianmaying.model.ProjectRepository;

@WebServlet("/about")
public class AboutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        List<Project> projects = ProjectRepository.getAll();
        request.setAttribute("projects", projects);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/about.jsp");
        dispatcher.forward(request, response);
    }
}
