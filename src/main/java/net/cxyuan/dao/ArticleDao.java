package net.cxyuan.dao;

import net.cxyuan.bean.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article, Integer> {
}
