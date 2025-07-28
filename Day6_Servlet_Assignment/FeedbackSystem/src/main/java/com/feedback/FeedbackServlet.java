package com.feedback;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/submitFeedback")
public class FeedbackServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("studentName");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String feedback = request.getParameter("feedback");

        Cookie[] cookies = request.getCookies();
        boolean alreadySubmitted = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("submitted") && c.getValue().equals("true")) {
                    alreadySubmitted = true;
                    break;
                }
            }
        }

        if (alreadySubmitted) {
            out.println("<h3>You have already submitted the feedback!</h3>");
        } else {
            Cookie cookie = new Cookie("submitted", "true");
            cookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(cookie);

            out.println("<h2>Thank you for your feedback!</h2>");
            out.println("<p><b>Name:</b> " + name + "</p>");
            out.println("<p><b>Email:</b> " + email + "</p>");
            out.println("<p><b>Course:</b> " + course + "</p>");
            out.println("<p><b>Feedback:</b> " + feedback + "</p>");
        }

        out.close();
    }

}
