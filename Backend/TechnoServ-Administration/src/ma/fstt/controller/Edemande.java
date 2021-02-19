package ma.fstt.controller;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.DemandeDAO;
import ma.fstt.dao.TechnicienDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Demande;
import ma.fstt.entities.User;
import ma.fstt.entities.Technicien;

/**
 * Servlet implementation class ECommande
 */
@WebServlet("*.cmd")
public class Edemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	DemandeDAO cdao;
	@Inject
	Demande cm;
	@Inject
	User lc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edemande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p=request.getServletPath();
		
		if(p.equals("/delete.cmd"))
		{
			try {
				 cdao=new DemandeDAO();
				cm=new Demande();
				cm.setId(Long.parseLong(request.getParameter("val")));
				
				cdao.delete(cm);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/edit.cmd"))
		{
			try {
				cdao=new DemandeDAO();
				cm=cdao.getById(Long.parseLong(request.getParameter("val")));
				request.setAttribute("a", cm);
				request.getRequestDispatcher("editd.jsp").forward(request, response);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/add.cmd"))
		{
			
			cm=new Demande((long) 0,request.getParameter("adresse"), null,  null, Long.parseLong(request.getParameter("id_client")), Long.parseLong(request.getParameter("id_specialite")), Double.parseDouble(request.getParameter("rating")));
//			cm.setId_client(Integer.parseInt(request.getParameter("id_client")));
			try {
				cdao=new DemandeDAO();
				cdao.save(cm);
//				Demande cmd = cdao.getlast();
//				request.setAttribute("cmd",cmd);
				request.getRequestDispatcher("EspaceCommande.jsp").forward(request, response);
				
			}
			
			catch(Exception e){System.out.print(e);}
		}
		
			try {
				cdao = new DemandeDAO();
				List<Demande> lcmd=cdao.List();
				request.setAttribute("commandes",lcmd);
				if(!response.isCommitted())
				request.getRequestDispatcher("EspaceCommande.jsp").forward(request, response);
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
		String p=request.getServletPath();
		  if(p.equals("/confirmedit.cmd"))
		  {
			   cm=new Demande(Long.parseLong(request.getParameter("id")),request.getParameter("adresse"), 0.0,  0.0, Long.parseLong(request.getParameter("id_client")), Long.parseLong(request.getParameter("id_specialite")), Double.parseDouble(request.getParameter("rating")));
			  try {
					 cdao=new DemandeDAO();
					cdao.update(cm);
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}
		  }
	try {
		cdao = new DemandeDAO();
		List<Demande> lcmd=cdao.List();
		request.setAttribute("commandes",lcmd);
		request.getRequestDispatcher("EspaceCommande.jsp").forward(request, response);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
