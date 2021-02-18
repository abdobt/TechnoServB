package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.DemandeDAO;
import ma.fstt.dao.TechnicienDAO;
import ma.fstt.entities.Demande;
import ma.fstt.entities.Technicien;

/**
 * Servlet implementation class EProduit
 */
@WebServlet("*.p")
public class ETechnicien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	TechnicienDAO pdao;
	@Inject
	Technicien pd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ETechnicien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p=request.getServletPath();
		
		if(p.equals("/delete.p"))
		{
			try {
				pdao=new TechnicienDAO();
				pd=new Technicien();
				pd.setId(Long.parseLong(request.getParameter("val")));
				pdao.delete(pd);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/edit.p"))
		{
			try {
				pdao=new TechnicienDAO();
				pd=pdao.getById(Long.parseLong(request.getParameter("val")));
				request.setAttribute("c", pd);
				request.getRequestDispatcher("editp.jsp").forward(request, response);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/add.p"))
		{
			
			pd=new Technicien(false, 0.0, 0.0, request.getParameter("phone_num"),request.getParameter("ville"), (long) 0 , Long.parseLong(request.getParameter("id_specialite")) ,request.getParameter("email"), request.getParameter("name"), request.getParameter("password"));
			try {
			pdao=new TechnicienDAO();
			pdao.save(pd);
			}
			catch(Exception e){ System.out.print(e);}
		}
			try {
				pdao = new TechnicienDAO();
				List<Technicien> lp=pdao.List();
				System.out.println("lp : "+lp);
				request.setAttribute("produits",lp);
				if(!response.isCommitted())
				request.getRequestDispatcher("EspaceTechnicien.jsp").forward(request, response);
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
  if(p.equals("/confirmedit.p"))
  {
	   pd=new Technicien(false,0.0, 0.0, request.getParameter("phone_num"),request.getParameter("ville"), Long.parseLong(request.getParameter("id")), Long.parseLong(request.getParameter("id_specialite")) ,request.getParameter("email"), request.getParameter("name"), request.getParameter("password"));
	  try {
			 pdao=new TechnicienDAO();
			pdao.update(pd);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
  }

	try {
		pdao = new TechnicienDAO();
		List<Technicien> lc=pdao.List();
		request.setAttribute("produits",lc);
		request.getRequestDispatcher("EspaceTechnicien.jsp").forward(request, response);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
