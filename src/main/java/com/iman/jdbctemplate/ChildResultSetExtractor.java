/* Extracts objects from result set */
package main.java.com.iman.jdbctemplate;

import main.java.com.iman.model.Child;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChildResultSetExtractor implements ResultSetExtractor {
    @Override
    public Child extractData(ResultSet rs) throws SQLException, DataAccessException {
        Child child = new Child();
        child.setChildId(rs.getInt("ChildID"));
        //child.setParent(rs.getObject("ParentID", Parent.class));
        child.setFirstName(rs.getString("FirstName"));
        child.setLastName(rs.getString("LastName"));
        child.setDateOfBirth(rs.getDate("DateOfBirth"));
        child.setGender(rs.getString("Gender"));

        return child;
    }
}
