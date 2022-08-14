package by.grovs.controller;

import by.grovs._3_service.impl.BookServiceImpl;
import by.grovs._4_entity.Book;
import by.grovs.util.ConnectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/book")
public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Long id = Long.valueOf(request.getParameter("id"));

        Book book = BookServiceImpl.getInstance().getById(id);

        request.setAttribute("book", book);
        request.getRequestDispatcher("Book.jsp").forward(request, response);


    }


}