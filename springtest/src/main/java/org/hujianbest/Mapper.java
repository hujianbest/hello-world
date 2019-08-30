package org.hujianbest;

import org.springframework.stereotype.Service;

/**
 * @author hujian
 */
@Service
public class Mapper {
    public VO query(){
        VO vo = new VO();
        vo.setData(1);
        return vo;
    }
}
