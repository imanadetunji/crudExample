package main.java.com.iman.jdbctemplate;


import main.java.com.iman.JdbcTemplateMain;
import main.java.com.iman.model.Child;
import main.java.com.iman.model.Parent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ParentRowMapper implements RowMapper {

    @Override
    public Parent mapRow(ResultSet rs, int rowNum) throws SQLException {
        ParentResultSetExtractor rse = new ParentResultSetExtractor();
        Parent p = rse.extractData(rs);

        return p;
    }

    private List<Child> getChildren(Parent p) {
        return new JdbcTemplateMain().getChildrenPerParent(p);
    }
}
