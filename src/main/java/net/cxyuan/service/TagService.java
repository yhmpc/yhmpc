package net.cxyuan.service;

import net.cxyuan.bean.Tag;
import net.cxyuan.dao.TagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagDao tagDao;

    public Tag getByTagName(String tagName) {
        return tagDao.queryByTagName(tagName);
    }

    public Tag save(Tag newTag) {
        return tagDao.save(newTag);
    }
}
