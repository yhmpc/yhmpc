package net.cxyuan.service;

import net.cxyuan.bean.Tag;
import net.cxyuan.dao.TagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> findByArticleId(int id) {
        List<Tag> all = tagDao.findAll();
        return all.stream().filter(t -> {
            String[] split = t.getArticleIds().split(",");
            if (split != null && split.length > 0) {
                for (String s : split) {
                    if (("" + id).equals(s)) {
                        return true;
                    }
                }
            }
            return false;
        }).map(Tag::getTagName).collect(Collectors.toList());
    }
}
