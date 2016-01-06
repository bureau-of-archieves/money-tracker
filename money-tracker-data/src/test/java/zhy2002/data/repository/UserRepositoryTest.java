package zhy2002.data.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zhy2002.moneytracker.data.DataConfig;
import zhy2002.moneytracker.data.repository.UserRepository;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Test user repository.
 */
@SpringApplicationConfiguration(DataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1(){

        assertThat(userRepository, notNullValue());

    }

}
