package dbConnect;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public DBConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/game", "root", "psr-e323");
			statement = connection.createStatement();
		}catch(Exception e){
			System.out.println("Erro: " + e);
		}
	}
	
	public ArrayList<String> getSelect() throws SQLException{
		String query = "SELECT * FROM user ORDER BY point DESC";
		ArrayList<String> al = new ArrayList<String>();
		resultSet = statement.executeQuery(query);
		System.out.println("Records: ");
		while(resultSet.next()){
			String name = resultSet.getString("name");
			String point = resultSet.getString("point");
			String retorno = ("User: " + name + "     " + "Pontos: " + point);
			al.add(retorno);
		}
		if(al.size() == 0){
			al.add("Nenhum recorde salvo!");
		}
		return al;
	}
	
	public void insertData(String userName, int p) throws SQLException{
		String query = "INSERT INTO user (id, name, point)" + "VALUES (?, ?, ?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt (1, 0);
		preparedStmt.setString (2, userName);
		preparedStmt.setInt (3, p);
		preparedStmt.execute();
	}

	public void closeConnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
