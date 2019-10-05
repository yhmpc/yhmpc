package net.cxyuan.controller;

import net.cxyuan.bean.Article;
import net.cxyuan.bean.Article4Jsoup;
import net.cxyuan.bean.Result;
import net.cxyuan.bean.SortArticle;
import net.cxyuan.service.ArticleService;
import net.cxyuan.service.SortArticleService;
import net.cxyuan.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private SortArticleService sortArticleService;

    @GetMapping(value = {"/p/{page}", "/p"})
    public Result getArticlesByPage(@PathVariable(required = false) Integer page) {
        if (page == null) {
            page = 0;
        }
        Page<Article> articlesByPage = articleService.getArticlesByPage(page);
        long total = articlesByPage.getTotalElements();
        List<Article> content = articlesByPage.getContent();
        List<Article4Jsoup> list = new ArrayList<>();
        content.stream().forEach(c -> {
            List<String> tags = tagService.findByArticleId(c.getId());
            Article4Jsoup article4Jsoup = new Article4Jsoup();
            BeanUtils.copyProperties(c, article4Jsoup);
            article4Jsoup.getTags().addAll(tags);
            SortArticle sortArticle = sortArticleService.queryByArticle(c);
            article4Jsoup.setSortName(sortArticle.getSort().getSortName());
            article4Jsoup.setContent(null);
            list.add(article4Jsoup);
        });
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("data", list);
        return new Result(true, 20000, "查询成功", map);
    }

    @GetMapping(value = {"/{id}"})
    public Result getArticlesById(@PathVariable Integer id) {
        Article article = articleService.getArticlesById(id);
        Article4Jsoup article4Jsoup = new Article4Jsoup();
        BeanUtils.copyProperties(article, article4Jsoup);
        List<String> tags = tagService.findByArticleId(article.getId());
        article4Jsoup.getTags().addAll(tags);
        SortArticle sortArticle = sortArticleService.queryByArticle(article);
        article4Jsoup.setSortName(sortArticle.getSort().getSortName());
        return new Result(true, 20000, "查询成功", article4Jsoup);
    }

}
