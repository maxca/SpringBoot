package com.samark.Dao;

import com.samark.Entity.Province;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProvinceImplement {
    public static Map<Integer, Province> province;

    static {
        province = new HashMap<Integer, Province>() {
            {
                put(1, new Province(1, "Sakon"));
                put(2, new Province(2, "Bankkok"));
            }
        };
    }

    public Collection<Province> getAllProvince() {
        return this.province.values();
    }

}
