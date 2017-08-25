package com.hdjf.oa.action;

import com.hdjf.oa.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.lang.reflect.ParameterizedType;

/**
 * Created by harrishuang on 2017/8/24.
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {


    protected T model = null;


    public BaseAction() {
        ParameterizedType dt = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) dt.getActualTypeArguments()[0];
        try {
            model = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public T getModel() {
        return model;
    }


    public User getCurrentUser() {
        User user = (User) ActionContext.getContext().getSession().get("user");
        return user;
    }


}
