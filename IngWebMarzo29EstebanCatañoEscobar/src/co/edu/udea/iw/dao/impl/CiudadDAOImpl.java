package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.util.exception.MyException;

/**
 * Implementación de la interfaz CiudadDAO
 * @author Esteban Cataño Escobar
 * @version 1
 */
public class CiudadDAOImpl implements CiudadDAO{

	@Override
	public void insertar(Ciudad ciudad) throws MyException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		DataSource ds = new DataSource();
		try{
			// Se obtiene la conexión del objeto DataSource
			con = ds.getConnection();
			// Se prepara la consulta a la base de datos
			ps = con.prepareStatement("INSERT INTO ciudades (codigo, Nombre, "
					+ "CodigoArea)VALUES(?,?,?);");
			ps.setLong(1, ciudad.getCodigo());
			ps.setString(2, ciudad.getNombre());
			ps.setString(3, ciudad.getCodigoArea());
			// Se ejecuta la consulta;
			ps.execute();
		}catch(SQLException sqle){
			throw new MyException(sqle);
		}finally {
			try{
				if (ps != null) {
					ps.close();
				}
				if (con != null){
					con.close();
				}
			}catch(SQLException sqle){
				throw new MyException(sqle);
			}
		}
	}

	@Override
	public List<Ciudad> obtener() throws MyException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		DataSource ds = new DataSource();
		try{
			// Se obtiene la conexión del objeto DataSource
			con = ds.getConnection();
			// Se prepara la consulta a la base de datos
			ps = con.prepareStatement("SELECT * FROM ciudades");
			// Se ejecuta la consulta;
			rs = ps.executeQuery();
			// Se recorre el result set mientras tenga objetos
			while(rs.next()){
				// Se crea el objeto ciudad y se le setean los datos del result set
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
				// Se agrega a la lista de ciudades que se va a retornar
				ciudades.add(ciudad);
			}
		}catch(SQLException sqle){
			throw new MyException(sqle);
		}finally {
			try{
				// Se cierra los elementos utilizados
				if(rs != null){
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null){
					con.close();
				}
			}catch(SQLException sqle){
				throw new MyException(sqle);
			}
		}
		// Se retorna la lista de ciudades
		return ciudades;
	}

	@Override
	public void modificar(Ciudad ciudad) throws MyException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		DataSource ds = new DataSource();
		try{
			// Se obtiene la conexión del objeto DataSource
			con = ds.getConnection();
			// Se prepara la consulta a la base de datos
			ps = con.prepareStatement("UPDATE ciudades "
					+ "SET Nombre = ?, CodigoArea = ? "
					+ "WHERE codigo = ?");
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, ciudad.getCodigoArea());
			ps.setLong(3, ciudad.getCodigo());
			// Se ejecuta la consulta;
			ps.execute();
		}catch(SQLException sqle){
			throw new MyException(sqle);
		}finally {
			try{
				if (ps != null) {
					ps.close();
				}
				if (con != null){
					con.close();
				}
			}catch(SQLException sqle){
				throw new MyException(sqle);
			}
		}

	}

	@Override
	public void eliminar(Ciudad ciudad) throws MyException {
		Connection con = null;
		PreparedStatement ps = null;
		DataSource ds = new DataSource();
		try{
			// Se obtiene la conexión del objeto DataSource
			con = ds.getConnection();
			// Se prepara la consulta a la base de datos
			ps = con.prepareStatement("DELETE FROM ciudades "
					+ "WHERE codigo = ?;");
			ps.setLong(1, ciudad.getCodigo());
			// Se ejecuta la consulta;
			ps.execute();
		}catch(SQLException sqle){
			throw new MyException(sqle);
		}finally {
			try{
				if (ps != null) {
					ps.close();
				}
				if (con != null){
					con.close();
				}
			}catch(SQLException sqle){
				throw new MyException(sqle);
			}
		}
	}

	@Override
	public Ciudad obtener(long codigo) throws MyException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Ciudad ciudad = new Ciudad();
		DataSource ds = new DataSource();
		try{
			// Se obtiene la conexión del objeto DataSource
			con = ds.getConnection();
			// Se prepara la consulta a la base de datos
			ps = con.prepareStatement("SELECT * FROM ciudades WHERE codigo = ?");
			ps.setLong(1, codigo);
			// Se ejecuta la consulta;
			rs = ps.executeQuery();
			// Se recorre el result set mientras tenga objetos
			if(rs.next()){
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
			}
		}catch(SQLException sqle){
			throw new MyException(sqle);
		}finally {
			try{
				// Se cierra los elementos utilizados
				if(rs != null){
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null){
					con.close();
				}
			}catch(SQLException sqle){
				throw new MyException(sqle);
			}
		}
		// Se retorna la ciudad
		return ciudad;

	}

}
