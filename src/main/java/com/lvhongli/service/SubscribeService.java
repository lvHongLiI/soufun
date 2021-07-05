package com.lvhongli.service;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.pojo.SubscribeParam;

import java.util.Map;

public interface SubscribeService {

    Map findAll(SubscribeParam param);
}
