package main.java.com.iman.jdbc;

import main.java.com.iman.model.Child;
import main.java.com.iman.model.Parent;
import main.java.com.iman.script.DBHelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper {
    Logger logger = LogManager.getLogger(JdbcHelper.class);

    public void connectAndPrint() throws SQLException {
        List<Parent> parents;
        try (Connection con = getConnection()) {
            parents = getAllParents(con);

            for (Parent p : parents) {
                List<Child> children = getChildren(p, con);
                p.setChildren(children);
            }
            printData(parents);
            //TODO: addParentOrChild(con,"parent");
            //TODO: addParentOrChild(con,"child");
        } catch (Exception e) {
            logger.error("An exception occurred", e);
        }
    }

    private void printData(List<Parent> parents) {
        for (Parent p: parents){
            System.out.println(p.getFirstName() + " " +p.getLastName());
            for (Child c: p.getChildren()){
                System.out.println("    " + c.getFirstName() +" " + c.getLastName());
            }
        }
    }

    private List<Child> getChildren(Parent parent, Connection con) throws SQLException{
        // connect to database, make statement

        logger.debug("Connection to database Successful");
        PreparedStatement stmt = con.prepareStatement(DBHelper.CHILDREN_PER_PARENT_QUERY);
        stmt.setInt(1, parent.getId());
        logger.info("An sql statement successfully created");
        ResultSet rs = stmt.executeQuery();

        List<Child> children = new ArrayList<>();

        while(rs.next()){
            Child child = new Child();
            child.setChildId(rs.getInt("ChildID"));
            child.setGender(rs.getString("Gender"));
            child.setFirstName(rs.getString("FirstName"));
            child.setLastName(rs.getString("LastName"));
            child.setDateOfBirth(rs.getDate("DateOfBirth"));
            child.setParent(parent);
            children.add(child);
        }
        logger.info("Query returned " + children.size() + " record(s) for " + parent.getFirstName());
        return children;
    }

    // establishes connection to database
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con;
        String user = "root";
        String pass = "FineFurryFriends@4626";
        // loads driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(DBHelper.DATABASE_CONNECTION_URL, user, pass);
        return con;
    }

    // getAllParents() -- runs select * from parents query, adding results to a list, returns the list of parents
    private List<Parent> getAllParents(Connection con) throws SQLException{
        Statement stmt = con.createStatement();
        logger.info("an sql statement successfully created");
        ResultSet rs = stmt.executeQuery(DBHelper.PARENT_SELECT_QUERY);

        logger.info("query executed successfully");
        List<Parent> parentList = new ArrayList<>();

        while (rs.next()) {
            Parent parent = new Parent();
            parent.setId(rs.getInt(1));
            parent.setFirstName(rs.getString(2));
            parent.setLastName(rs.getString(3));
            parent.setDateOfBirth(rs.getDate("DateOfBirth"));
            parent.setGender(rs.getString("Gender"));

            parentList.add(parent);

        }
        return parentList;
    }

    private void addParentOrChild(Connection con, String discrim) throws SQLException {
        Statement stmt = con.createStatement();
        logger.info("an sql statement successfully created");
        int hasExecuted = 0;
        if (discrim.equals("parent"))
            hasExecuted = stmt.executeUpdate(DBHelper.INSERT_PARENT_QUERY);
        else
            hasExecuted = stmt.executeUpdate(DBHelper.INSERT_CHILD_QUERY);

        System.out.println("***** " + hasExecuted + " *****");
        if (hasExecuted > 0)
            logger.info("query executed successfully");
        else
            logger.info("query not executed. an error has occurred.");
    }

}
