package com.samark.Service;

import com.samark.Dao.ProvinceImplement;
import com.samark.Entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceImplement provinceImplement;

    public Collection<Province> getAllProvince() {
        return provinceImplement.getAllProvince();
    }
}
