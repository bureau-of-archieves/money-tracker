package zhy2002.data;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zhy2002.moneytracker.data.DataConfig;

/**
 * Base class for all repository test classes.
 */
@SpringApplicationConfiguration(DataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(false)
public abstract class AbstractRepositoryTest {
}
