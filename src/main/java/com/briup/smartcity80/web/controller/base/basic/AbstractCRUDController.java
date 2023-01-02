package com.briup.smartcity80.web.controller.base.basic;

import com.briup.smartcity80.consts.api.CRUDApiConsts;
import com.briup.smartcity80.service.base.basic.ICRUDService;
import org.springframework.web.bind.annotation.*;

/**
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 7:07 PM
 */
public abstract class AbstractCRUDController<T> {

    protected final ICRUDService<T> icrudService;

    protected AbstractCRUDController(ICRUDService<T> icrudService) {
        this.icrudService = icrudService;
    }

    @PostMapping(CRUDApiConsts.INSERT)
    public int insert(T entity) {
        return icrudService.insertSelective(entity);
    }

    @DeleteMapping(CRUDApiConsts.DELETE)
    public int deleteById(int id) {
        return icrudService.deleteByPrimaryKey(id);
    }

    @PutMapping(CRUDApiConsts.UPDATE)
    public int updateById(T entity) {
        return icrudService.updateByPrimaryKeySelective(entity);
    }

    @GetMapping(CRUDApiConsts.FIND_BY_ID)
    public T findById(int id) {
        return icrudService.selectByPrimaryKey(id);
    }
}
