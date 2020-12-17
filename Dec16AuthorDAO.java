package spring01;
import java.sql.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author F. Ulstack
 * Simple table DAO, inject system properties
 */

@Component
public class AuthorDAO
{
    @Value("${database.url}")
    String url;

    @Value("${database.schema}")
    String database;
    
    @Value("${database.user}")
    String userName;
    
    @Value("${database.password}")
    String password;
    
    private Connection conn;
    
    public Author getAuthorById(int authorId) throws SQLException
    {
        String sql = "SELECT * FROM author Where authorId=?";
        PreparedStatement prepareStatement = conn.prepareStatement(sql);
        prepareStatement.setInt(1, authorId);
        ResultSet resultSet = prepareStatement.executeQuery();
        
        Author author = null;
        if (resultSet.next())
        {
            Author = new Author();
            author.setId(resultSet.getInt("authorId"));
            author.setName(resultSet.getString("authorName"));
        }
        
        return author;
    }    
    
    @PostConstruct
    private void initConn()
    {
        try
        {
            conn = DriverManager.getConnection(url + database, userName, password);
            System.out.println("connected");
        }
        catch (Exception e)
        {
            System.out.println("database connection failed");
            e.printStackTrace();
        }        
    }
    
    @PreDestroy
    private void closeConn() throws SQLException
    {
        if (conn != null) conn.close();
    }
    
}
