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
	                

	              /*  int nuevaPoliza = consulta.executeUpdate();
	                if (nuevaPoliza > 0) {
	                    mensaje.append(Color.dialogo("Se ha insertado la póliza número:010098 Titular:Filemón Pi Ramo:HOGAR Prima:350.00€"));
	                } else {
	                    mensaje.append(Color.error("ERROR no se puede insertar esa póliza."));
	            } catch (SQLException sqle) {
	                mensaje.append(Color.error("ERROR no se puede insertar esa póliza."));
	            }
	        }
	        return mensaje.toString();

	    }

}