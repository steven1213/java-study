package com.steven.design.pattern.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Objects;

@Slf4j
public class JDBCSingleton {

    // step 1
    // create a jdbcSingleton class
    // static member holds only one instance of jdbcSingleton class
    private static JDBCSingleton jdbc;

    // JDBCSingleton prevent the instantiation from any other class
    private JDBCSingleton() {
    }

    // now we are providing global point of access
    public static JDBCSingleton getInstance() {
        if (Objects.isNull(jdbc)) {
            jdbc = new JDBCSingleton();
        }
        return jdbc;
    }

    // to get the connection from methods like insert.view etc.
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        return connection;
    }

    //to insert the record into the database
    public int insert(String name, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int readCounter = 0;
        try {
            conn = JDBCSingleton.getConnection();
            ps = conn.prepareStatement("insert into userdata(uname,upassword)values(?,?)");
            ps.setString(1, name);
            ps.setString(2, password);
            readCounter = ps.executeUpdate();
        } catch (Exception ex) {
            log.error("insert record exception:", ex);
        } finally {
            if (Objects.isNull(ps)) {
                ps.close();
            }
            if (Objects.isNull(conn)) {
                conn.close();
            }
        }
        return readCounter;
    }

    //to view the data from the database
    public void view(String name) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con = JDBCSingleton.getConnection();
            ps = con.prepareStatement("select * from userdata where uname=?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                log.info("Name={},Password={}", rs.getString(2), rs.getString(3));
            }

        } catch (Exception e) {
            log.error("view exception:", e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    // to update the password for the given username
    public int update(String name, String password) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        int recordCounter = 0;
        try {
            c = JDBCSingleton.getConnection();
            ps = c.prepareStatement(" update userdata set upassword=? where uname='" + name + "' ");
            ps.setString(1, password);
            recordCounter = ps.executeUpdate();
        } catch (Exception e) {
            log.error("update exception:", e);
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return recordCounter;
    }

    // to delete the data from the database
    public int delete(int userid) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        int recordCounter = 0;
        try {
            c = JDBCSingleton.getConnection();
            ps = c.prepareStatement(" delete from userdata where uid='" + userid + "' ");
            recordCounter = ps.executeUpdate();
        } catch (Exception e) {
            log.error("delete exception:", e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return recordCounter;
    }
}
