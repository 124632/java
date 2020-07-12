package com.xworks.wish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.hql.spi.id.AbstractMultiTableBulkIdStrategyImpl.PreparationContext;

import com.mysql.jdbc.PreparedStatement;

public class WishesDAO {
	public boolean saveWishes(String personName,String greetings) {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			String query ="INSERT INTO greetings_table VALUES(?,?)";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_connection","root","root123");
			
			statement=  (PreparedStatement) connection.prepareStatement(query);
			
			statement.setString(1, personName);
			statement.setString(2, greetings);
			
		    statement.executeUpdate();
		    return true;
		  }catch(ClassNotFoundException | SQLException e) {
			  e.printStackTrace();
		  }finally {
			  try {
				  if(statement !=null)
					  statement.close();
				  if(connection !=null)
					  connection.close();
			  }catch(SQLException e) {
				  e.printStackTrace();
			  }
		  }
		return false;
	}

}
