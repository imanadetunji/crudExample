package test.java.com.iman;

import main.java.com.iman.JdbcTemplateMain;
import main.java.com.iman.jdbctemplate.ParentRowMapper;
import main.java.com.iman.script.DBHelper;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class JdbcTemplateMainTest {

    @Test
    void getParents(){
        //given
        JdbcTemplate jdbcTemplate = JdbcTemplateMain.getConnectedJdbcTemplate() ;

        //when

        //then
        assertNotNull(jdbcTemplate.query(DBHelper.PARENT_SELECT_QUERY, new ParentRowMapper()));

    }
}