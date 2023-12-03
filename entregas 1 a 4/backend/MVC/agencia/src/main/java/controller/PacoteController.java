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
import model.Pacote;


@WebServlet(urlPatterns = {"/pacote", "/pacote-create", "/pacote-edit","/pacote-delete", "/pacote-update"})
public class PacoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Pacote pacote = new Pacote();
       PacoteDAO pDAO = new PacoteDAO();

    public PacoteController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/pacote":
			read(request, response);
			break;
		case "/pacote-create":
			create(request, response);
			break;
		case "/pacote-delete":
			delete(request, response);
			break;
		case "/pacote-edit":
			edit(request, response);
			break;
		case "/pacote-update":
			update(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pDAO.readById(id);
		request.setAttribute("pacote", pacote);
		RequestDispatcher rd = request.getRequestDispatcher("./view/pacote/update.jsp");
		rd.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		pacote.setId(Integer.parseInt(request.getParameter("id")));
		pacote.setDestino(request.getParameter("destino"));
		pacote.setPreco(Double.parseDouble(request.getParameter("preco")));
		response.sendRedirect("pacote");
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pacote> lista = pDAO.read();
		request.setAttribute("listaPacote", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./view/pacote/index.jsp");
		rd.forward(request, response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pacote.setDestino(request.getParameter("destino"));
		pacote.setPreco(Double.parseDouble(request.getParameter("preco")));
		pDAO.create(pacote);
		response.sendRedirect("pacote");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pDAO.delete(id);
		response.sendRedirect("pacote");
	}
}