package com.mmall.controller.backend;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage/order")
public class OrderManageController {

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> orderList(HttpSession session,
                                              @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){

    }
}
