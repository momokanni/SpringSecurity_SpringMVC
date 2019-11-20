package com.caishen91.jupiter.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.caishen91.jupiter.vo.FollowVO;

public interface FollowMapper {

	@Select("SELECT b.`id` AS id, b.`name` AS 'name', b.`description` AS 'desc', b.`headImg` AS headImg FROM blog b "
			+ " LEFT JOIN blog_focus bf ON bf.`blogId` = b.`id` WHERE bf.status = #{status} AND bf.userId = #{userId} ORDER BY bf.`createTime` DESC LIMIT #{offset}, #{pageCount}")
	List<FollowVO> getFollowList(Map<String, Object> paramMap);

	@Update("update blog_focus set status = #{status},updateTime = #{updateDate} where userId = #{userId} and blogId = #{blogId}")
	int updateStatus(@Param("userId")int uId, @Param("blogId") int blogId, @Param("status") int status, @Param("updateDate") Date updateDate);

	@Select("SELECT b.`id` AS id, b.`name` AS 'name', b.`description` AS 'desc', b.`headImgMb` AS headImg FROM blog b "
			+ "LEFT JOIN blog_focus bf ON bf.`blogId` = b.`id` WHERE bf.status = #{status} AND bf.userId = #{userId} AND bf.createTime < #{endTime} ORDER BY bf.`createTime` ASC")
	List<FollowVO> getPullUpFollowList(Map<String, Object> paramMap);

}
