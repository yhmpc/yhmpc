package net.cxyuan.service;

import net.cxyuan.bean.Article;
import net.cxyuan.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public Article save(Article article) {
        return articleDao.save(article);
    }

    public Page<Article> getArticlesByPage(Integer page) {
        PageRequest pageRequest = PageRequest.of(page-1, 7);
        return articleDao.findAll(pageRequest);
    }

    public Article getArticlesById(Integer id) {
        return articleDao.findById(id).get();
    }
}
