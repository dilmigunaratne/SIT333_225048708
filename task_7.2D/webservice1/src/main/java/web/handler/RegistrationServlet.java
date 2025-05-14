package web.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.service.RegistrationService;

/**
 * HTTP end-point to handle registration service.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {   
        System.out.println("[RegistrationServlet] GET");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {
        System.out.println("[RegistrationServlet] POST");

        // Extract form data
        String fName = req.getParameter("fname");
        String lName = req.getParameter("lname");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");

        System.out.println("Received -> fname: " + fName);
        System.out.println("Received -> lname: " + lName);
        System.out.println("Received -> email: " + email);
        System.out.println("Received -> dob: " + dob);

        String registrationStatus = "fail";

        // Registration logic
        if (RegistrationService.register(fName, lName, email, dob)) {
            registrationStatus = "success";
        }

        // Build HTML response
        String htmlResponse = "<html>";
        htmlResponse += "<head><title>" + registrationStatus + "</title></head>";
        htmlResponse += "<h2>Registration status: " + registrationStatus + "</h2>";
        htmlResponse += "</html>";

        // Send response
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(htmlResponse);
    }
}
