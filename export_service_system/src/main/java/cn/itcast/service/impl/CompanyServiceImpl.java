package cn.itcast.service.impl;

import cn.itcast.dao.company.CompanyDao;
import cn.itcast.domain.Company;
import cn.itcast.service.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public List<Company> findAll() { return companyDao.findAll(); }
    public void save(Company company) {
        companyDao.save(company);
    }

    public Company findById(String id) {
        return companyDao.findById(id);
    }

    public void update(Company company) {
        companyDao.update(company);
    }

    public void deleteById(String id) {
        companyDao.deleteById(id);
    }
    //pageHelper插件
    //pageHelper插件
    public PageInfo findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        //紧跟在后面的查询方法会自动分页
        List<Company> list=companyDao.findPageList();
        // 自动提供好了pageBean(pageInfo)
        PageInfo page = new PageInfo(list);
        return page;
    }
}
