package net.cxyuan.bean;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "article_ids")
    private String articleIds;

    @Column(name = "is_delete")
    @Enumerated(EnumType.STRING)
    private YesNo isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getArticleIds() {
        return articleIds;
    }

    public void setArticleIds(String articleIds) {
        this.articleIds = articleIds;
    }

    public YesNo getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(YesNo isDelete) {
        this.isDelete = isDelete;
    }
}
