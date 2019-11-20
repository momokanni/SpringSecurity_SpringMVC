package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeIssue;
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
public interface FaeIssueMapper {


    @Select("select * from fae_issue where name like concat('%', #{name}, '%') ")
    List<FaeIssue> getFaeIssueByName(@Param("name") String keys);

    @Insert("insert into fae_issue(name, shortName, creditCode, cliqueId, createTime) values(#{name}, #{shortName}, #{creditCode}, #{cliqueId}, #{createTime})")
    void addFaeIssue(FaeIssue faeIssue);

    @Select("select * from fae_issue where cliqueId = #{cliqueId}")
    List<FaeIssue> getFaeIssueByCliqueId(@Param("cliqueId") int cliqueId);

    @Select("select count(1) from fae_issue where cliqueId = #{cliqueId}")
    int getFaeIssueCountByCliqueId(@Param("cliqueId") int cliqueId);

    @Select("select * from fae_issue where id = #{issueId}")
    FaeIssue getFaeIssueById(@Param("issueId") int issueId);

    @SelectProvider(type = FaeIssueProvider.class, method = "queryFaeIssueCountByParam")
    int queryFaeIssueCountByParam(Map<String, Object> paramMap);

    @SelectProvider(type = FaeIssueProvider.class, method = "queryFaeIssueListByParam")
    List<FaeIssue> queryFaeIssueListByParam(Map<String, Object> paramMap);

    @Select("select * from fae_issue where creditCode = #{creditCode}")
    FaeIssue getFaeIssueByCreditCode(@Param("creditCode") String creditCode);

    @Select("select count(1) from fae_issue ")
    int getCountIssue();
}
