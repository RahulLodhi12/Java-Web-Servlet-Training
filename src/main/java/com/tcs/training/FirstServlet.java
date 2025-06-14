package com.tcs.training;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FirstServlet() {
        super();
    }

//Servlet is a Java program that runs on a web server and helps handle web requests.
	
    //Get -> Fetching
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("Servlet running..");
		
		
		HttpSession session = request.getSession();
		
		//Flow -> runs on server -> doGet() -> change url(index.html) -> Html -> submit -> action -> "first" -> request -> requesting for fetching -> session ke through attribute set 
		
		//Getting values from Request -> fetching
		String newName = request.getParameter("name");
		String newCity = request.getParameter("city");
		
		
		String myName="";
		
		//By using Session -> Attributes are set.
		session.setAttribute(myName, newName); //By default -> after 30 minutes session gets expired..
		
		
		//Through Request
		out.println("Welcome: request " + newName);
		
		
		//Through Session
		out.println("Welcome: session " + session.getAttribute(myName));
	}

	//Post -> Send/Submit
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
