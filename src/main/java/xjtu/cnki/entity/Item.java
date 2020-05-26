package xjtu.cnki.entity;

import lombok.Data;

import java.util.Date;

/**
 * @基本功能:
 * @program:cnki
 * @author:peicc
 * @create:2020-05-25 16:06:17
 **/
@Data
public class Item {
    private long id;
    private String name;
    private double price;
    private Date spidertime;
}
