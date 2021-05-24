//package com.lvhongli;
//
//import com.lvhongli.dao.HouseTagRepository;
//import com.lvhongli.dao.UploadFileRepository;
//import com.lvhongli.model.HouseTag;
//import com.lvhongli.model.UploadFile;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.UUID;
//
//
//@SpringBootTest
//class SoufunApplicationTests {
//
//    @Autowired
//    private UploadFileRepository uploadFileRepository;
//    @Autowired
//    private HouseTagRepository houseTagRepository;
//    @Test
//    @Transactional
//    public  void  test() {
//        UploadFile file = new UploadFile();
//        file.setId(UUID.randomUUID().toString());
//        file.setName("啥事文件");
//        file.setRemark("备注");
//        file.setSuffix(".jpg");
//        file.setType("UploadFileType.audioFrequency");
//        file.setCreateTime(new Date());
//        file.setUpdateTime(new Date());
//        uploadFileRepository.save(file);uploadFileRepository.flush();
//    }
//
//    @Test
//    public  void  test1() {
//        for (HouseTag houseTag : houseTagRepository.findAllByHouseId(30l)) {
//            System.out.println("*"+houseTag);
//        }
//
//    }
//}
