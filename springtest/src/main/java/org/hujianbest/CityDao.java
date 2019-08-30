package org.hujianbest;


import org.apache.ibatis.annotations.Param;

public interface CityDao {
    City findByName(@Param("cityName") String cityName);
}
