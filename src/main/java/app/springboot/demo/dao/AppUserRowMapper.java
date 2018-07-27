package app.springboot.demo.dao;

import app.springboot.demo.jdo.AppUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUserRowMapper implements RowMapper<AppUser> {
    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        AppUser appUser = new AppUser();
        appUser.setUserId(rs.getLong("userId"));
        appUser.setUserName(rs.getString("userName"));
        appUser.setUserBirthday(rs.getDate("userBirthday"));
        appUser.setUserActive(rs.getBoolean("userActive"));
        return appUser;
    }
}
