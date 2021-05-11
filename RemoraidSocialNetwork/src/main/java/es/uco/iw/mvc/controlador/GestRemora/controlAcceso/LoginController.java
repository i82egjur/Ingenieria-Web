package es.uco.iw.mvc.controlador.GestRemora.controlAcceso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.iw.mvc.modelo.data.remoraRegistrada.controlAcceso.Login;
import es.uco.iw.mvc.modelo.data.remoraRegistrada.impl.LoginRemoraDAO;


/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(this.getServletContext().getContextPath()+"/Vista/remoraRegistrada/controlAcceso/login.jsp");
		
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginMail = request.getParameter("login-mail");
		System.out.println(loginMail);

		String loginPass = request.getParameter("login-pass");
		System.out.println(loginPass);

		 Login loginGEST = new LoginRemoraDAO(this.getServletContext());

		 if (loginGEST.login(loginMail, loginPass))
		 {
			 request.getSession().setAttribute("mailUsuarioLogado", loginMail);
			 response.sendRedirect(this.getServletContext().getContextPath()+"/Vista/remoraRegistrada/controlAcceso/login.jsp");
		 }
		
	}

}
