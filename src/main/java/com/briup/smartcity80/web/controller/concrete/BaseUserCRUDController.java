package com.briup.smartcity80.web.controller.concrete;

import com.briup.smartcity80.bean.basic.BaseUser;
import com.briup.smartcity80.consts.BeanNameConsts;
import com.briup.smartcity80.service.base.basic.ICRUDService;
import com.briup.smartcity80.web.controller.base.basic.AbstractCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author congee(congee02@163.com)
 * @Date 1/2/2023 7:20 PM
 */
@RestController
@RequestMapping(BeanNameConsts.BASE_USER)
public final class BaseUserCRUDController extends AbstractCRUDController<BaseUser> {
    protected BaseUserCRUDController(ICRUDService<BaseUser> icrudService) {
        super(icrudService);
    }
}
