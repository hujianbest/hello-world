package org.hujianbest;

import lombok.Data;

@Data
public class City {
    private long id;
    private  long provinceId;
    private String cityName;
    private String description;
}
