package net.cxyuan.service;

import net.cxyuan.bean.Sort;
import net.cxyuan.dao.SortDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SortService {

    @Autowired
    private SortDao sortDao;

    public Sort getSortBySortName(String sortName) {
        return sortDao.queryBySortName(sortName);
    }

    public Sort save(Sort sort) {
        return sortDao.save(sort);
    }
}
