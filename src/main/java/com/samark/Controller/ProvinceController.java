package com.samark.Controller;

import com.samark.Entity.Province;
import com.samark.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping
    public Collection<Province> getAllProvince() {
        return this.provinceService.getAllProvince();
    }
}
