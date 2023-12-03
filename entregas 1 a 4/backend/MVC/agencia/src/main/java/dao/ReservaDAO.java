package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import model.Pacote;
import model.Reserva;
import model.Usuario;

public class ReservaDAO {

	public void create(Reserva reserva) {
		String sql = "INSERT INTO Reservas (data_inicio, data_fim, qtd_pessoa, status_reserva, fk_usuario, fk_pacote) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(1, new Date(formatter.parse(reserva.getData_inicio()).getTime()));
			pstm.setDate(2, new Date(formatter.parse(reserva.getData_fim()).getTime()));
			pstm.setInt(3, reserva.getQtd_pessoas());
			pstm.setString(4, reserva.getStatus_reserva());
			pstm.setInt(5, reserva.getFk_usuario().getId());
			pstm.setInt(6, reserva.getFk_pacote().getId());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Reserva> read() {
		List<Reserva> reservas = new ArrayList<>();
		String sql = "SELECT * FROM Reservas";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva reserva = new Reserva();
				//Usuario usuario = new Usuario();
				//Pacote pacote = new Pacote();
				
				reserva.setId(rset.getInt("id_reserva"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				reserva.setData_inicio(dateFormat.format(rset.getDate("data_inicio")));
				reserva.setData_fim(dateFormat.format(rset.getDate("data_fim")));
				reserva.setStatus_reserva(rset.getString("status_reserva"));
				reserva.setQtd_pessoas(rset.getInt("qtd_pessoa"));
				
				//usuario.setNome(rset.getString("nome"));
				//reserva.setFk_usuario(usuario);
				
				//pacote.setDestino(rset.getString("destino"));
				//reserva.setFk_pacote(pacote);
				
				reservas.add(reserva);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reservas;
	}

	public Reserva readById(int id) {
		Reserva reserva = new Reserva();
		String sql = "SELECT * FROM Reservas WHERE id_reserva = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			reserva.setId(rset.getInt("id_reserva"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			reserva.setData_inicio(dateFormat.format(rset.getDate("data_inicio")));
			reserva.setData_fim(dateFormat.format(rset.getDate("data_fim")));
			reserva.setStatus_reserva(rset.getString("status_reserva"));
			reserva.setQtd_pessoas(rset.getInt("qtd_pessoa"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reserva;
	}

	public void update(Reserva reserva) {
	    String sql = "UPDATE Reservas SET data_inicio = ?, data_fim = ?, qtd_pessoa = ?, status_reserva = ?, fk_usuario = ?, fk_pacote = ? WHERE id_reserva = ?";
	    Connection conn = null;
	    PreparedStatement pstm = null;

	    try {
	        conn = ConnectionMySQL.createConnectionMySQL();
	        pstm = conn.prepareStatement(sql);
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        pstm.setDate(1, new Date(formatter.parse(reserva.getData_inicio()).getTime()));
	        pstm.setDate(2, new Date(formatter.parse(reserva.getData_fim()).getTime()));
	        pstm.setInt(3, reserva.getQtd_pessoas());
	        pstm.setString(4, reserva.getStatus_reserva());
	        pstm.setInt(5, reserva.getFk_usuario().getId());
	        pstm.setInt(6, reserva.getFk_pacote().getId());
	        pstm.setInt(7, reserva.getId());
	        pstm.execute();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstm != null) {
	                pstm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


	public void delete(int id) {
		String sql = "DELETE FROM Reservas WHERE id_reserva = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
