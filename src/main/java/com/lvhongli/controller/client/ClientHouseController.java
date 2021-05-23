package com.lvhongli.controller.client;

import com.lvhongli.model.Rental;
import com.lvhongli.pojo.RentSearch;
import com.lvhongli.pojo.RoomConfigEnum;
import com.lvhongli.service.ClientHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/client/house")
@Api("客户端-用户api")
public class ClientHouseController {

    @Autowired
    private ClientHouseService service;

    @GetMapping("/list")
    @ApiOperation(value = "列表", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "列表", response = String.class),
    })
    public String list(RentSearch rentSearch, Model model){
        List<Rental> list = service.rentalAll();
        model.addAttribute("regions",service.findRegions(rentSearch.getCityEnName()));
        model.addAttribute("rentals",list);
        model.addAttribute("orientations",service.findRoomConfigByType(RoomConfigEnum.orientations));
        model.addAttribute("housetypes",service.findRoomConfigByType(RoomConfigEnum.housetype));
        model.addAttribute("areaBlocks",service.findAreas());
        model.addAttribute("currentCity",new HashMap(){{
            put("cnName","北京");
        }});
        model.addAttribute("searchBody",rentSearch);
        return "rent-list";
    }
}