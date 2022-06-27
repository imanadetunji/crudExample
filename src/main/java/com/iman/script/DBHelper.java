package main.java.com.iman.script;

public class DBHelper {
    public static final String DATABASE_CONNECTION_URL = "jdbc:mysql://localhost:3306/mydb";

    public static final String PARENT_SELECT_QUERY = "select * from Parents";
    public static final String CHILD_SELECT_QUERY = "select * from Child";
    public static final String CHILD_QUERY_WITH_PARENT_NAMES =
            "SELECT Parents.FirstName AS PFirst, Parents.LastName AS PLast, Child.ParentID," +
            "Child.ChildID, " +
            "Child.FirstName," +
            "Child.LastName, Child.DateOfBirth, Child.Gender FROM Parents" +
            " INNER JOIN Child on ID = ParentID";

    public static final String PARENT_QUERY_WITH_CHILDREN =
            "SELECT Parents.ID, Parents.FirstName, Parents.LastName, Parents.DateOfBirth, Parents.Gender," +
            " Child.ChildID, Child.FirstName AS CFirst," +
            " Child.LastName AS CLast, Child.DateOfBirth AS CDoB, Child.Gender AS CGender" +
            " FROM Parents LEFT JOIN Child ON Parents.ID = Child.ParentID";

    public static final String CHILDREN_PER_PARENT_QUERY = "SELECT * FROM Child WHERE ParentID = ?";

    public static final String INSERT_PARENT_QUERY = " INSERT INTO Parents(FirstName, LastName, DateOfBirth, Gender) " +
            "VALUES (\"Iman\", \"Adetunji\", \"1999-06-16\", \"Female\");";
    public static final String INSERT_CHILD_QUERY = " INSERT INTO Child(ChildID, ParentID, FirstName, LastName, DateOfBirth, Gender) " +
            "VALUES (\"510\", \"1010\", \"Jasmine\", \"Sullivan\", \"1995-09-28\", \"Female\");";
    public static final String PARENT_BY_ID_QUERY = "SELECT * FROM Parents WHERE ID = ?";
}
