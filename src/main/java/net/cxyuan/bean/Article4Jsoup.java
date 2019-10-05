package net.cxyuan.bean;

import java.util.HashSet;
import java.util.Set;

public class Article4Jsoup extends Article {
    private String articleUrl;
    private String sortName;
    private Set<String> tags = new HashSet<>();

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
