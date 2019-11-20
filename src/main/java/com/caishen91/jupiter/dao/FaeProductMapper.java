package com.caishen91.jupiter.dao;

import com.caishen91.jupiter.model.FaeProduct;
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
public interface FaeProductMapper {

   
  /*productType,productName,issueId,underwriterId,danbaoId,entrustedId,
  raiseAmount,term,termUnit,expectRate,baseAmount,increaseAmount,buyType,
  holdCalType,endDate,dueDate,trans,lockTerm,lockUnit,minEstablishAmount,establishType,
  establishDay,yearCalType,settlementType,fixed,fixedMonth,fixedDay,hasHang,hangMinFee,
  hangRate,hangFeeType,hasCx,cxMinFee,cxRate,cxFeeType,hasDanbao,danbaoMinFee,danbaoRate,
  danbaoFeeType,amountUse,increaseCredit,remark*/





    @Insert("insert into fae_product (" +
            "  productType,productName,issueId,underwriterId,danbaoId,entrustedId," +
            "  raiseAmount,term,termUnit,expectRate,baseAmount,increaseAmount,buyType," +
            "  holdCalType,endDate,dueDate,trans,lockTerm,lockUnit,minEstablishAmount,establishType," +
            "  establishDay,yearCalType,settlementType,fixed,fixedMonth,fixedDay,hasHang,hangMinFee," +
            "  hangRate,hangFeeType,hasCx,cxMinFee,cxRate,cxFeeType,hasSt,stMinFee,stRate," +
            "  stFeeType,amountUse,increaseCredit,remark,createTime,hangYjDay,cxYjDay,stYjDay" +
            ")values(" +
            "  #{productType},#{productName},#{issueId},#{underwriterId},#{danbaoId},#{entrustedId}," +
            "  #{raiseAmount},#{term},#{termUnit},#{expectRate},#{baseAmount},#{increaseAmount},#{buyType}," +
            "  #{holdCalType},#{endDate},#{dueDate},#{trans},#{lockTerm},#{lockUnit},#{minEstablishAmount},#{establishType}," +
            "  #{establishDay},#{yearCalType},#{settlementType},#{fixed},#{fixedMonth},#{fixedDay},#{hasHang},#{hangMinFee}," +
            "  #{hangRate},#{hangFeeType},#{hasCx},#{cxMinFee},#{cxRate},#{cxFeeType},#{hasSt},#{stMinFee},#{stRate}," +
            "  #{stFeeType},#{amountUse},#{increaseCredit},#{remark},#{createTime},#{hangYjDay},#{cxYjDay},#{stYjDay}" +
            ")")
    void saveProduct(FaeProduct product);

    @SelectProvider(type = FaeProductProvider.class,method = "queryCountFaeProductByParam")
    int queryCountFaeProductByParam(Map<String,Object> queryMap);

    @SelectProvider(type = FaeProductProvider.class,method = "queryFaeProductMapByParam")
    List<Map<String,Object>> queryFaeProductMapByParam(Map<String,Object> queryMap);

    @SelectProvider(type = FaeProductProvider.class,method = "queryFaeProductByParam")
    List<FaeProduct> queryFaeProductByParam(Map<String,Object> queryMap);

    @Select("SELECT * FROM fae_product WHERE id = #{id}")
    FaeProduct getFaeProductById(@Param("id") int id);
}
