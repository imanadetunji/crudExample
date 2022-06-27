/* Extracts objects from result set */
package main.java.com.iman.jdbctemplate;

import main.java.com.iman.model.Parent;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParentResultSetExtractor implements ResultSetExtractor {
    @Override
    public Parent extractData(ResultSet rs) throws SQLException, DataAccessException {
        Parent parent = new Parent();
        parent.setId(rs.getInt(1));
        parent.setFirstName(rs.getString(2));
        parent.setLastName(rs.getString(3));
        parent.setDateOfBirth(rs.getDate("DateOfBirth"));
        parent.setGender(rs.getString("Gender"));

        return parent;
    }
}
