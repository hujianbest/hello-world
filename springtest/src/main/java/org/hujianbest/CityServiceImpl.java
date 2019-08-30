package org.hujianbest;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    CityDao cityDao;

    @Override
    public City findCityByName(String cityName){
        return cityDao.findByName(cityName);
    }
}
