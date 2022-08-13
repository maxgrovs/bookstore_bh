package by.grovs.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/book")
public class BookController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //---------------------------------------------
        resp.setContentType("text/plain");
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("Hello world!!!!!");
        //---------------------------------------------

        resp.setContentType("text/html");
       // resp.getWriter().println("<h1>" + counter + "</h1>");
    }

}
