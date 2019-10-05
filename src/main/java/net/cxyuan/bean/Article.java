package net.cxyuan.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_modified_time")
    private Date lastModifiedTime;

    private String content;
    private String excerpt;

    @Column(name = "view_num")
    private int viewNum;

    @Column(name = "comment_num")
    private int commentNum;

    @Column(name = "is_top")
    @Enumerated(EnumType.STRING)
    private YesNo isTop;

    @Column(name = "top_order_num")
    @Enumerated(EnumType.STRING)
    private YesNo topOrderNum;

    @Column(name = "allow_comment")
    @Enumerated(EnumType.STRING)
    private YesNo allowComment;

    @Column(name = "is_hide")
    @Enumerated(EnumType.STRING)
    private YesNo isHide;

    @Column(name = "download_password")
    private String downloadPassword;

    @Column(name = "is_delete")
    @Enumerated(EnumType.STRING)
    private YesNo isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public YesNo getIsTop() {
        return isTop;
    }

    public void setIsTop(YesNo isTop) {
        this.isTop = isTop;
    }

    public YesNo getTopOrderNum() {
        return topOrderNum;
    }

    public void setTopOrderNum(YesNo topOrderNum) {
        this.topOrderNum = topOrderNum;
    }

    public YesNo getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(YesNo allowComment) {
        this.allowComment = allowComment;
    }

    public YesNo getIsHide() {
        return isHide;
    }

    public void setIsHide(YesNo isHide) {
        this.isHide = isHide;
    }

    public String getDownloadPassword() {
        return downloadPassword;
    }

    public void setDownloadPassword(String downloadPassword) {
        this.downloadPassword = downloadPassword;
    }

    public YesNo getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(YesNo isDelete) {
        this.isDelete = isDelete;
    }
}
