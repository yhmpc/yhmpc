package net.cxyuan.bean;

import javax.persistence.*;

@Entity
@Table(name = "sort_article")
public class SortArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_sort_top")
    private YesNo isSortTop;

    @Column(name = "top_order_num")
    private int topOrderNum;

    @ManyToOne
    @JoinColumn(name = "sort_id", referencedColumnName = "id")
    private Sort sort;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public YesNo getIsSortTop() {
        return isSortTop;
    }

    public void setIsSortTop(YesNo isSortTop) {
        this.isSortTop = isSortTop;
    }

    public int getTopOrderNum() {
        return topOrderNum;
    }

    public void setTopOrderNum(int topOrderNum) {
        this.topOrderNum = topOrderNum;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
