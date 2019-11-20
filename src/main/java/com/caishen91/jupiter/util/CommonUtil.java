package com.caishen91.jupiter.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.caishen91.jupiter.vo.MobileARListVO;

public class CommonUtil {

	/**
     * 	正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	
	/**
	 * 	【列表查询】 Page参数组装
	 * 
	 * @param paramMap
	 * @param pageNo
	 * @param perPageNo
	 * @return
	 */
	public static Map<String, Object> pageParam(String  pageNo,String perPageNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		try {
            int pageNoInt = Integer.parseInt(pageNo);
            int perPageNoInt = Integer.parseInt(perPageNo);
            int offset = (pageNoInt - 1) * perPageNoInt;
            paramMap.put("offset", offset);
            paramMap.put("pageCount", perPageNoInt);
        } catch (Exception e) {
            e.printStackTrace();
            paramMap.put("offset", 0);
            paramMap.put("pageCount", 10);
        }
		return paramMap;
	}
	
	/**
	 * 	【文章列表】时间处理
	 * @param arList
	 * @return
	 */
	public static List<MobileARListVO> paramAssem(List<MobileARListVO> arList) {
    	for (MobileARListVO mobileARListVO : arList) {
    		mobileARListVO.setArId(IDEncryptor.getInstance().encryptWithoutException(Integer.valueOf(mobileARListVO.getArId())));
    		String currentYear= DateUtil.formatDate(new Date(), "yyyy");
            String arTime=DateUtil.formatDate(mobileARListVO.getTime(), "yyyy");
    		long timeDiff = new Date().getTime() - mobileARListVO.getTime().getTime();
            if(timeDiff < 60000){
                mobileARListVO.setTimeDesc("刚刚");
            }else if(timeDiff < 3600000){
                mobileARListVO.setTimeDesc((timeDiff / 1000 / 60 ) + "分钟前");
            }else if(timeDiff > 3600000 && timeDiff < 3600000*24){
                mobileARListVO.setTimeDesc((timeDiff / 1000 / 60 / 60 ) + "小时前");
            }else if(timeDiff > 3600000*24 && timeDiff < 3600000*24*3){
                mobileARListVO.setTimeDesc((timeDiff / 1000 / 60 / 60/ 24 ) + "天前");
            }else if(timeDiff > 3600000*24*3 && arTime.equals(currentYear)){
                mobileARListVO.setTimeDesc(DateUtil.formatDate(mobileARListVO.getTime(), "MM-dd"));
            }else if(!arTime.equals(currentYear)){
                mobileARListVO.setTimeDesc(DateUtil.formatDate(mobileARListVO.getTime(), "yyyy-MM-dd"));
            }
		}
		return arList;
	}

	
	/**
	 * 	【Controller ResponseBody】 返回数据组装
	 * @param count
	 * @param list
	 * @return
	 */
	public static Map<String, Object> commonListData(int count,List list){
		Map<String, Object> data = new HashMap<>();
        data.put("totalRows", count);
        data.put("nav", "");
        data.put("content", list);
        return data;
	}
	
	/**
	 * 	分页查询
	 * @param params
	 * @param sb
	 * @return
	 */
	public static String queryListAndLimit(Map<String, Object> params,StringBuffer sb) {
		Integer offset = (Integer)params.get("offset");
        Integer pageCount = (Integer)params.get("pageCount");
        if(offset != null && pageCount != null){
            sb.append(" limit #{offset}, #{pageCount}  ");
        }
        return sb.toString();
	}
	
	/**
	 * 	验证字符串是否为正整数
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
	}
	
	
	/**
	 * 	生成编号
	 */
    public static String gennumber() {
        String dt = DateUtil.formatDate(new Date(), "yyyyMMddHHmm");

        int sq = (int)(Math.random() * 1000);

        NumberFormat nf = new DecimalFormat("0000");

        return dt + nf.format(sq);
    }
    
    /**
     * 	校验手机号
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
}
