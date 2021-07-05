package com.lvhongli.controller.admin;

import com.lvhongli.configure.ResultMsg;

import com.lvhongli.model.House;
import com.lvhongli.model.HouseDetail;
import com.lvhongli.model.HousePicture;
import com.lvhongli.model.HouseTag;
import com.lvhongli.pojo.HouseForm;
import com.lvhongli.pojo.HouseParam;
import com.lvhongli.service.HouseService;
import com.lvhongli.service.impl.SystemUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Api("后台-房源管理api")
@Controller
@RequestMapping("/admin/house")
public class HouseController {

    @Autowired
    private HouseService service;

    @PostMapping("/add")
    @ResponseBody
    public ResultMsg add(HouseForm house){
        return  service.add(house);
    }


    @PostMapping("/findAll")
    @ResponseBody
    public Map findAll(HouseParam param){
        return service.findAll(param);
    }

    @PutMapping("/update/{id}/{status}")
    @ResponseBody
    public ResultMsg update(@PathVariable("id") Integer id,@PathVariable("status")Integer status){
        return service.update(id,status);
    }

    @GetMapping("/edit")
    @ApiOperation(value = "房源编辑页面", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "房源编辑页面", response = String.class),
    })
    public String houseEdit(Integer id, Model model){
        if (id==null){
            return "404";
        }
        House house=service.findOne(id);
        if (house==null){
            return "404";
        }
        //查询城市信息
        model.addAttribute("house",house);
        model.addAttribute("houseDetail",service.findByDetail(id));
        model.addAttribute("houseTags",service.findByHouseTag(id).stream().map(s->s.getName()).toArray());
        model.addAttribute("pictures",service.findByHousePicture(id));
        model.addAttribute("city",house.getCity());
        model.addAttribute("region",house.getRegion());
        return "admin/house-edit";
    }

    @PostMapping("/addTag")
    @ApiOperation(value = "添加标签", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = ResultMsg.class),
    })
    @ResponseBody
    public ResultMsg addTag(HouseTag tag){
        return service.addTag(tag);
    }

    @DeleteMapping("/deleteTag")
    @ApiOperation(value = "删除标签", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = ResultMsg.class),
    })
    @ResponseBody
    public ResultMsg deleteTag(HouseTag tag){
        return service.deleteTag(tag);
    }


    @DeleteMapping("/deletePhoto")
    @ApiOperation(value = "删除图片", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = ResultMsg.class),
    })
    @ResponseBody
    public ResultMsg deletePhoto(Integer id){
        return service.deletePhoto(id);
    }

    @PostMapping("/cover")
    @ApiOperation(value = "删除图片", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = ResultMsg.class),
    })
    @ResponseBody
    public ResultMsg cover(String coverId,Integer houseId){
        return service.cover(coverId,houseId);
    }

    @PostMapping("/edit")
    @ApiOperation(value = "保存编辑", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = ResultMsg.class),
    })
    @ResponseBody
    public ResultMsg edit( HouseForm houseForm){
        return service.edit(houseForm);
    }
}
