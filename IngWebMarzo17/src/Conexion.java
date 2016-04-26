import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	
	public static void main(String[] args){
		consultarCiudades();
		insertarCiudad(15, "Marinilla","4");
	}
	
	public static void consultarCiudades(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase",
					"root","");
			ps = con.prepareStatement("SELECT * FROM ciudades");
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println("Codigo: " + rs.getLong("codigo"));
				System.out.println("Nombre: " + rs.getString("Nombre"));
				System.out.println("CodigoArea: " + rs.getString("CodigoArea"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}

	public static void insertarCiudad(long codigo, String nombre, String codigoArea){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase",
					"root","");
			ps = con.prepareStatement("INSERT INTO ciudades (codigo, Nombre, CodigoArea)"
					+ "VALUES(?,?,?);");
			ps.setLong(1, codigo);
			ps.setString(2, nombre);
			ps.setString(3, codigoArea);
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}
}
