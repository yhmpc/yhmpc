package net.cxyuan.service;

import net.cxyuan.bean.Article;
import net.cxyuan.bean.SortArticle;
import net.cxyuan.dao.SortArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortArticleService {

    @Autowired
    private SortArticleDao sortArticleDao;

    public SortArticle save(SortArticle sortArticle) {
        return sortArticleDao.save(sortArticle);
    }

    public SortArticle queryByArticle(Article article) {
        return sortArticleDao.queryByArticle(article);
    }
}
