
//package ConexionJDBC;
//lIBRERIAS IMPORTADAS
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//DESIGNACION DE VARIABLES Y CONEXION CON LA BASE DE DATOS MARIADB
public class ConexionJDBC {
	
	public static void main(String[] args) {
		
		String usuario = "root";
		String password = "Andres030191.";
		String url = "jdbc:mariadb://localhost:3306/db_cafeteria";
		Connection conexion;
		Statement statement;
		ResultSet rs;
	
		//INTEGRACION DEL DIVER MARIADB Y WAFFLE
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//METODOS PARA LLAMAR AL DRIVER MANAGER, MODIFICAR LA TABLA Y MOSTRAR ELEMENTOS
		try {
		conexion = DriverManager.getConnection(url,usuario, password);
		statement = conexion.createStatement();
		statement.executeUpdate("INSERT USUARIOS(NOMBRE, EMAIL, TIPOUSUARIO, PASSWORD, TELEFONO, CURSO) VALUES('ANDRESGARCIA', 'AANDS@SKD.SC', '2', '1234456', '311283773', 'SEPTIPO')");
		rs = statement.executeQuery("SELECT * FROM USUARIOS");
		rs.next();
		
		do {
			
			System.out.println(rs.getInt("id_user")+ ":" + rs.getString("nombre"));
		}while(rs.next());
		
		
		
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		
	}
}