/* assert all: assertNotNull and length > 0 */
package test.java.com.iman;

import main.java.com.iman.JdbcTemplateMain;
import main.java.com.iman.model.Child;
import main.java.com.iman.model.Parent;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JdbcTemplateMainTest {

    @Test
    void getParents(){
        //given
        JdbcTemplateMain jdbcTemplateMain = new JdbcTemplateMain();
        //when
        List<Parent> parentsList = jdbcTemplateMain.getParents();
        //then
        assertAll( () -> assertNotNull(parentsList),
                () -> assertTrue(parentsList.size() > 0));
    }

    @Test
    void getChildrenPerParent() {
        //given
        Parent p = new Parent();
        p.setId(1006);
        JdbcTemplateMain jdbcTemplateMain = new JdbcTemplateMain();

        //when
        List<Child> children = jdbcTemplateMain.getChildrenPerParent(p);
        //then
        assertAll( () -> assertNotNull(children),
                () -> assertTrue(children.size() > 0));

    }

    @Test
    void getAllChildren() {
        // given
        JdbcTemplateMain jdbcTemplateMain = new JdbcTemplateMain();
        //when
        List<Child> children = jdbcTemplateMain.getAllChildren();
        //then
        assertAll( () -> assertNotNull(children),
                () -> assertTrue(children.size() > 0));
    }

    @Test
    void getParentGivenId(){
        //given
        JdbcTemplateMain jdbcTemplateMain = new JdbcTemplateMain();
        Child halle = new Child();
        Parent john = new Parent();
        john.setId(1000);
        halle.setParent(john);
        //when
        Parent p = jdbcTemplateMain.getParentGivenId(john.getId());
        //then
        assertAll( () -> assertNotNull(p), () -> assertTrue(halle.getParent() == john));
    }
}

