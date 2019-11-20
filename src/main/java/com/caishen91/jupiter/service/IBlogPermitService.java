package com.caishen91.jupiter.service;

import java.util.List;
import java.util.Map;

import com.caishen91.jupiter.model.BlogMenuTree;
import com.caishen91.jupiter.model.BlogPermit;
import com.caishen91.jupiter.model.SubBmAuthTree;

public interface IBlogPermitService {

	List<Map<String, Object>> getCompanyDefaultPermit();

	List<Map<String, Object>> getPersonalDefaultPermit();

	BlogPermit getBlogPermitByUrl(String url);

	List<BlogMenuTree> getMenu(int blogId, int bmId);

	List<SubBmAuthTree> getBmAuth(int bmId, int normalManagerId, int blogId);
}
