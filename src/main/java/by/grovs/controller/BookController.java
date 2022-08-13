package by.grovs.controller;

import by.grovs._3_service.impl.BookServiceImpl;
import by.grovs._4_entity.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/book")
public class BookController extends HttpServlet {

    private final BookServiceImpl service;

    public BookController(BookServiceImpl service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//
        req.getRequestDispatcher("WEB-INF/jsp/book.jsp").forward(req, resp);
        Long id = Long.valueOf(req.getParameter("id"));
//        Book book = service.getById(id);
//
//        req.setAttribute("book", book);
    }

}
