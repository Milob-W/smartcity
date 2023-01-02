package com.briup.smartcity80.service.impl.basic;

import com.briup.smartcity80.bean.basic.BaseUser;
import com.briup.smartcity80.dao.basic.BaseUserMapper;
import com.briup.smartcity80.dao.ext.BaseUserExtMapper;
import com.briup.smartcity80.enums.BusinessErrorEnum;
import com.briup.smartcity80.exception.BusinessException;
import com.briup.smartcity80.service.base.basic.ICRUDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/** 用户增删改查的操作的实现
 * @Author congee(congee02 @ 163.com)
 * @Date 1/2/2023 6:50 PM
 */
@Service
@Slf4j
public class BaseUserCRUDServiceImpl implements ICRUDService<BaseUser> {

    private final BaseUserMapper mapper;
    private final BaseUserExtMapper extMapper;

    public BaseUserCRUDServiceImpl(BaseUserMapper mapper, BaseUserExtMapper extMapper) {
        this.mapper = mapper;
        this.extMapper = extMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {

        BaseUser baseUser = mapper.selectByPrimaryKey(id);

        if (baseUser == null) {
            throw new BusinessException(BusinessErrorEnum.USER_NOT_FOUND);
        }

        return mapper.deleteByPrimaryKey(id);
    }


    @Override
    public int insertSelective(BaseUser record) {
        BaseUser byTelephone = extMapper.selectByTelephone(record.getTelephone());
        if (byTelephone != null) {
            throw new BusinessException("该手机号已被其他账户使用", BusinessErrorEnum.DUPLICATE_TELEPHONE);
        }
        BaseUser byEmail = extMapper.selectByEmail(record.getEmail());
        if (byEmail != null) {
            throw new BusinessException("该邮箱已被其他账户使用", BusinessErrorEnum.DUPLICATE_EMAIL);
        }
        BaseUser byUsername = extMapper.selectByUsername(record.getUsername());
        if (byUsername != null) {
            throw new BusinessException("该用户名已被其他账户使用", BusinessErrorEnum.DUPLICATE_USERNAME);
        }
        return mapper.insertSelective(record);
    }

    @Override
    public BaseUser selectByPrimaryKey(Integer id) {
        BaseUser baseUser = mapper.selectByPrimaryKey(id);
        if (baseUser == null) {
            throw new BusinessException(BusinessErrorEnum.USER_NOT_FOUND);
        }
        return baseUser;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseUser record) {
        BaseUser baseUser = mapper.selectByPrimaryKey(record.getUserId());
        if (baseUser == null) {
            throw new BusinessException(BusinessErrorEnum.USER_NOT_FOUND);
        }
        return mapper.updateByPrimaryKeySelective(record);
    }

}
