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

        //when

        //then
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcTemplateMain.con);
//        JdbcTemplateMain.con.setUrl("jdbc:mysql://localhost:3306/mydb?useSSL=false");
        assertNotNull(jdbcTemplate.query(DBHelper.PARENT_SELECT_QUERY, new ParentRowMapper()));

    }
}