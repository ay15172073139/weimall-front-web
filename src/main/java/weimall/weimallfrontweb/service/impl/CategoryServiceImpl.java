package weimall.weimallfrontweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import weimall.weimallfrontweb.dao.CategoryMapper;
import weimall.weimallfrontweb.entity.Category;
import weimall.weimallfrontweb.service.CategoryService;
import weimall.weimallfrontweb.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public boolean add(Category category) {
        return categoryMapper.insertOne(category)>0;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public boolean update(Category category) {
        return categoryMapper.updateOne(category)>0;
    }

    @Override
    public List<Category> getList(String category_name, PageUtil pageUtil) {
        return categoryMapper.select(category_name,pageUtil);
    }

    @Override
    public Category get(Integer category_id) {
        return categoryMapper.selectOne(category_id);
    }

    @Override
    public Integer getTotal(String category_name) {
        return categoryMapper.selectTotal(category_name);
    }
}
