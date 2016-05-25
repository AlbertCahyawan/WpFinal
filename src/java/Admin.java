
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author albertcahyawan
 */
public class Admin {    
    private static final String DBURL = new String("jdbc:mysql://localhost:3306/wpbookstore");
    private static final String DBUserName = new String("root");
    private static final String DBPassword = new String("");
    
            
public void addUser(String Name,String Password, String Type) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "INSERT INTO user (UserName,Password,Logout,Type ) VALUES('"+Name+"','"+Password+"',NOW(),'"+Type+"')";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null, Name);

  }

}

public void UpdateUser (String Name,String Password, String ID) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "UPDATE User SET Name = '"+Name+"', Password = '"+Password+"'WHERE ID = '"+ID+"'";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null, Name);

  }

}


public void DeleteUser (int ID) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "DELETE FROM `user` WHERE `UserId` = "+ID+";";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null,ID);

  }

}

public void Logout (String Name,String Password, String ID) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "UPDATE User SET Date = Now() WHERE ID = '"+ID+"'";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null, Name);

  }

}

public boolean userVerification(String Name, String password) throws ClassNotFoundException{
        String query = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        boolean userExist = false;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        try {
            connection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
            statement = connection.createStatement();
            query = "SELECT * FROM webexercise";
            result = statement.executeQuery(query);
            
            while(result.next()){
                if(result.getString("Name").equals(Name) && result.getString("Password").equals(password)){
                    userExist = true;
                    
                        result.getInt("ID");
                }
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userExist;
    }

 
public void PostNews (String content, int UserId) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "INSERT INTO post (Content,Date,UserId ) VALUES('"+content+"',NOW(),'"+UserId+"')";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null, content);

  }

}

public void UpdatePost (String content, int ID) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "UPDATE post SET Content = '"+content+"'WHERE ID = '"+ID+"'";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null, content);

  }
}

public void DeletePost (int ID) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "DELETE FROM `post` WHERE `ID` = "+ID+";";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null,ID);

  }
}

public void Footer (String Facebook,String Twitter,String Address, String Phone) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "UPDATE post SET FacebookLink = '"+Facebook+"',TwitterLink = '"+Twitter+"',Address = '"+Address+"',PhoneNumber = '"+Phone+"'Where ID = 1";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null, Facebook);

  }
}

public void Comment (String content, int UserId) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "INSERT INTO post (Content,Date,UserId ) VALUES('"+content+"',NOW(),'"+UserId+"')";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null, content);

  }
}

public void DeleteComment (int ID) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "DELETE FROM `comment` WHERE `ID` = "+ID+";";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null,ID);

  }
}

public void AboutUS (String History, String Profile) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "UPDATE post SET History = '"+History+"',Profile = '"+Profile+"' Where ID = 1";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null, History);

  }
} 

public void AddProduct(String img,String BookName,String Description,String Genre) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "INSERT INTO books (Link,BookName,Description,Genre ) VALUES('"+img+"','"+BookName+"','"+Description+"','"+Genre+"')";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null, BookName);

  }

}

public void UpdateProduct (String img,String BookName,String Description,String Genre,int ID) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "UPDATE books SET Link = '"+img+"',BookName = '"+BookName+"',Description = '"+Description+"',Genre = '"+Genre+"'WHERE ID = '"+ID+"'";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null, BookName);

  }

}


public void DeleteProduct (int ID) throws ClassNotFoundException{

String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;

Class.forName("com.mysql.jdbc.Driver");
ResultSet db = null;

        try{
    optionalConnection = DriverManager.getConnection(DBURL,DBUserName,DBPassword);
    optionalStatement = optionalConnection.createStatement();
   
    optionalQuery = "DELETE FROM `books` WHERE `ID` = "+ID+";";
                    optionalStatement.executeUpdate(optionalQuery);                                     
}
  catch(Exception ex)
  {
      JOptionPane.showMessageDialog(null,ID);

  }

}



public static String getCompanyProfile() throws ClassNotFoundException{
String optionalQuery = null;
Connection optionalConnection = null;
Statement optionalStatement = null;
ResultSet optionalResult = null;

String article = null;

Class.forName("com.mysql.jdbc.Driver");
        try{
    optionalConnection = DriverManager.getConnection(DBURL, DBUserName, DBPassword);
    optionalStatement = optionalConnection.createStatement();
    
    optionalQuery = "SELECT * FROM 'companny_profile'";
    optionalResult = optionalStatement.executeQuery(optionalQuery);
    
    while(optionalResult.next())
    {
        article = optionalResult.getString("Article");
       
    }
}
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            article = null;
        }
        return article;
}


     
}
