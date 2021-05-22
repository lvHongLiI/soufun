package com.lvhongli.pojo;

import com.lvhongli.model.House;
import com.lvhongli.model.HouseDetail;
import com.lvhongli.model.HousePicture;
import com.lvhongli.model.HouseTag;
import lombok.Data;

import java.util.List;

@Data
public class HouseData {


    private House house;

    private HouseDetail detail;

    private List<HousePicture> pictures;

    private List<HouseTag> tags;
}
