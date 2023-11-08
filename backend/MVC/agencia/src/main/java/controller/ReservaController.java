package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservaDAO;
import model.Pacote;
import model.Reserva;
import model.Usuario;


@WebServlet(urlPatterns = { "/reserva", "/reserva-create", "/reserva-edit", "/reserva-update", "/reserva-delete" })
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Reserva reserva = new Reserva();
	ReservaDAO rDAO = new ReservaDAO();
	Usuario usuario = new Usuario();
	Pacote pacote = new Pacote();
 
    public ReservaController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

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

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		
	}


	private void update(HttpServletRequest request, HttpServletResponse response) {
		
	}


	private void edit(HttpServletRequest request, HttpServletResponse response) {
		
	}


	private void create(HttpServletRequest request, HttpServletResponse response) {
		
	}


	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Reserva> lista = rDAO.read();

		request.setAttribute("listaReservas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/reservas/reserva.jsp");
		rd.forward(request, response);
	}
}
