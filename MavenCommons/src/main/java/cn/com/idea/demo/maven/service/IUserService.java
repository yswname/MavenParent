package cn.com.idea.demo.maven.service;

import cn.com.idea.demo.maven.entity.UserEntity;

import java.util.List;

public interface IUserService {
    public void register(UserEntity user);
    public List<UserEntity> searchUsers();
}
