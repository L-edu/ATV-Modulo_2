package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import model.Pagamento;

public class PagamentoDAO {
	public void create(Pagamento pagamento) {
		String sql = "INSERT INTO Pagamentos (tipo, valor, fk_reserva) VALUES (?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pagamento.getTipo());
			pstm.setDouble(2, pagamento.getValor());
			pstm.setInt(3, pagamento.getFk_reserva());

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

	public List<Pagamento> read() {
		List<Pagamento> pagamentos = new ArrayList<>();
		String sql = "SELECT * FROM Pagamentos";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Pagamento pagamento = new Pagamento();
				pagamento.setId(rset.getInt("id_pagamento"));
				pagamento.setTipo(rset.getString("tipo"));
				pagamento.setValor(rset.getDouble("valor"));
				pagamento.setFk_reserva(rset.getInt("fk_reserva"));
				pagamentos.add(pagamento);
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
		return pagamentos;
	}

	public Pagamento readById(int id) {
		Pagamento pagamento = new Pagamento();
		String sql = "SELECT * FROM Pagamentos WHERE id_pagamento = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			pagamento.setId(rset.getInt("id_pagamento"));
			pagamento.setTipo(rset.getString("tipo"));
			pagamento.setValor(rset.getDouble("valor"));
			pagamento.setFk_reserva(rset.getInt("fk_reserva"));

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
		return pagamento;
	}

	public void update(Pagamento pagamento) {
		String sql = "UPDATE Pagamentos SET tipo=?, valor=?, fk_reserva=? WHERE id_pagamento = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pagamento.getTipo());
			pstm.setDouble(2, pagamento.getValor());
			pstm.setInt(3, pagamento.getFk_reserva());
			pstm.setInt(4, pagamento.getId());
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
		String sql = "DELETE FROM Pagamentos WHERE id_pagamento = ?";
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
