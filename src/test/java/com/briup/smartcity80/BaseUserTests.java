package com.briup.smartcity80;

import com.briup.smartcity80.bean.basic.BaseUser;
import com.briup.smartcity80.dao.basic.BaseUserMapper;
import com.briup.smartcity80.dao.ext.BaseUserExtMapper;
import com.briup.smartcity80.service.IBaseUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 10:10 AM
 */
@SpringBootTest
public class BaseUserTests {

    @Autowired private BaseUserMapper mapper;

    @Autowired private BaseUserExtMapper extMapper;

    @Autowired private IBaseUserService iBaseUserService;

    @Test
    public void testSelect() {
        mapper.selectByPrimaryKey(1);
    }

    @Test
    public void testSelectByName() {
        BaseUser baseUser = new BaseUser();
        baseUser.setTelephone("15512348116");
        iBaseUserService.addUser(baseUser);
    }

}
