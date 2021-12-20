package br.com.videoaulazeni.exemploWS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
public boolean inserirUsuario(Usuario usuario) {
		
		try {
			Connection conn = ConnectaMysql.obterConexao();
			
			String queryInserir = "INSERT INTO usuario VALUES (null, ?, ?, ?, ? , ?, ?)";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);	
			
			ppStm.setString(1, usuario.getNomeProprietario());
			ppStm.setString(2, usuario.getNomeFazenda());
			ppStm.setString(3, usuario.getPlantio());
			ppStm.setString(4, usuario.getEndereco());
			ppStm.setString(5, usuario.getTelContato());
			ppStm.setInt(6, usuario.getArea());
			
			ppStm.executeUpdate();
			
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
  public boolean atualizarUsuario(Usuario usuario) {
		
		try {
			Connection conn = ConnectaMysql.obterConexao();
			
			String queryInserir = "UPDATE usuario SET nomeProprietario =?, nomeFazenda= ?, plantio= ?, endereco= ?, telContato= ?, area= ? WHERE id= ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);	
			
			ppStm.setString(1, usuario.getNomeProprietario());
			ppStm.setString(2, usuario.getNomeFazenda());
			ppStm.setString(3, usuario.getPlantio());
			ppStm.setString(4, usuario.getEndereco());
			ppStm.setString(5, usuario.getTelContato());
			ppStm.setInt(6, usuario.getArea());
			ppStm.setInt(7, usuario.getId());
			
			ppStm.executeUpdate();
			
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
//		
	public boolean excluirUsuario(Usuario usuario) {
					
			try {
				Connection conn = ConnectaMysql.obterConexao();
				
				String queryInserir = "DELETE FROM usuario WHERE id = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryInserir);	
				
				ppStm.setInt(1, usuario.getId());
				
				ppStm.executeUpdate();
				
				conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;
	
	}
	public ArrayList<Usuario> buscarTodosUsuarios(){
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
			
			Usuario usr = null;
			
			try {
					Connection conn = ConnectaMysql.obterConexao();
					
					String queryInserir = "SELECT * FROM usuario ";
					
					PreparedStatement ppStm = conn.prepareStatement(queryInserir);	
					
								
					ResultSet rSet = ppStm.executeQuery();
					
				    while(rSet.next()) {
				    	
				    	usr = new Usuario();
				    	
				    	usr.setId(rSet.getInt(1));
				    	usr.setNomeProprietario(rSet.getString(2));
				    	usr.setNomeFazenda(rSet.getString(3));
				    	usr.setPlantio(rSet.getString(4));
				    	usr.setEndereco(rSet.getString(5));
				    	usr.setTelContato(rSet.getString(6));
				    	usr.setArea(rSet.getInt(7));
				    	
				    	
				    	lista.add(usr);
				    	
				    }
					
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lista;
	}
	
	public Usuario buscarUsuarioPorId(int id) {
		
		Usuario usr = null;
		
		try {
				Connection conn = ConnectaMysql.obterConexao();
				
				String queryInserir = "SELECT * FROM usuario WHERE id = ?";
				
				PreparedStatement ppStm = conn.prepareStatement(queryInserir);	
				
				ppStm.setInt(1, id);
				
				ResultSet rSet = ppStm.executeQuery();
				
			    if(rSet.next()) {
			    	
			    	usr = new Usuario();
			    	
			    	usr.setId(rSet.getInt(1));
			    	usr.setNomeProprietario(rSet.getString(2));
			    	usr.setNomeFazenda(rSet.getString(3));
			    	usr.setPlantio(rSet.getString(4));
			    	usr.setEndereco(rSet.getString(5));
			    	usr.setTelContato(rSet.getString(6));
			    	usr.setArea(rSet.getInt(7));
			    	
			    }else {
			    	
			    	return usr;
			    }
				
				conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
				return usr;
			}
			
		
		return usr;
	}
	
	public boolean excluirUsuarioid (int id) {
		return excluirUsuario (new Usuario (id, "", "", "", "", "",0));
			
	} 
}
