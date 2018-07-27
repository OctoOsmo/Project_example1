package app.springboot.demo.config;

import app.springboot.demo.dao.AppUserDao;
import app.springboot.demo.dao.AppUserDaoH2Impl;
import app.springboot.demo.dao.AppUserDaoStaticDataImpl;
import app.springboot.demo.service.AppUserLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppUserConfig {
    @Bean
    public AppUserDao appUserDaoH2Impl() {
        return new AppUserDaoH2Impl();
    }

    @Bean
    public AppUserDao appUserDaoStaticData() {
        return new AppUserDaoStaticDataImpl();
    }

    @Bean
    public AppUserLogic locationsLogic() {
        return new AppUserLogic(appUserDaoStaticData());
    }

}
