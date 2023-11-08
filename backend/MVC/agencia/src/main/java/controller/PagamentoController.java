package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PagamentoDAO;
import model.Pagamento;
import model.Reserva;

@WebServlet(urlPatterns = { "/pagamento", "/pagamento-create", "/pagamento-edit", "/pagamento-update", "/pagamento-delete" })
public class PagamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Pagamento pagamento = new Pagamento();
	PagamentoDAO pDAO = new PagamentoDAO();
	Reserva reserva = new Reserva();

    public PagamentoController() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/pagamento":
			read(request, response);
			break;

		case "/pagamento-create":
			create(request, response);
			break;
			
		case "/pagamento-edit":
			edit(request, response);
			break;
			
		case "/pagamento-update":
			update(request, response);
			break;

		case "/pagamento-delete":
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

		List<Pagamento> lista = pDAO.read();

		request.setAttribute("listaPagamento", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/pagamentos/pagamento.jsp");
		rd.forward(request, response);
	}
}
