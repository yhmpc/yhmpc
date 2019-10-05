package net.cxyuan.service;

import net.cxyuan.bean.Article;
import net.cxyuan.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public Article save(Article article) {
        return articleDao.save(article);
    }
}
