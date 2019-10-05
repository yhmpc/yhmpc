package net.cxyuan.dao;

import net.cxyuan.bean.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortDao extends JpaRepository<Sort, Integer> {
    Sort queryBySortName(String sortName);
}
