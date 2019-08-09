package cn.com.idea.demo.maven.service.impl;

import cn.com.idea.demo.maven.dao.IUserDAO;
import cn.com.idea.demo.maven.dao.impl.UserDAOImpl;
import cn.com.idea.demo.maven.entity.UserEntity;
import cn.com.idea.demo.maven.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDAO userDAO = new UserDAOImpl();
    @Override
    public void register(UserEntity user) {
        this.userDAO.saveUser(user);
    }

    @Override
    public List<UserEntity> searchUsers() {
        return this.userDAO.findAll();
    }
}
