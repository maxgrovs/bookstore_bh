package by.grovs.controller.command.impl;

import by.grovs._3_service.impl.UserServiceImpl;
import by.grovs._4_entity.User;
import by.grovs.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(request.getParameter("id"));

        User user = UserServiceImpl.getInstance().getById(id);

        request.setAttribute("user", user);
        request.getRequestDispatcher("WEB-INF/jsp/one-user.jsp").forward(request, response);
    }
}