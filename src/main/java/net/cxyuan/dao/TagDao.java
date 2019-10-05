package net.cxyuan.dao;

import net.cxyuan.bean.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDao extends JpaRepository<Tag, Integer> {
    Tag queryByTagName(String tagName);
}
