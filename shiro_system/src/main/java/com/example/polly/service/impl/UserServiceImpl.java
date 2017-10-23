package com.example.polly.service.impl;

import com.example.polly.dao.UserDao;
import com.example.polly.enty.User;
import com.example.polly.enty.UserRole;
import com.example.polly.service.UserService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>User: zhouxiaotao
 * <p>Date: 17-10-17
 * <p>Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDao userDao;
	
//    private PasswordHelper passwordHelper;
//
//    public void setPasswordHelper(PasswordHelper passwordHelper) {
//        this.passwordHelper = passwordHelper;
//    }

    /**
     * 创建用户
     * @param user
     */
    public void createUser(User user) {
        //加密密码
    	System.out.println("username="+user.getUsername());
    	System.out.println("password="+user.getPassword());
    	PasswordHelper passwordHelper = new PasswordHelper();
        passwordHelper.encryptPassword(user);
        userDao.createUser(user);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
        User user =userDao.findOne(userId);
        user.setPassword(newPassword);
        PasswordHelper passwordHelper = new PasswordHelper();
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }
    
    /**
     * 查询用户列表
     * @param user
     */
    public List<User> findList(User user){
    	return userDao.findList(user);
    }

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(Long userId, Long roleIds) {
        userDao.correlationRoles(userId, roleIds);
    }


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(Long userId, Long roleIds) {
        userDao.uncorrelationRoles(userId, roleIds);
    }

    /**
     * 根据用户名查找用户   * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     *根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }

}
