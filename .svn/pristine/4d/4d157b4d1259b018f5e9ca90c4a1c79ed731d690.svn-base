package com.caishen91.jupiter.authorize.util;

import com.caishen91.jupiter.authorize.enums.ResultEnums;
import com.caishen91.jupiter.authorize.vo.ResultVO;

public class ResultUtil {
	
	public ResultUtil() {}

    public static ResultVO success(Object obj){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnums.SUCCESS.getCode());
        resultVO.setMsg(ResultEnums.SUCCESS.getMsg());
        resultVO.setData(obj);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(int code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }
}
