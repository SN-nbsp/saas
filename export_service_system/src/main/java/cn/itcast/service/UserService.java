package cn.itcast.service;

import cn.itcast.domain.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    //pageHelper的分页查询
    PageInfo findPageAll(int pageNum, int pageSize, String companyId);

    void save(User user);

    User findById(String id);

    void update(User user);

    void delete(String id);
}
