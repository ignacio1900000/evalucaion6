package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class sqlPersona extends conexion{
	
		public boolean Ingresar(persona usr){
			
			PreparedStatement ps = null;
			Connection con = getConexion();
			
			String sql = "INSERT INTO persona(rut, nombre, apellido, password, telefono) VALUES(?,?,?,?,?)";
			
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, usr.getRut());
				ps.setString(2, usr.getNombre());
				ps.setString(3, usr.getApellido());
				ps.setString(4, usr.getPassword());
				ps.setString(5, usr.getTelefono());
				ps.execute();
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
			
		}
}
