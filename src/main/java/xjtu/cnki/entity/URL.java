package xjtu.cnki.entity;

import lombok.Data;

import java.util.Date;

/**
 * @基本功能:
 * @program:cnki
 * @author:peicc
 * @create:2020-05-26 09:49:46
 **/
@Data
public class URL {
    private long id;
    private String url;
    private int isspider;
    private Date spidertime;
}
