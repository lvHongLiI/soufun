package com.lvhongli.es;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ESRepository extends ElasticsearchRepository<EsHouseDto,Integer> {


}
