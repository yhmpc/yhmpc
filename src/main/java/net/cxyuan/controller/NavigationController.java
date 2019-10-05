package net.cxyuan.controller;

import net.cxyuan.bean.Navigation;
import net.cxyuan.bean.Result;
import net.cxyuan.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/navigations")
@CrossOrigin
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @GetMapping
    public Result getAllNavigations() {
        List<Navigation> navigations = navigationService.getAllNavigations();
        return new Result(true, 20000, "查询成功", navigations);
    }
}
