package com.hdjf.oa.service.impl;

import com.hdjf.oa.dao.BaseDaoImple;
import com.hdjf.oa.domain.Role;
import com.hdjf.oa.service.RoleService;
import com.hdjf.oa.utils.HDLog;
import org.springframework.stereotype.Service;

/**
 * Created by harrishuang on 2017/8/24.
 */

@Service
public class RoleServiceImpl extends BaseDaoImple<Role> implements RoleService{
    /*打印数据问题*/
    public void logUser() {
        HDLog.info("====logUser>>>>>");
    }
}
