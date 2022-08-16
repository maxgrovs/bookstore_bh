package by.grovs.controller;

import by.grovs._3_service.impl.BookServiceImpl;
import by.grovs._4_entity.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(request.getParameter("id"));

        Book book = BookServiceImpl.getInstance().getById(id);

        request.setAttribute("book", book);
        request.getRequestDispatcher("WEB-INF/jsp/one-book.jsp").forward(request, response);
    }
}