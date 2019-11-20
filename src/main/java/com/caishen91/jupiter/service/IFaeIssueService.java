package com.caishen91.jupiter.service;

import com.caishen91.jupiter.model.FaeIssue;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jgn
 * @Date: 2/26/19 16 43
 * Description:
 */
public interface IFaeIssueService {

    List<FaeIssue> getFaeIssueByName(String keys);

    void addFaeIssue(FaeIssue faeIssue);

    List<FaeIssue> getFaeIssueByCliqueId(int cliqueId);

    int getFaeIssueCountByCliqueId(int cliqueId);

    int queryFaeIssueCountByParam(Map<String, Object> paramMap);

    List<FaeIssue> queryFaeIssueListByParam(Map<String, Object> paramMap);

    FaeIssue getFaeIssueById(int issueId);

    FaeIssue getFaeIssueByCreditCode(String creditCode);

    int getCountIssue();

    void setSysUserId(int sysUserId);
}
