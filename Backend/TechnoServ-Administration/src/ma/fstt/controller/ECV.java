package ma.fstt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.CVDAO;
import ma.fstt.dao.DemandeDAO;
import ma.fstt.entities.CV;
import ma.fstt.entities.Demande;

/**
 * Servlet implementation class ECV
 */
@WebServlet("*.cv")
public class ECV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ECV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p=request.getServletPath();
		if(p.equals("/show.cv"))
		{		
			try {
			CVDAO cdao= new CVDAO();
			Long a=Long.parseLong(request.getParameter("val"));
			InputStream input = cdao.getById(a).getDoc().getBinaryStream();
			File f=new File("C:\\Users\\hajar\\MyGH\\TechnoServ-Administration\\WebContent\\CVTechnicien.pdf");
			if (!f.exists()) {
			    f.createNewFile();
			} 
			if(f.exists()) {f.delete();}
			System.out.print(f.getAbsolutePath());
			 FileOutputStream fos = new FileOutputStream(f, false);
			 int b = 0;
			 while ((b = input.read()) != -1)
			 {
			     fos.write(b); 
			 }    
			}
			catch(Exception e) { System.out.print(e);}
				request.getRequestDispatcher("CVTechnicien.pdf").forward(request, response);
		}
		else 
		{
			try {
				CVDAO cdao= new CVDAO();
				List<CV> lcv=cdao.List();
				request.setAttribute("lc",lcv);
//				System.out.print(lcv.size());
				if(!response.isCommitted())
				request.getRequestDispatcher("espacecv.jsp").forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
