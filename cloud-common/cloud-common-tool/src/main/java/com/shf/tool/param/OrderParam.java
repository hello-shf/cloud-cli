package com.shf.tool.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/11/28 16:30
 * @Version V1.0
 **/
@Data
@ApiModel(value = "通用查询参数",description = "通用查询参数")
public class OrderParam {
    /**
     * 排序 - 排序字段
     */
    @ApiModelProperty(value="可选-排序字段",name="orderField")
    private String orderField;
    /**
     * 排序 - 排序方式 默认false，有orderField字段，asc自动生效
     */
    @ApiModelProperty(value="可选-排序方式",name="asc")
    private boolean asc;
}
