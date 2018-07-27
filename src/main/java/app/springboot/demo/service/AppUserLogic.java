package app.springboot.demo.service;

import app.springboot.demo.dao.AppUserDao;
import app.springboot.demo.jdo.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

public class AppUserLogic {
    private static final Logger log = LoggerFactory.getLogger(AppUserLogic.class);
    private static final Boolean APP_USER_ACTIVE = true;

    private AppUserDao appUserDao;

    public AppUserLogic(AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }

    @PostConstruct
    public void init() {
        appUserDao.createAppUserTable();
    }

    public String getAppUser() {
        log.info("getAppUser has been called");
        List<AppUser> appUser = appUserDao.getAppUserByActive(APP_USER_ACTIVE);

        return appUser.stream()
                .map(AppUser::getUserName)
                .collect(Collectors.joining(", "));
    }

}


