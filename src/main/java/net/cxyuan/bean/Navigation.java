package net.cxyuan.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "navi")
public class Navigation {
    @Id
    private int id;
    private String naviname;
    private String url;

    @Column(name = "order_num")
    private int orderNum;

    @Column(name = "new_tab")
    @Enumerated(EnumType.STRING)
    private YesNo newTab;

    @Column(name = "is_hide")
    @Enumerated(EnumType.STRING)
    private YesNo isHide;

    private Integer pid;

    @Transient
    private List<Navigation> subNavigations = new ArrayList<>();

    @Column(name = "is_delete")
    @Enumerated(EnumType.STRING)
    private YesNo isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaviname() {
        return naviname;
    }

    public void setNaviname(String naviname) {
        this.naviname = naviname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public YesNo getNewTab() {
        return newTab;
    }

    public void setNewTab(YesNo newTab) {
        this.newTab = newTab;
    }

    public YesNo getIsHide() {
        return isHide;
    }

    public void setIsHide(YesNo isHide) {
        this.isHide = isHide;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public YesNo getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(YesNo isDelete) {
        this.isDelete = isDelete;
    }

    public List<Navigation> getSubNavigations() {
        return subNavigations;
    }

    public void setSubNavigations(List<Navigation> subNavigations) {
        this.subNavigations = subNavigations;
    }
}
