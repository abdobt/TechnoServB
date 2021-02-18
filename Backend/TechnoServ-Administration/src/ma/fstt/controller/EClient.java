package ma.fstt.controller;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;

/**
 * Servlet implementation class EClient
 */
@WebServlet("*.c")
public class EClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Inject
	ClientDAO cd;
	@Inject
	Client c;
    public EClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p=request.getServletPath();
		
		
		if(p.equals("/delete.c"))
		{
			try {
				cd=new ClientDAO();
				c=new Client();
				c.setId(Long.parseLong(request.getParameter("val")));
				cd.delete(c);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/edit.c"))
		{
			try {
				cd=new ClientDAO();
				c=cd.getById(Long.parseLong(request.getParameter("val")));
				request.setAttribute("c", c);
				request.getRequestDispatcher("editc.jsp").forward(request, response);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/add.c"))
		{
			
			c=new Client(request.getParameter("phone_num"),request.getParameter("ville"), (long) 0, request.getParameter("email"), request.getParameter("name"), request.getParameter("password"),request.getParameter("adresse"));
			try {
			ClientDAO cd=new ClientDAO();
			cd.save(c);
			}
			catch(Exception e){}
		}
			
		try {
				cd = new ClientDAO();
				List<Client> lc=cd.List();
				request.setAttribute("clients",lc);
				if(!response.isCommitted())
				request.getRequestDispatcher("EspaceClient.jsp").forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p=request.getServletPath();
  if(p.equals("/confirmedit.c"))
  {
	  Client c=new Client(request.getParameter("phone_num"),request.getParameter("ville"),Long.parseLong(request.getParameter("id")) , request.getParameter("email"), request.getParameter("name"), request.getParameter("password"),request.getParameter("adresse"));
	  try {
			ClientDAO cd=new ClientDAO();
			cd.update(c);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
  }
  ClientDAO cd;
	try {
		cd = new ClientDAO();
		List<Client> lc=cd.List();
		request.setAttribute("clients",lc);
		request.getRequestDispatcher("EspaceClient.jsp").forward(request, response);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
