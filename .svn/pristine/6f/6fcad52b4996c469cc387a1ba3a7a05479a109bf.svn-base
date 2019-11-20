package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeClique;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 58
 * Description:
 */
public interface FaeCliqueMapper {

    @Select("select * from fae_clique where name like concat('%', #{name}, '%')")
    List<FaeClique> getFaeCliqueByName(@Param("name") String cliqueName);

    @Insert("insert into fae_clique(name, shortName, creditCode, createTime) values(#{name}, #{shortName}, #{creditCode}, #{createTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void addFaeClique(FaeClique faeClique);

    @SelectProvider(type = FaeCliqueProvider.class, method = "queryFaeCliqueCountByParam")
    int queryFaeCliqueCountByParam(Map<String, Object> paramMap);

    @SelectProvider(type = FaeCliqueProvider.class, method = "queryFaeCliqueListByParam")
    List<FaeClique> queryFaeCliqueListByParam(Map<String, Object> paramMap);

    @Select("select * from fae_clique where id = #{cliqueId}")
    FaeClique getFaeCliqueById(@Param("cliqueId") int cliqueId);

    @Select("select * from fae_clique where creditCode = #{creditCode} limit 1")
    FaeClique getFaeCliqueByCreditCode(@Param("creditCode") String creditCode);


}
