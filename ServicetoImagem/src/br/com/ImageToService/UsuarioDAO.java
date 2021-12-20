package br.com.ImageToService;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class UsuarioDAO {
	String valor;
	String convertendoNome;
	String nomeConvertido;
	

	public int inserirUsuario(Usuario usuario) {
		
		

		try {
			Connection conn = Conexao.obterConexao();
			String sqlSelect = "INSERT INTO usuario VALUES (null, ?, ?, ?, ?,?)";
			PreparedStatement stmt = null;

			stmt = conn.prepareStatement(sqlSelect,	Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getData());
			stmt.setBytes(3, usuario.getFoto());
			stmt.setString(4, usuario.getTipoNota());
			BigDecimal valor = new BigDecimal(usuario.getValorNota());
			stmt.setBigDecimal(5, valor);
			//stmt.setBigDecimal(5, valor);
			//stmt.setString(5, usuario.getValorNota());
			//stmt.setBigDecimal(5, usuario.getTesteBigDecimal());

			int affectedRows = stmt.executeUpdate();
			
			if (affectedRows == 0) {
				return -1;
			}

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return (int) generatedKeys.getLong(1);
				} else {
					return -1;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}

	public Usuario buscaUsuarioPorId(int id) {

		Usuario usuario = new Usuario();
		try {
			Connection conn = Conexao.obterConexao();
			String sqlSelect = "SELECT * FROM usuario WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlSelect);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				usuario.setId(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setData(rs.getString(3));
				usuario.setFoto(rs.getBytes(4));
			} else {
				return null;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return usuario;
	}
	
	
	public ArrayList<Usuario> buscarTodosUsuarios(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			Connection conn = Conexao.obterConexao();
			String queryInserir = "SELECT * FROM usuario";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);

			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Usuario usr = new Usuario();
				
				usr.setId(rSet.getInt(1));
				usr.setNome(rSet.getString(2));
				usr.setData(rSet.getString(3));
				usr.setFoto(rSet.getBytes(4));
				lista.add(usr);
				
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public boolean excluirUsuario(int id){
		try {
			Connection conn = Conexao.obterConexao();
			String queryInserir = "DELETE FROM usuario WHERE id = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			ppStm.setInt(1, id);
			
			ppStm.executeUpdate();
		
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean salvarPDF(){
	    //busca uma conexao com o banco
	    File f = null;
	  //  Usuario usuario = new Usuario();
	    
	    try {
	    	Connection conn = Conexao.obterConexao();
	    	String queryInserir = ("SELECT id, nome, data, foto, tiponota FROM usuario ORDER BY id DESC LIMIT 1");
	        PreparedStatement ppStm = conn.prepareStatement(queryInserir);
	      //  ppStm.setInt(1, id);
	        ResultSet rs = ppStm.executeQuery();
	        if ( rs.next()){
	        	//passa o array de bytes e salva em uma variável byte
	            byte [] bytes = rs.getBytes("foto");
	           String nome = rs.getString("nome");
	           String tiponota = rs.getString("tiponota");

	            //converte o array de bytes em file
	            Usuario Nome = new Usuario();
	            //converte objeto em String
	            convertendoNome = String.valueOf(Nome);
	            //retira a sequência br.com.ImageToService.Usuario da String.
	            nomeConvertido = convertendoNome.replace("br.com.ImageToService.Usuario", " ");
	            
	            
	            f = new File( "C:\\Users\\TULIU\\OneDrive\\Área de Trabalho\\PDF\\"
	            					+ nome +"\\"+ tiponota + nomeConvertido +".pdf");
	            FileOutputStream fos = new FileOutputStream( f);
	            fos.write( bytes );
	            fos.close();
	        } else {
	        	return false;
	        }
	        rs.close();
	        ppStm.close();
	        conn.close();
	    } catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	

	public boolean salvarDiretorio(){
	    //busca uma conexao com o banco
	    File f = null;
	  //  Usuario usuario = new Usuario();
	    
	    try {
	    	Connection conn = Conexao.obterConexao();
	    	String queryInserir = ("SELECT id, nome FROM usuario ORDER BY id DESC LIMIT 1");
	        PreparedStatement ppStm = conn.prepareStatement(queryInserir);
	      //  ppStm.setInt(1, id);
	        ResultSet rs = ppStm.executeQuery();
	        if ( rs.next()){
	           String nome = rs.getString("nome");
	           // CRIA O DIRETÓRIO
	            f = new File( "C:\\Users\\TULIU\\OneDrive\\Área de Trabalho\\PDF\\"+nome);
	            f.mkdir();
	            
	        } else {
	        	return false;
	        }
	        rs.close();
	        ppStm.close();
	        conn.close();
	    } catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	  
	    public void salvaFotoURL( String[] args ) {
	        BufferedImage image = null;
	        try {
	           
	            URL url = new URL("https://media.kasperskydaily.com/wp-content/uploads/sites/94/2020/03/11181335/36C3-PDF-encryption-featured2.jpg");
	            image = ImageIO.read(url);
	             
	            ImageIO.write(image, "jpg",new File("C:\\Users\\TULIU\\\\OneDrive\\Área de Trabalho\\PDF\\out.jpg"));
	           // ImageIO.write(image, "gif",new File("C:\\out.gif"));
	           // ImageIO.write(image, "png",new File("C:\\out.png"));
	             
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Done");
	    }
	
	
	
}