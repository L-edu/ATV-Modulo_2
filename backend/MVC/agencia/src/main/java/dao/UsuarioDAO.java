package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Usuario;

public class UsuarioDAO {

	public void create(Usuario usuario) {
		String sql = "INSERT INTO Usuarios (nome, email, telefone, senha) VALUES (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getTelefone());
			pstm.setString(4, usuario.getSenha());
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

	public List<Usuario> read() {
		String sql = "SELECT * FROM Usuarios";
		List<Usuario> usuarios = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rset.getInt("id_usuario"));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				usuario.setTelefone(rset.getString("telefone"));
				usuario.setSenha(rset.getString("senha"));
				usuarios.add(usuario);
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
		return usuarios;
	}

	public Usuario readById(int id) {
		String sql = "SELECT * FROM Usuarios WHERE id_usuario = ?";
		Usuario usuario = new Usuario();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			usuario.setId(rset.getInt("id_usuario"));
			usuario.setNome(rset.getString("nome"));
			usuario.setEmail(rset.getString("email"));
			usuario.setTelefone(rset.getString("telefone"));
			usuario.setSenha(rset.getString("senha"));

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
		return usuario;
	}

	public void update(Usuario usuario) {
	    String sql = "UPDATE Usuarios SET nome=?, email=?, telefone=?, senha=? WHERE id_usuario = ?";
	    Connection conn = null;
	    PreparedStatement pstm = null;

	    try {
	        conn = ConnectionMySQL.createConnectionMySQL();
	        pstm = conn.prepareStatement(sql);

	        pstm.setString(1, usuario.getNome());
	        pstm.setString(2, usuario.getEmail());
	        pstm.setString(3, usuario.getTelefone());
	        pstm.setString(4, usuario.getSenha());
	        pstm.setInt(5, usuario.getId());
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
		String sql = "DELETE FROM Usuarios WHERE id_usuario = ?";
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
