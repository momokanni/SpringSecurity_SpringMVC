package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeDanbao;
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
public interface FaeDanbaoMapper {

    @Select("select * from fae_danbao where name like concat('%', #{name}, '%') ")
    List<FaeDanbao> getFaeDanbaoBySgt(String keys);

    @Insert("insert into fae_danbao(name,shortName,creditCode,createTime) values(#{name},#{shortName},#{creditCode},#{createTime})")
    void addFaeDanbao(FaeDanbao faeDanbao);

    @Select("select * from fae_danbao where id = #{danbaoId}")
    FaeDanbao getFaeDanbaoById(@Param("danbaoId") int danbaoId);

    @SelectProvider(type = FaeDanbaoProvider.class, method = "queryFaeanbaoCountByParam")
    int queryFaeanbaoCountByParam(Map<String, Object> paramMap);

    @SelectProvider(type = FaeDanbaoProvider.class, method = "queryFaeDanbaoListByParam")
    List<FaeDanbao> queryFaeDanbaoListByParam(Map<String, Object> paramMap);

    @Select("select * from fae_danbao where creditCode = #{creditCode}")
    FaeDanbao getFaeDanbaoByCreditCode(@Param("creditCode") String creditCode);
}
