package org.hujianbest;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hujian
 */
@Service
public class Serviceee {
    @Resource
    Mapper mapper;

    public VO getVO(){
        return mapper.query();
    }
}
