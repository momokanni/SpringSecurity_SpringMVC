package com.caishen91.jupiter.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: jgn
 * @Date: 3/14/19 17 42
 * Description:会员controller
 */

@Controller
@RequestMapping("/manager/member")
public class MemberController {

    @Autowired
    private HttpServletRequest request;


    @RequestMapping("/toMember")
    public String toMember(){
        return "/manager/member/memberPage";
    }

    @RequestMapping("/toAddMember")
    public String toAddMember() {
        return "/manager/member/addMemberPage";
    }

}
