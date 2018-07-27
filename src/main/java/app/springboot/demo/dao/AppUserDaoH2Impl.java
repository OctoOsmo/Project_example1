package app.springboot.demo.dao;

import app.springboot.demo.jdo.AppUser;
import app.springboot.demo.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppUserDaoH2Impl implements AppUserDao {

    private static final Logger log = LoggerFactory.getLogger(AppUserDaoH2Impl.class);

    private static final String CREATE_APP_USER_TABLE = FileUtils.loadScriptFromFile("/sql/create.sql");
    private static final String GET_APP_USER = FileUtils.loadScriptFromFile("/sql/get-userApp.sql");
    private static final String GET_APP_USER_BY_ACTIVITY = FileUtils.loadScriptFromFile("/sql/get-appUser-by-activity.sql");

    @Override
    @Transactional
    public void createAppUserTable() {
        jdbcTemplate.execute(CREATE_APP_USER_TABLE);
    }

    @Autowired
    @Qualifier("targetTemplate")
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("namedParameterTargetTemplate")
    NamedParameterJdbcTemplate namedParameterTargetTemplate;

    @Override
    @Transactional
    public List<AppUser> getAppUser() {
        log.info("calling getAppUser");
        Map<String, Object> params = new HashMap<>();

        return namedParameterTargetTemplate.query(GET_APP_USER, params, new AppUserRowMapper());
    }

    @Override
    @Transactional
    public List<AppUser> getAppUserByActive(Boolean userActive) {
        log.info("calling getAppUser");
        Map<String, Object> params = new HashMap<>();
        params.put("userActive", userActive);

        return namedParameterTargetTemplate.query(GET_APP_USER_BY_ACTIVITY, params, new AppUserRowMapper());
    }
}
