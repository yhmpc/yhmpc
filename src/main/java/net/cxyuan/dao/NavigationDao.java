package net.cxyuan.dao;

import net.cxyuan.bean.Navigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NavigationDao extends JpaRepository<Navigation, Integer> {

    @Query(value = "select * from navi where pid is null", nativeQuery = true)
    List<Navigation> getNavigationsByPidIsNull();

    @Query(value = "select * from navi where pid = ?1", nativeQuery = true)
    List<Navigation> getNavigationsByPid(int pid);

}
