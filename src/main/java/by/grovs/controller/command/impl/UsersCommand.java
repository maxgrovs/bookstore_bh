package by.grovs.controller.command.impl;

import by.grovs._3_service.impl.BookServiceImpl;
import by.grovs._3_service.impl.UserServiceImpl;
import by.grovs._4_entity.Book;
import by.grovs._4_entity.User;
import by.grovs.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UsersCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = UserServiceImpl.getInstance().getAll();

        request.setAttribute("users", users);
        request.getRequestDispatcher("WEB-INF/jsp/users.jsp").forward(request, response);
    }
}