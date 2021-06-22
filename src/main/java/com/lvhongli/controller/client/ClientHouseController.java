package com.lvhongli.controller.client;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.dao.SupportAddressRepository;
import com.lvhongli.es.EsHouseDto;
import com.lvhongli.es.EsSearchPojo;
import com.lvhongli.model.HouseSubscribe;
import com.lvhongli.model.Rental;
import com.lvhongli.model.User;
import com.lvhongli.pojo.RentSearch;
import com.lvhongli.pojo.RoomConfigEnum;
import com.lvhongli.service.ClientHouseService;
import com.lvhongli.service.impl.SystemUserServiceImpl;
import com.lvhongli.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/client/house")
@Api("客户端-用户api")
public class ClientHouseController {

    @Autowired
    private ClientHouseService service;

    @Autowired
    private SupportAddressRepository supportAddressRepository;

    @Autowired
    private SystemUserServiceImpl userService;

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
            put("cnName",supportAddressRepository.findByEnNameCity(rentSearch.getCityEnName()).getCnName());
        }});
        model.addAttribute("searchBody",rentSearch);
        Page page = service.search(rentSearch);
        model.addAttribute("total",page.getTotalElements());
        model.addAttribute("houses",page.getContent());
        return "rent-list";
    }


    @GetMapping("/search")
    @ApiOperation(value = "搜索", notes = "")
    @ResponseBody
    @ApiResponses({
            @ApiResponse(code = 200, message = "搜索", response = EsSearchPojo.class),
    })
    public ResultMsg search(RentSearch rentSearch){
        return ResultMsg.success( service.search(rentSearch));
    }

    @GetMapping("/selectById/{id}")
    @ApiOperation(value = "查看详情页", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查看详情页", response = String.class),
    })
    public  String selectById(@PathVariable Long id, HttpServletRequest request){
       EsHouseDto esHouseDto= service.selectById(id);
       if (esHouseDto==null){
           return "404";
       }
       User user=userService.selectById( esHouseDto.getAdminId());
       Integer subscribeStatus=service.getSubscribeStatus(esHouseDto.getId(),UserUtil.getUserId().getId());
        Long count=service.houseCount(esHouseDto);
       request.setAttribute("house",esHouseDto);
       request.setAttribute("user",user);
       request.setAttribute("subscribeStatus",subscribeStatus);
        request.setAttribute("subscribeCount",count);
       return "house-detail";
    }
}
