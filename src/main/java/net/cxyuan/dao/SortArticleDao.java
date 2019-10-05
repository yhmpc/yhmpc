package net.cxyuan.dao;

import net.cxyuan.bean.Article;
import net.cxyuan.bean.SortArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortArticleDao extends JpaRepository<SortArticle, Integer> {
    SortArticle queryByArticle(Article article);
}
