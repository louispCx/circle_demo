import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

// Class Declaration
class Login
{
    public static void main(String[] args)   
    {
        try {
            String email = request.getParameter("email");
            String token = request.getParameter("password");


            String sql = "select * from users where (email ='" + email +"' and password ='" + token + "')";
            //String sql = "select * from users where (email = ? and password = ?)";

            Connection connection = pool.getConnection();
            Statement statement = connection.createStatement();
            //PreparedStatement statement = connection.preparedStatement(sql);
            //statment.setString(1, email);
            //statment.setString(2, token);

            HttpSession session = request.getSession();
            String role = (String)session.getAttribute("role");
            if (role.equals(ADMIN)) {
                ResultSet result = statement.executeQuery(sql);
                //ResultSet result = statement.executeQuery();

                statement.close();
                connection.close();
            }

            if (result.next()) {
                loggedIn = true;
                // Successfully logged in and redirect to user profile page
            
            } else {
             // Auth failure - Redirect to Login Page
            }
        }
        catch (SQLException ex) {
            handleExceptions(ex);
        }
        finally {
            statement.close();
            connection.close();
        }
    }
} 
