package es.uco.iw.mvc.controlador.GestRemora.controlAcceso;

import es.uco.iw.mvc.modelo.data.administradorTiburonBlanco.gestATB.impl.GestATBImpl;
import es.uco.iw.mvc.modelo.data.clienteTiburonToro.gestCTT.impl.GestCTTImpl;
import es.uco.iw.mvc.modelo.data.remoraRegistrada.controlAcceso.Register;


import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.iw.mvc.modelo.data.remoraRegistrada.impl.GestRemoraImpl;
import es.uco.iw.mvc.modelo.business.AdministradorTiburonBlanco;
import es.uco.iw.mvc.modelo.business.ClienteTiburonToro;
import es.uco.iw.mvc.modelo.business.EstadoRemora;
import es.uco.iw.mvc.modelo.business.TipoRemora;

/**
 * Servlet implementation class RegistroController
 */
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect(this.getServletContext().getContextPath()+"/Vista/remoraRegistrada/controlAcceso/registrarUsuario.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String mail = request.getParameter("mail");
		String password= request.getParameter("password");
		String saltPasswd= request.getParameter("salt");
		String telefono = request.getParameter("telefono");
		String tipoRemora = request.getParameter("tipoRemora");
	
        new GestRemoraImpl(this.getServletContext());

        Register registerGEST;
        
		if (tipoRemora.equals(TipoRemora.ClienteTiburonToro.toString()))
		{
			registerGEST = new GestATBImpl(this.getServletContext());
			Vector<String> skills_Vect = new Vector<String>(Arrays.asList(request.getParameterValues("intereses")));
			ClienteTiburonToro clienteAalmacenar = new ClienteTiburonToro(nombre, apellidos,
																		mail, password,
																		saltPasswd, new Integer(telefono),
																		skills_Vect, EstadoRemora.Permitido);
			registerGEST.registrar(clienteAalmacenar);
			
		}
		else
		{
			registerGEST = new GestCTTImpl(this.getServletContext());
			AdministradorTiburonBlanco adminTB = 
					new AdministradorTiburonBlanco(nombre, apellidos,
													mail, password,
													saltPasswd, new Integer(telefono), 
													EstadoRemora.Permitido);
			registerGEST.registrar(adminTB);
		}
		response.sendRedirect(this.getServletContext().getContextPath()+"/Vista/menuPrincipal.jsp");
	}

}
