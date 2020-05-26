package xjtu.cnki.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xjtu.cnki.entity.URL;

import java.util.List;

/**
 * @基本功能:
 * @program:cnki
 * @author:peicc
 * @create:2020-05-26 09:50:53
 **/
@Repository
@Mapper
public interface URLMapper {
    @Select("SELECT url FROM url WHERE isspider=0")
    public List<String> getURLSOfNoSpider();
    @Select("UPDATE url set isspider=1 WHERE isspider=0")
    public void setFlag();
    @Select("INSERT INTO url (url) VALUES('http://www.cnkisci.com/cnki/')")
    public void addOneURL();
}
