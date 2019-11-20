package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeRepayInfo;
import com.caishen91.jupiter.vo.FaeRepayInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 3/15/19 15 58
 * Description:
 */
public interface FaeRepayInfoMapper {

    @SelectProvider(type = FaeRepayInfoProvider.class,method = "queryFaeRepayInfoCountByParam")
    int queryFaeRepayInfoCountByParam(Map<String,Object> paramMap);

    @SelectProvider(type = FaeRepayInfoProvider.class,method = "queryFaeRepayInfoByParam")
    List<FaeRepayInfoVo> queryFaeRepayInfoByParam(Map<String,Object> paramMap);

    @Select("select * from fae_repay_info where id = #{id}")
    FaeRepayInfo getRepayInfoById(@Param("id") int id);

    @Update("update fae_repay_info set repayStatus = #{repayStatus} where id = #{id}")
    void updateRepayInfoStatus(FaeRepayInfo repayInfoById);


    @Select("select sum(repayPrincipal) from fae_repay_info where repayStatus in (0,1)")
    BigDecimal getNotRepayPrincipal();

    @SelectProvider(type = FaeRepayInfoProvider.class,method = "queryFaeRepayInfoCountMapByParam")
    Map queryFaeRepayInfoCountMapByParam(Map<String,Object> paramMap);
}
