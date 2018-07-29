package app.springboot.demo.controller;

import app.springboot.demo.service.AppUserLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AppController {
    private static final Logger log = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private AppUserLogic appUserLogic;

    @RequestMapping(value = "/getExpressAppUserList",
            method = RequestMethod.GET)
    @ResponseBody
    public String getAppUser(HttpServletRequest request,
                             HttpServletResponse response) {
        try {
            log.info("getExpressAppUserList has been called");
            return appUserLogic.getAppUser();
        } catch (Exception e) {
            log.error(e.getMessage());
            return "some error happened";
        }
    }

}
