package main.java.com.iman.jdbctemplate;

import main.java.com.iman.JdbcTemplateMain;
import main.java.com.iman.model.Child;
import main.java.com.iman.model.Parent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChildRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        ChildResultSetExtractor rse = new ChildResultSetExtractor();
        Child c = rse.extractData(rs);

        int parentId = rs.getInt("ParentID");
        // add parent to child object
        Parent p = getParent(parentId);
        c.setParent(p);
        return c;
    }
    private Parent getParent(int parentId) {
        return new JdbcTemplateMain().getParent(parentId);
    }
}
