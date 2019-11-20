package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeEntrusted;
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
public interface FaeEntrustedMapper {
    @Select("select * from fae_entrusted where name like concat('%', #{name}, '%') ")
    List<FaeEntrusted> getFaeEntrustedBySgt(String keys);

    @Insert("insert into fae_entrusted(name, shortName, creditCode, createTime) values(#{name}, #{shortName}, #{creditCode}, #{createTime})")
    void addFaeEntrusted(FaeEntrusted faeEntrusted);

    @Select("select * from fae_entrusted where id = #{entrustedId}")
    FaeEntrusted getFaeEntrustedById(@Param("entrustedId") int entrustedId);

    @SelectProvider(type = FaeEntrustedProvider.class, method = "queryFaeEntrustedCountByParam")
    int queryFaeEntrustedCountByParam(Map<String, Object> paramMap);

    @SelectProvider(type = FaeEntrustedProvider.class, method = "queryFaeEntrustedListByParam")
    List<FaeEntrusted> queryFaeEntrustedListByParam(Map<String, Object> paramMap);

    @Select("select * from fae_entrusted where creditCode = #{creditCode}")
    FaeEntrusted getFaeEntrustedByCreditCode(@Param("creditCode") String creditCode);
}
