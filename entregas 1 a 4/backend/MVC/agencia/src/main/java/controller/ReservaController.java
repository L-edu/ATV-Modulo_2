package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacoteDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import model.Pacote;
import model.Reserva;
import model.Usuario;

@WebServlet(urlPatterns = { "/reserva", "/reserva-create", "/reserva-edit", "/reserva-update", "/reserva-delete" })
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Reserva reserva = new Reserva();
	ReservaDAO rDAO = new ReservaDAO();
	Usuario usuario = new Usuario();
	UsuarioDAO uDAO = new UsuarioDAO();
	Pacote pacote = new Pacote();
	PacoteDAO pDAO = new PacoteDAO();

	public ReservaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		List<Usuario> usuario = uDAO.read();
		List<Pacote> pacote = pDAO.read();
		
		request.setAttribute("usuario", usuario);
		request.setAttribute("pacote", pacote);

		switch (action) {
		case "/reserva":
			read(request, response);
			break;

		case "/reserva-create":
			create(request, response);
			break;

		case "/reserva-edit":
			edit(request, response);
			break;

		case "/reserva-update":
			update(request, response);
			break;

		case "/reserva-delete":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		rDAO.delete(id);
		response.sendRedirect("reserva");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {

	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idUsuario = Integer.parseInt(request.getParameter("id"));
		int idPacote = Integer.parseInt(request.getParameter("id"));
		
		if (request.getParameter("id") != null) {
			reserva.setId(Integer.parseInt(request.getParameter("id")));
		}
		
		reserva.setData_fim(request.getParameter("data_fim"));
		reserva.setData_inicio(request.getParameter("data_inicio"));
		reserva.setQtd_pessoas(Integer.parseInt(request.getParameter("qtd_pessoas")));
		reserva.setStatus_reserva(request.getParameter("status_reserva"));
		reserva.setFk_usuario(uDAO.readById(idUsuario));
		reserva.setFk_pacote(pDAO.readById(idPacote));
		rDAO.create(reserva);
		response.sendRedirect("reserva");
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Reserva> lista = rDAO.read();
		request.setAttribute("listaReserva", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./view/reserva/index.jsp");
		rd.forward(request, response);
	}
}
