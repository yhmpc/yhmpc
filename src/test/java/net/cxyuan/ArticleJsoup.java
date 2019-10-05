package net.cxyuan;

import net.cxyuan.bean.*;
import net.cxyuan.service.ArticleService;
import net.cxyuan.service.SortArticleService;
import net.cxyuan.service.SortService;
import net.cxyuan.service.TagService;
import net.cxyuan.util.DateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleJsoup {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private SortService sortService;

    @Autowired
    private SortArticleService sortArticleService;

    @Test
    public void save() {
        final String BASE_URL = "http://www.yhmpc.com/?page=";
        List<String> urlList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            urlList.add(BASE_URL + i);
        }
        List<Article4Jsoup> list = getExcerptList(urlList);
        list.stream().forEach(one -> {
            String url = one.getArticleUrl();
            try {
                Document doc = Jsoup.connect(url).get();
                Elements contentleft = doc.select("#contentleft");
                Elements ps = contentleft.select("p");
                ps.remove(ps.last());
                ps.remove(ps.first());
                String content = ps.toString();
                one.setContent(content);
                Article article = new Article();
                BeanUtils.copyProperties(one, article);
                Article savedArticle = articleService.save(article);

                Set<String> tags = one.getTags();
                // 保存标签
                tags.forEach(t -> {
                    Tag tag = tagService.getByTagName(t);
                    if (tag != null) {
                        tag.setArticleIds(tag.getArticleIds() + "," + savedArticle.getId());
                        tagService.save(tag);
                    } else {
                        Tag newTag = new Tag();
                        newTag.setTagName(t);
                        newTag.setArticleIds("," + savedArticle.getId());
                        Tag savedTag = tagService.save(newTag);
                    }
                });

                SortArticle sortArticle = new SortArticle();
                sortArticle.setArticle(savedArticle);

                // 保存分类
                Sort sort = sortService.getSortBySortName(one.getSortName());
                if (sort != null) {
                    sortArticle.setSort(sort);
                } else {
                    Sort newSort = new Sort();
                    newSort.setSortName(one.getSortName());
                    Sort savedSort = sortService.save(newSort);
                    sortArticle.setSort(savedSort);
                }

                // 保存中间表
                sortArticleService.save(sortArticle);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private List<Article4Jsoup> getExcerptList(List<String> urlList) {
        List<Article4Jsoup> list = new ArrayList<>();
        urlList.stream().forEach(u -> {
            try {
                Document doc = Jsoup.connect(u).get();
                Elements content = doc.select("#contentleft");
                Elements h2 = content.select("h2");
                Elements pDate = content.select("p.date");
                Elements img = content.select("img");
                Elements pTag = content.select("p.tag");
                Elements pCount = content.select("p.count");
                for (int i = 0; i < h2.size(); i++) {
                    Article4Jsoup article4Jsoup = new Article4Jsoup();
                    article4Jsoup.setTitle(h2.get(i).select("a").text());
                    article4Jsoup.setArticleUrl(h2.get(i).select("a").attr("href"));
                    article4Jsoup.setAuthorId("70e11b2c-66cb-49ad-b7cd-410159c50280");
                    article4Jsoup.setAuthorName("管理员");
                    article4Jsoup.setCreateTime(DateUtil.str2Date(pDate.get(i).text().split(" ")[0]));
                    article4Jsoup.setLastModifiedTime(new Date());
                    article4Jsoup.setSortName(pDate.get(i).text().split(" ")[1]);
                    article4Jsoup.setExcerpt(img.get(i).attr("src"));
                    Set<String> set = new HashSet<>();
                    Elements a = pTag.get(i).select("a");
                    set.addAll(a.stream().map(one -> one.text()).collect(Collectors.toList()));
                    article4Jsoup.setTags(set);
                    Elements aCount = pCount.get(i).select("a");
                    article4Jsoup.setCommentNum(Integer.parseInt(aCount.get(0).text().replaceAll("\\D*(\\d+)\\D*", "$1")));
                    article4Jsoup.setViewNum(Integer.parseInt(aCount.get(1).text().replaceAll("\\D*(\\d+)\\D*", "$1")));
                    list.add(article4Jsoup);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return list;
    }
}
