package com.example.polly.dao;


import java.util.List;
import java.util.Set;

import com.example.polly.enty.Thirdparty;
import com.example.polly.enty.User;
import com.example.polly.util.MyBatisDao;

/**
 * <p>User: zhouxiantao
 * <p>Date: 17-10-17
 * <p>Version: 1.0
 */
@MyBatisDao
public interface UserDao {

    public void createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);
    public List<User> findList(User user);

    public void correlationRoles(Long userId, Long roleIds);
    public void uncorrelationRoles(Long userId, Long roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
    
    public void createThirdparty(Thirdparty thirdparty);
    
    public List<Thirdparty> selectThirdparty(Thirdparty thirdparty);
}
