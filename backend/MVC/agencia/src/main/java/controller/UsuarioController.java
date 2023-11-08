package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet(urlPatterns = {"/usuario", "/usuario-create", "/usuario-edit","/usuario-delete", "/usuario-update"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDAO uDAO = new UsuarioDAO();
	Usuario usuario = new Usuario();

	public UsuarioController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/usuario":
			read(request, response);
			break;
		case "/usuario-create":
			create(request, response);
			break;
		case "/usuario-delete":
			delete(request, response);
			break;
		case "/usuario-edit":
			edit(request, response);
			break;
		case "/usuario-update":
			update(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		uDAO.readById(id);
		request.setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("./view/usuario/update.jsp");
		rd.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setSenha(request.getParameter("senha"));
		uDAO.update(usuario);
		response.sendRedirect("usuario");
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> lista = uDAO.read();
		request.setAttribute("listaUsuario", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./view/usuario/index.jsp");
		rd.forward(request, response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setSenha(request.getParameter("senha"));
		uDAO.create(usuario);
		response.sendRedirect("usuario");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		uDAO.delete(id);
		response.sendRedirect("usuario");
	}
}
