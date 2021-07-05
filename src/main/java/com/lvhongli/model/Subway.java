package com.lvhongli.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by 瓦力.
 */
@Entity
@Table(name = "subway")
@Data
public class Subway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @ApiModelProperty(value = "名称", example = "1号线")
    private String name;

    @JoinColumn(name = "support_address_id")
    @ApiModelProperty(value = "城市", example = "北京市")
    @ManyToOne
    private SupportAddress city;

}
