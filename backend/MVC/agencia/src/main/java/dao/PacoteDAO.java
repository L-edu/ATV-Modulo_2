package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import model.Pacote;

public class PacoteDAO {

	public void create(Pacote pacote) {
		String sql = "INSERT INTO Pacotes (destino, preco) VALUES (?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pacote.getDestino());
			pstm.setDouble(2, pacote.getPreco());

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

	public List<Pacote> read() {
		List<Pacote> pacotes = new ArrayList<>();
		String sql = "SELECT * FROM Pacotes";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(rset.getInt("id_pacote"));
				pacote.setDestino(rset.getString("destino"));
				pacote.setPreco(rset.getDouble("preco"));
				pacotes.add(pacote);
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
		return pacotes;
	}

	public Pacote readById(int id) {
		Pacote pacote = new Pacote();
		String sql = "SELECT * FROM Pacotes WHERE id_pacote = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			pacote.setId(rset.getInt("id_pacote"));
			pacote.setDestino(rset.getString("destino"));
			pacote.setPreco(rset.getDouble("preco"));

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
		return pacote;
	}

	public void update(Pacote pacote) {
		String sql = "UPDATE Pacotes SET destino=?, preco=? WHERE id_pacote = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pacote.getDestino());
			pstm.setDouble(2, pacote.getPreco());
			pstm.setInt(3, pacote.getId());
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
		String sql = "DELETE FROM Pacotes WHERE id_pacote = ?";
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
