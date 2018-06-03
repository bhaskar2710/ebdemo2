package com.kartik.practice;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CrucibleQuiz
 */
@WebServlet("/CrucibleQuiz")
public class CrucibleQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    PrintWriter out;
    HttpSession hs;
    public CrucibleQuiz() //
    {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int score = 0;
		 out=response.getWriter();
		String CHECK=request.getParameter("check"); 
		String ans=request.getParameter("question");
		
		 hs = request.getSession();
		switch(CHECK)
		{
		case "1":
						if(ans.equals("c"))
					{
						
						score = score+25000;
						hs.setAttribute("score",score); 
						
						RequestDispatcher rd=request.getRequestDispatcher("SecondQuestion.html");
						rd.include(request,response);
						
						
					}
						else
						{	
							
							out.println("YOU LOST THE GAME.. PLEASE TRY AGAIN");
						}
					break;
		case "2":
						if(ans.equals("b"))
						{
							
							
							
							score = score+50000;
							hs.setAttribute("score",score);  
							
							RequestDispatcher rd=request.getRequestDispatcher("ThirdQuestion.html");
							rd.include(request,response);
						}
						
						else
						{	
							
							out.println("YOU LOST THE GAME.. PLEASE TRY AGAIN");
						}
					
					break;
		case "3":
			if(ans.equals("d"))
			{
				
				score = score+100000;
				
				
				
				out.println("<html><body><center><table border='"+4+"'><center>");
				out.println("<tr><td><h1>CONGRATULATIONS..AAP LAKHPAI BAN GYE HAI AUR AAPKO MILTE HAI RS. :<b>"+score+"<h1></b></td></tr>");
				out.println("</table></center></body></html>");
				
					
			}
			
			else
			{	
				
				out.println("YOU LOST THE GAME.. PLEASE TRY AGAIN");
		
			}
		break;
	}
		out.close();
}
}
