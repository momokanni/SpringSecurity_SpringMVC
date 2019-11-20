package com.caishen91.jupiter.service;

import com.alibaba.fastjson.JSONObject;
import com.caishen91.jupiter.util.OperationResult;
import java.util.Map;

public interface IGrapesService {
	
    OperationResult addSysUser(Map<String,Object> map);

    OperationResult modifySysUser(JSONObject parse);
}
