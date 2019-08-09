package cn.com.idea.demo.maven.dao;

import cn.com.idea.demo.maven.entity.UserEntity;

import java.util.List;

public interface IUserDAO {
    public void saveUser(UserEntity user);
    public UserEntity findById(int urId);
    public List<UserEntity> findAll();
}
