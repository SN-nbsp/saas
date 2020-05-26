package cn.itcast.service;

import cn.itcast.domain.Company;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();
    void save(Company company);

    Company findById(String id);

    void update(Company company);

    void deleteById(String id);

    PageInfo findPage(int pageNum, int pageSize);
}
