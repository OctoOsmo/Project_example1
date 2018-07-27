package app.springboot.demo.dao;

import app.springboot.demo.jdo.AppUser;
import app.springboot.demo.utils.TestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

public class AppUserDaoStaticDataImpl implements AppUserDao {
    private static final Logger log = LoggerFactory.getLogger(AppUserDaoStaticDataImpl.class);

    private static final List<String> USER_LIST = Arrays.asList("Петров",
            "Иванов", "Гусько", "Маск", "Гослинг", "Виан");

    @PostConstruct
    public void init() {
        createAppUserTable();
    }

    @Override
    @Transactional
    public void createAppUserTable() {

    }

    @Override
    @Transactional
    public List<AppUser> getAppUser() {
        log.info("calling getUser");
        return TestUtils.getAppUserByNameList(USER_LIST);
    }

    @Override
    @Transactional
    public List<AppUser> getAppUserByActive(Boolean userActive) {
        log.info("calling getAppUserByActive");
        return TestUtils.getAppUserByNameList(USER_LIST);
    }
}
