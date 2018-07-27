package app.springboot.demo.utils;

import app.springboot.demo.jdo.AppUser;

import java.util.List;
import java.util.stream.Collectors;

public class TestUtils {
    public static List<AppUser> getAppUserByNameList(List<String> names){
        return names.stream().map(AppUser::new).collect(Collectors.toList());
    }
}
