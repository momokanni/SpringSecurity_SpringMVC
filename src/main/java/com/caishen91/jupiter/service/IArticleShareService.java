package com.caishen91.jupiter.service;

import java.util.Date;
import java.util.Map;

public interface IArticleShareService {

	int add(int arId);

	Integer getArIdById(int shareId);

	int queryShareCountByParamMap(Map<String, Object> paramMap);

	void deleteShareByArId(int arId);

	int updateBatchShareStatusById(String arIds, int blogId, int currentShare,int expectShare, String fomatToYYYY_MM_dd_HH_mm_ss, String otherStatus);

	void deleteBatchShareByArId(String arIds);

	void update5MinToBeShare(String endTime);

	int updateShareStatusById(String valueOf, int blogId, int currentShare, int expectShare,
			String fomatToYYYY_MM_dd_HH_mm_ss, String otherStatus);

}
