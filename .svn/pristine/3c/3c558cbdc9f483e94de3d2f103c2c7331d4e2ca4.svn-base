package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.Notice;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface NoticeMapper {

    @SelectProvider(type = NoticeProvider.class,method = "getTotalNoticeCountByParams")
    int getTotalNoticeCountByParams(Map queryMap);

    @SelectProvider(type = NoticeProvider.class,method = "getNoticeByParams")
    List<Notice> getNoticeByParams(Map queryMap);

    @Select("select * from notice where id= #{id}")
    Notice getNoticeById(int id);

    @Update("update notice set status = #{status} where id = #{id}")
    boolean setStNoticeatus(Notice notice);

    @Insert("insert into notice "
            + "					("
            + "					title,content,status,type,validType,releaseTime,createTime"
            + "					)" +
            " 			values"
            + "					("
            + "					#{title},#{content},#{status},#{type},#{validType},#{releaseTime},#{createTime}"
            + "					)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    boolean addNotice(Notice notice);

    @Update("update notice set title = #{title}, "
            + "						 content = #{content}, "
            + "						 status = #{status}, "
            + "						 type = #{type},"
            + "						 validType = #{validType},"
            + "						 releaseTime = #{releaseTime},"
            + "						 updateTime = #{updateTime}"
            + "				   where id = #{id}")
    boolean updateNotice(Notice notice);


    @Select("UPDATE notice SET status = #{status},updateTime = #{date} WHERE status = #{istatus} AND releaseTime <= #{endTime} ")
    void update5MinToBeReleasedNotice(@Param("status") int status,@Param("date") Date date, @Param("istatus") int istatus, @Param("endTime") String endTime);


}
