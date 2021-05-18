package com.lvhongli.controller.client;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {


    @GetMapping({"/","/index"})
    @ApiOperation(value = "首页", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "首页", response = String.class),
    })
    public String index(Model model){
        model.addAttribute("name","嘿嘿");
        return "index";
    }
}
