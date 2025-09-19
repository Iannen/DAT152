package no.hvl.dat152.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import no.hvl.dat152.database.DatabaseHelper;



@WebListener
public class MyContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent arg0)  { 
    System.out.println("Application is started. The database will be created if it does not exist.");
    setupDB();
    initAuthorTable();
  }

  @Override
  public void contextDestroyed(ServletContextEvent arg0)  { 
    System.out.println("Application was stopped.");    
  }
  
  private void setupDB() {
    try (
        Connection conn = DatabaseHelper.getConnection();
        Statement st = conn.createStatement();
        ){
      try {
        st.executeUpdate("create schema Lib");
        System.out.println("Schema Lib was created.");
      } catch (Exception e) {
        System.out.println(e.toString());
      }

      try {
          st.executeUpdate("CREATE TABLE Lib.Authors ("
          	+ "authorid INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
          	+ "firstname VARCHAR(50),"
            + "lastname VARCHAR(50),"
            + "PRIMARY KEY (authorid))");
         System.out.println("Table Lib.Authors was created.");
	  } catch (Exception e) {
	     System.out.println(e.toString());
      }
      
      try {
       st.executeUpdate("CREATE TABLE Lib.Books ("
           + "isbn VARCHAR(50) UNIQUE,"
           + "title VARCHAR(50),"
           + "authorid INT,"
           + "PRIMARY KEY (isbn, authorid),"
           + "FOREIGN KEY (authorid) REFERENCES Lib.Authors(authorid))");
        System.out.println("Table Lib.Books was created.");
      } catch (Exception e) {
        System.out.println(e.toString());
      }

    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
  
  private void initAuthorTable() {
	  String sql = "INSERT INTO Lib.Authors (firstname, lastname) VALUES "
			  + "('Shari', 'Pfleeger'), "  
			  + "('Perry', 'Lea'), "
		      + "('James', 'Kurose'), "
		      + "('Keith', 'Ross'),"
		      + "('Martin', 'Kleppmann')";
	  
	  System.out.println("Table Lib.Authors initialised with default authors.");
	  Connection c = null;
	  Statement s = null;
	  ResultSet r = null;

	  try {        
		  c = DatabaseHelper.getConnection();
		  s = c.createStatement();       
		  s.executeUpdate(sql);

	  } catch (Exception e) {
		  System.out.println(e);
	  } finally {
		  DatabaseHelper.closeConnection(r, s, c);
	  }
  }
}
