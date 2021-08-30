package Control;

import java.sql.PreparedStatement;

public class Producto {

	private Producto() {
	}

	public static String insert(String nombre, String descripcion, int idCategoria, int idFabricante, int ean, String usos, int peso, String dimension,int calibre ) {

	        StringBuilder mensaje = new StringBuilder();
	        Connection connection = BD.getConexion();

	        String query = "INSERT INTO producto (nombre, descripcion, idCategoria, idFabricante, ean, usos, peso, dimension, calibre ) VALUES (?,?,?,?,?,?,?,?,?)";

	        if (connection != null) {

	            try ( PreparedStatement consulta = connection.prepareStatement(query)) {

	                consulta.setString(1, nombre);
	                consulta.setString(2, descripcion);
	                consulta.setInt(3, idCategoria);
	                consulta.setInt(4, idFabricante);
	                consulta.setInt(5, ean);
	                consulta.setString(6, usos);
	                consulta.setInt(7, peso);
	                consulta.setString(8, dimension);
	                consulta.setInt(9,calibre);	                

	              int nuevoProducto = consulta.executeUpdate();
	                if (nuevoProducto > 0) {
	                	mensaje.append("Se ha insertado el producto con éxito");
	                
	            }else {
	            	 mensaje.append("ERROR. No se ha insertado ningún producto");
	            } catch (SQLException sqle) {
	                mensaje.append("ERROR. No se ha insertado el producto");
	            }
	        }
	        return mensaje.toString();

	    }
