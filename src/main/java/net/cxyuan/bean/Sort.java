package net.cxyuan.bean;

import javax.persistence.*;

@Entity
@Table(name = "sort")
public class Sort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sort_name")
    private String sortName;

    private String description;

    private int pid;

    @Transient
    private Sort parentSort;

    @Column(name = "is_delete")
    @Enumerated(EnumType.STRING)
    private YesNo isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Sort getParentSort() {
        return parentSort;
    }

    public void setParentSort(Sort parentSort) {
        this.parentSort = parentSort;
    }

    public YesNo getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(YesNo isDelete) {
        this.isDelete = isDelete;
    }
}
