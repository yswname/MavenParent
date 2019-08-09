package cn.com.idea.demo.maven.dao.impl;

import cn.com.idea.demo.maven.dao.IUserDAO;
import cn.com.idea.demo.maven.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;

public class TestUserDAOImpl {
    private IUserDAO userDAO;
    @Before
    public void before(){
        userDAO = new UserDAOImpl();
    }
    @Test
    public void testSaveUser()throws Exception{
        UserEntity userEntity = new UserEntity();
        userEntity.setUrUserName("zhangsan");
        userEntity.setUrName("张三");
        userEntity.setUrAge(18);
        this.userDAO.saveUser(userEntity);
    }
}
