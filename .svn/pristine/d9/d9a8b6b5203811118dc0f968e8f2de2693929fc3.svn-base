package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeUnderwriter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 58
 * Description:
 */
public interface FaeUnderwriterMapper {
    @Select("select * from fae_underwriter where name like concat('%', #{name}, '%') ")
    List<FaeUnderwriter> getFaeUnderwriterBySgt(@Param("name") String keys);

    @Insert("insert into fae_underwriter(name, shortName, creditCode, createTime) values(#{name}, #{shortName}, #{creditCode}, #{createTime})")
    void addFaeUnderwriter(FaeUnderwriter faeUnderwriter);

    @Select("select * from fae_underwriter where id = #{underwriterId}")
    FaeUnderwriter getFaeUnderwriterById(@Param("underwriterId") int underwriterId);

    @SelectProvider(type = FaeUnderwriterProvider.class, method = "queryFaeUnderwriterCountByParam")
    int queryFaeUnderwriterCountByParam(Map<String, Object> paramMap);

    @SelectProvider(type = FaeUnderwriterProvider.class, method = "queryFaeUnderwriterListByParam")
    List<FaeUnderwriter> queryFaeUnderwriterListByParam(Map<String, Object> paramMap);

    @SelectProvider(type = FaeUnderwriterProvider.class, method = "getFaeUnderwriterByIds")
    List<FaeUnderwriter> getFaeUnderwriterByIds(Map<String, Object> map);

    @Select("select * from fae_underwriter where creditCode = #{creditCode}")
    FaeUnderwriter getFaeUnderwriterByCreditCode(@Param("creditCode") String creditCode);
}
