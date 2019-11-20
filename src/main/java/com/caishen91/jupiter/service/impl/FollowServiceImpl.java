package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.dao.FollowMapper;
import com.caishen91.jupiter.service.IFollowService;
import com.caishen91.jupiter.vo.FollowVO;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl extends BaseService implements IFollowService {

	@Override
	public List<FollowVO> getFollowList(Map<String, Object> paramMap) {
		FollowMapper followMapper = writableSQLSession.getMapper(FollowMapper.class);
		return followMapper.getFollowList(paramMap);
	}

	@Override
	public int updateStatus(int uId, int blogId, int status,Date updateDate) {
		FollowMapper followMapper = writableSQLSession.getMapper(FollowMapper.class);
		return followMapper.updateStatus(uId,blogId,status,updateDate);
	}

	@Override
	public List<FollowVO> getPullUpFollowList(Map<String, Object> paramMap) {
		FollowMapper followMapper = writableSQLSession.getMapper(FollowMapper.class);
		return followMapper.getPullUpFollowList(paramMap);
	}

}
