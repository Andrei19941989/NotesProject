package example;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DbManager {


    private static final String URL = "jdbc:mysql://db:3306/notesdb?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            return conn;
        } catch (SQLException ex) {
            System.out.println("Connection failed!");
            ex.printStackTrace();
        }
        return null;
    }
    public static void createTableUsers(Connection con)
    {
        String s ="create table if not exists users (id int auto_increment primary key,"+
                "username varchar(32) unique not null,"+
                 "password varchar(32) not null)";
        try(Statement st=con.createStatement())
        {
            st.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void createTableNotes(Connection con)
    {
        String s ="create table if not exists notes (id int auto_increment primary key,"+
                "title varchar(32) unique not null,"+
                 "text varchar(32) unique not null,"+
                "userid int not null)";
        try(Statement st=con.createStatement())
        {
            st.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void AddUsers(User u)
    {
        String s ="insert into users (username,password) values (?,?)";
        try(PreparedStatement st= getConnection().prepareStatement(s))
        {
            st.setString(1, u.getUsername());
            st.setString(2,u.getPassword());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void AddNotes(Note n)
    {
        String s ="insert into notes (title,text,userid) values (?,?)";
        try(PreparedStatement st= getConnection().prepareStatement(s))
        {
            st.setString(1, n.getTitle());
            st.setString(2,n.getText());
            st.setInt(3,n.getUserid());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static List<User>GetUsers() {

        String s = "select * from users";
        try (Statement st = getConnection().createStatement()) {
            ResultSet r = st.executeQuery(s);
            ArrayList<User> List = new ArrayList<>();
            while (r.next()) {
                User u = new User(r.getString("username"), r.getString("password"));
                List.add(u);

            }
            return List;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    public static List<Note>GetNotes() {

        String s ="select * from notes";
        try(Statement st= getConnection().createStatement())
        {
            ResultSet r =st.executeQuery(s);
            ArrayList <Note>List=new ArrayList<>();
            while (r.next())
            {
                Note n =new Note(r.getString("title"),r.getString("text"),r.getInt("userid"));
                List.add(n);

            }
            return List;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
