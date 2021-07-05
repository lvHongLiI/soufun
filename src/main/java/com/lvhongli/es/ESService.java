package com.lvhongli.es;

import com.lvhongli.pojo.RentSearch;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.valuecount.InternalValueCount;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilterBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class ESService {

    @Autowired
    private ESRepository esRepository;

    @Autowired
    private ElasticsearchTemplate template;

    private final List<String> searchField= Arrays.asList("title","district","description","layoutDesc","traffic","roundService");

    public void deleteById(Integer id){
        esRepository.deleteById(id);
    }

    public EsHouseDto create(EsHouseDto esHouseDto){
      return  esRepository.save(esHouseDto);
    }


    public Page<EsHouseDto> search(RentSearch search){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        //1.设置搜索字段
        if (!StringUtils.isEmpty(search.getKeywords())){
            for (String field : searchField) {
               boolQuery.should(QueryBuilders.matchQuery(field,search.getKeywords()));
            }
        }
        //2.设置过滤字段
        BoolQueryBuilder filterBuilder = QueryBuilders.boolQuery();
        if (search.getCityId()!=null){
            filterBuilder.must(QueryBuilders.matchQuery("cityId",search.getCityId()));
        }
        if (search.getRegionId()!=null){
            filterBuilder.must(QueryBuilders.matchQuery("regionId",search.getRegionId()));
        }
        if (search.getDirection()!=null){
            filterBuilder.must(QueryBuilders.matchQuery("roomDirection",search.getDirection()));
        }
        if (search.getRentWay()!=null){
            filterBuilder.must(QueryBuilders.matchQuery("rentalWay",search.getRentWay()));
        }
        if (search.getRoom()!=null){
            filterBuilder.must(QueryBuilders.matchQuery("room",search.getRoom()));
        }
        if (search.getPriceBlock()!=null&& Pattern.matches("^\\d{0,5}[`\\-]\\d{0,5}$",search.getPriceBlock())){
            String[] split = search.getPriceBlock().split("`|-");
            RangeQueryBuilder price = QueryBuilders.rangeQuery("price");
            if (!split[0].equals("0")){
                price.gte(split[0]);
            }
            if (!split[1].equals("0")){
                price.lte(split[1]);
            }
            filterBuilder.must(price);
        }
        if (search.getAreaBlock()!=null&& Pattern.matches("^\\d{0,5}[`\\-]\\d{0,5}$",search.getAreaBlock())){
            String[] split = search.getAreaBlock().split("`|-");
            RangeQueryBuilder roomArea = QueryBuilders.rangeQuery("roomArea");
            if (!split[0].equals("0")){
                roomArea.gte(split[0]);
            }
            if (!split[1].equals("0")){
                roomArea.lte(split[1]);
            }
            filterBuilder.must(roomArea);
        }
        //3.分页和高亮
        queryBuilder.withPageable(PageRequest.of(search.getStart(),search.getSize(), Sort.by(Sort.Direction.valueOf(search.getOrderDirection()),search.getOrderBy())));
        queryBuilder.withQuery(boolQuery);
        queryBuilder.withFilter(filterBuilder);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        for (String field : searchField) {
            highlightBuilder.field(field);
        }

       queryBuilder.withHighlightFields(highlightBuilder.fields().toArray(new HighlightBuilder.Field[highlightBuilder.fields().size()]));
        return esRepository.search(queryBuilder.build());
    }


    public EsHouseDto searchById(Integer id) {
        Optional<EsHouseDto> optional = esRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }


    public Long houseCount(Map map){
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        map.forEach((k,v)->{query.must().add(QueryBuilders.matchQuery(k.toString(),v));});
        builder.withFilter(query);
        builder.addAggregation(AggregationBuilders.count("count").field("id"));
        AggregatedPage<EsHouseDto> aggregated = template.queryForPage(builder.build(), EsHouseDto.class);
        InternalValueCount count= (InternalValueCount) aggregated.getAggregation("count");
       return count.getValue();
    }
}
