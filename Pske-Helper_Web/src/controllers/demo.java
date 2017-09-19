package controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import checkpoints.DemoBean;
import model.checkpoints.Call;

/**
 * Servlet implementation class demo
 */
@WebServlet("/demo")
public class demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private @EJB (name = "DemoBean") DemoBean dbean;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Call> calls = dbean.getCalls();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		for(Call c : calls)
		{
			response.getWriter().append("\nCall Id: " + c.getCallID());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
