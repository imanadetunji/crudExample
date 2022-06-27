/* JDBCTemplate gets rid of some disadvantages of JDBC */
package main.java.com.iman;

import main.java.com.iman.jdbctemplate.ChildRowMapper;
import main.java.com.iman.jdbctemplate.ParentRowMapper;
import main.java.com.iman.model.Child;
import main.java.com.iman.model.Parent;
import main.java.com.iman.script.DBHelper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class JdbcTemplateMain {
    //public static DriverManagerDataSource con = new DriverManagerDataSource();
    public static JdbcTemplate jdbcTemplate ;
    public static void main(String[] args) {

        jdbcTemplate = getConnectedJdbcTemplate();

        JdbcTemplateMain main = new JdbcTemplateMain();
        main.getParents();
        //main.getAllChildren();
    }

    public static JdbcTemplate getConnectedJdbcTemplate() {
        DriverManagerDataSource con = new DriverManagerDataSource();
        con.setDriverClassName("com.mysql.cj.jdbc.Driver");
        con.setUrl("jdbc:mysql://localhost:3306/mydb?useSSL=false");
        con.setPassword("FineFurryFriends@4626");
        con.setUsername("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(con);

        return jdbcTemplate;

    }

    // SELECT * FROM Parents;
    private List<Parent> getParents(){
        // run query, mapping each row to a result object using row mapper
        List<Parent> parentList = jdbcTemplate.query(DBHelper.PARENT_SELECT_QUERY, new ParentRowMapper());

        // this is equivalent to for loop
        parentList.forEach( p -> {
            // add list of children to parent object
            List<Child> childList = getChildren(p);
            p.setChildren(childList);
            System.out.println(p);
        });


        return parentList;
    }

    // get children for a specific parent
    public List<Child> getChildren(Parent p) {
        List<Child> children = jdbcTemplate.query(DBHelper.
                CHILDREN_PER_PARENT_QUERY, new ChildRowMapper(), p.getId());
        return children;
    }

    // SELECT * FROM Children;
    public List<Child> getAllChildren() {
        List<Child> childList = jdbcTemplate.query(DBHelper.CHILD_SELECT_QUERY, new ChildRowMapper());

        childList.forEach(child -> {
            System.out.println(child);
        });
        return childList;
    }

    // return parent for a specific child
    public Parent getParent(int parentId){
        Parent p = (Parent) jdbcTemplate.
                queryForObject(DBHelper.PARENT_BY_ID_QUERY, new ParentRowMapper(), parentId);
        return p;
    }
}
