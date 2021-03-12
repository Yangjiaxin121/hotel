package com.hotel.controller.admin;

import com.github.pagehelper.PageInfo;
import com.hotel.common.ServerResponse;
import com.hotel.service.IAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/dream/admin/analyze")
public class AnalyzeAdminController {


    @Autowired
    IAnalyzeService iAnalyzeService;

    @RequestMapping("get_sex_num.do")
    @ResponseBody
    public ServerResponse getSexNum(){


        //填充我们增加产品的业务逻辑
        return iAnalyzeService.getSexNum();

    }

    @RequestMapping("get_order_analyze.do")
    @ResponseBody
    public ServerResponse getOrderAnalyze(){


        //填充我们增加产品的业务逻辑
        return iAnalyzeService.getOrderAnalyze();

    }

    @RequestMapping("get_room_analyze.do")
    @ResponseBody
    public ServerResponse getRoomAnalyze(){


        //填充我们增加产品的业务逻辑
        return iAnalyzeService.getRoomAnalyze();

    }

    @RequestMapping("get_age_num.do")
    @ResponseBody
    public ServerResponse getAgeNum(){


        return iAnalyzeService.getAgeNum();

    }


}
