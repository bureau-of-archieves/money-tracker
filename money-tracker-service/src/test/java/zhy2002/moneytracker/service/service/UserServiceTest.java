package zhy2002.moneytracker.service.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zhy2002.moneytracker.domain.User;
import zhy2002.moneytracker.service.AbstractServiceTest;

/**
 *
 */
public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){


        User user = new User();
        user.setUsername("test user 1");
        user.setPassword("password");




    }
}
