package net.cxyuan.service;

import net.cxyuan.bean.Navigation;
import net.cxyuan.dao.NavigationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationService {

    @Autowired
    private NavigationDao navigationDao;

    public List<Navigation> getParentNavigations() {
        return navigationDao.getNavigationsByPidIsNull();
    }

    public List<Navigation> getSubNavigationsByPid(int pid) {
        return navigationDao.getNavigationsByPid(pid);
    }

    public List<Navigation> getAllNavigations() {
        List<Navigation> parentNavigations = navigationDao.getNavigationsByPidIsNull();
        parentNavigations.forEach(p -> {
            List<Navigation> subNavigations = navigationDao.getNavigationsByPid(p.getId());
            if (subNavigations != null) {
                p.getSubNavigations().addAll(subNavigations);
            }
        });
        return parentNavigations;
    }
}
