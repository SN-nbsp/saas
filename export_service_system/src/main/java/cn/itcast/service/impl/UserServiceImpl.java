package cn.itcast.service.impl;

import cn.itcast.dao.user.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public PageInfo findPageAll(int pageNum, int pageSize, String companyId) {

        //调用pageHelper的插件
        PageHelper.startPage(pageNum,pageSize);
        // 查询所有
        List<User> list = userDao.findPageAll(companyId);
        // 返回自带的pageInfo
        PageInfo page = new PageInfo(list);
        return page;
    }

    
    public void save(User user) {
        userDao.save(user);
    }

    public User findById(String id) {
        return userDao.findById(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(String id) {
        userDao.delete(id);
    }
}
