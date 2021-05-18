package com.lvhongli.service.impl;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.dao.*;
import com.lvhongli.model.*;

import com.lvhongli.pojo.HouseForm;
import com.lvhongli.pojo.HouseParam;
import com.lvhongli.pojo.PhotoForm;
import com.lvhongli.service.HouseService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private HousePictureRepository housePictureRepository;
    @Autowired
    private HouseDetailRepository houseDetailRepository;
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HouseTagRepository houseTagRepository;
    @Autowired
    private SupportAddressRepository supportAddressRepository;
    @Autowired
    private SubwayRepository subwayRepository;
    @Autowired
    private SubwayStationRepository subwayStationRepository;
    @Override
    @Transactional
    public ResultMsg add(HouseForm houseForm) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByName(name);
        if (user==null){
            return ResultMsg.fail("找不到当前登录用户信息");
        }
        House house = new House();
        BeanUtils.copyProperties(houseForm,house);
        house.setCreateTime(new Date());
        house.setLastUpdateTime(new Date());
        house.setAdminId(user.getId());
        house.setBathroom(0);
        house.setStatus(0);
        houseRepository.save(house);
        HouseDetail houseDetail = new HouseDetail();
        BeanUtils.copyProperties(houseForm,houseDetail);
        houseDetail.setHouseId(house.getId());
        if (houseDetail.getSubwayLineId()!=null){
            Optional<Subway> subway = subwayRepository.findById(houseDetail.getSubwayLineId());
            if (subway.isPresent()) {
                houseDetail.setSubwayLineName(subway.get().getName());
            }
        }
        if (houseDetail.getSubwayStationId()!=null){
            Optional<SubwayStation> subwayStation = subwayStationRepository.findById(houseDetail.getSubwayStationId());
            if (subwayStation.isPresent()) {
                houseDetail.setSubwayLineName(subwayStation.get().getName());
            }
        }
        List<HousePicture> list=new ArrayList<>();
        houseForm.getPhotos().stream().forEach(v->{
            HousePicture housePicture = new HousePicture();
            BeanUtils.copyProperties(v,housePicture);
            housePicture.setHouseId(house.getId());
            list.add(housePicture);
        });
        List<HouseTag> tags=new ArrayList<>();
        if (houseForm.getTags()!=null){
            for (String tag : houseForm.getTags()) {
                HouseTag houseTag = new HouseTag();
                houseTag .setHouseId(house.getId());
                houseTag.setName(tag);
                tags.add(houseTag);
            }
        }
        houseDetailRepository.save(houseDetail);
        housePictureRepository.saveAll(list);
        houseTagRepository.saveAll(tags);
        return ResultMsg.success();
    }


    @Override
    public Map findAll(HouseParam param) {
        PageRequest pageRequest =  PageRequest.of(param.getStart()/param.getLength(), param.getLength(), Sort.Direction.valueOf(param.getDirection().toUpperCase()),param.getOrderBy());
        Page page = houseRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                Predicate predicate = null;
                String name = SecurityContextHolder.getContext().getAuthentication().getName();
                User user = repository.findByName(name);
                if (user == null) {
                    return null;
                }
                predicate = cb.equal(root.get("adminId"), user.getId());
                if (param.getCity() != null) {
                    predicate = cb.and(predicate, cb.equal(root.get("cityEnName"), param.getCity()));
                }

                if (param.getStatus() != null) {
                    predicate = cb.and(predicate, cb.equal(root.get("status"), param.getStatus()));
                }

                if (param.getCreateTimeMin() != null) {
                    predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("createTime"), param.getCreateTimeMin()));
                }

                if (param.getCreateTimeMax() != null) {
                    predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("createTime"), param.getCreateTimeMax()));
                }

                if (param.getTitle() != null) {
                    predicate = cb.and(predicate, cb.like(root.get("title"), "%" + param.getTitle() + "%"));
                }
                predicate = cb.and(predicate, cb.notEqual(root.get("status"), 3));
                return predicate;
            }
        }, pageRequest);
       return new  HashMap(){{
            put("draw",param.getDraw());
            put("recordsTotal",page.getTotalElements());
            put("recordsFiltered",page.getTotalElements());
            put("data",page.getContent());
        }};
    }

    @Override
    @Transactional
    public ResultMsg update(Long id, Integer status) {
        Optional<House> optional = houseRepository.findById(id);
        if (!optional.isPresent()){
            return ResultMsg.fail();
        }
        optional.get().setStatus(status);
        return ResultMsg.success();
    }

    @Override
    public House findOne(Long id) {
        Optional<House> house = houseRepository.findById(id);
        if (house.isPresent())
            return house.get();
        return null;
    }

    @Override
    public HouseDetail findByDetail(Long id) {
        return houseDetailRepository.findByHouseId(id);
    }

    @Override
    public List<HouseTag> findByHouseTag(Long id) {
        return houseTagRepository.findAllByHouseId(id);
    }

    @Override
    public List<HousePicture> findByHousePicture(Long id) {
        return housePictureRepository.findAllByHouseId(id);
    }

    @Override
    public SupportAddress findByCity(String cityEnName) {
        return supportAddressRepository.findByEnNameAndLevel(cityEnName,"city");
    }

    @Override
    public SupportAddress findByRegion(String regionEnName) {
        return supportAddressRepository.findByEnNameAndLevel(regionEnName,"region");
    }

    @Override
    @Transactional
    public ResultMsg addTag(HouseTag tag) {
        houseTagRepository.save(tag);
        return ResultMsg.success();
    }

    @Override
    public ResultMsg deleteTag(HouseTag tag) {
        tag= houseTagRepository.findByHouseIdAndName(tag.getHouseId(), tag.getName());
        houseTagRepository.delete(tag);
        return ResultMsg.success();
    }


    @Override
    public ResultMsg deletePhoto(Long id) {
        housePictureRepository.deleteById(id);
        return ResultMsg.success();
    }


    @Transactional
    @Override
    public ResultMsg cover(String coverId, Long houseId) {
        houseRepository.updateCover(coverId,houseId);
        return ResultMsg.success();
    }


    @Override
    @Transactional
    public ResultMsg edit(HouseForm houseForm) {
        if (houseForm==null||houseForm.getId()==null)
            return ResultMsg.fail();
        Optional<House> optional = houseRepository.findById(houseForm.getId());
        if (!optional.isPresent()){
            return ResultMsg.fail();
        }
        House house = optional.get();
        BeanUtils.copyProperties(houseForm,house);
        house.setLastUpdateTime(new Date());
        //保存详情
        HouseDetail detail = houseDetailRepository.findByHouseId(house.getId());
        if (detail!=null){
            detail.setSubwayLineName(houseForm.getSubwayLineName());
            detail.setSubwayLineId(houseForm.getSubwayLineId());
            detail.setDescription(houseForm.getDescription());
            detail.setDetailAddress(houseForm.getDetailAddress());
            detail.setLayoutDesc(houseForm.getLayoutDesc());
            detail.setRentWay(houseForm.getRentWay());
            detail.setRoundService(houseForm.getRoundService());
            detail.setSubwayStationId(houseForm.getSubwayStationId());
            detail.setSubwayStationName(houseForm.getSubwayStationName());
            detail.setTraffic(houseForm.getTraffic());
            houseDetailRepository.save(detail);
        }
        //保存主题

        //保存图片
        List<PhotoForm> photos = houseForm.getPhotos();
        if (photos!=null&&photos.size()!=0){
            List<HousePicture> collect = photos.stream().map(v -> {
                HousePicture picture = new HousePicture();
                picture.setHouseId(house.getId());
                picture.setHeight(v.getHeight());
                picture.setWidth(v.getWidth());
                picture.setPath("http://localhsot:8131/upload/" + v.getPath());
                return picture;
            }).collect(Collectors.toList());
            housePictureRepository.saveAll(collect);
        }
        houseRepository.save(house);
        return ResultMsg.success();
    }

}
