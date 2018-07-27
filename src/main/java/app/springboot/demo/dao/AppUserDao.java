package app.springboot.demo.dao;

import app.springboot.demo.jdo.AppUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppUserDao {

    @Transactional
    void createAppUserTable();

    @Transactional
    List<AppUser> getAppUser();

    @Transactional
    List<AppUser> getAppUserByActive(Boolean userActive);
}
