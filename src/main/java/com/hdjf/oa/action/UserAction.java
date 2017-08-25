package com.hdjf.oa.action;


import com.hdjf.oa.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 * Created by harrishuang on 2017/8/24.
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {


    @Override
    public String execute() throws Exception {
//		ServletContext servletContext=ServletActionContext.getServletContext();
//		ApplicationContext oc=(ApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		ApplicationContext oc=WebApplicationContextUtils.getWebApplicationContext(servletContext);
//		userService=(UserService) oc.getBean("userService");

        System.out.println("execute");
        return SUCCESS;
    }

    public String add() {

        return "addUI";
    }


    public String login(){

        return  "loginUI";
    }
}

