package com.shf.tool.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：通用查询参数
 *
 * @Author shf
 * @Date 2019/4/24 10:46
 * @Version V1.0
 **/
@Data
@ApiModel(value = "通用查询参数",description = "通用查询参数")
public class CommParam {
    /**
     * 分页 - 页码
     */
    @ApiModelProperty(value="页码",name="pageIndex")
    private Integer pageIndex;
    /**
     * 分页 - 每页个数
     */
    @ApiModelProperty(value="单页数量",name="pageSize")
    private Integer pageSize;
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
    /**
     * 开始时间
     */
    @ApiModelProperty(value="开始时间",name="timeStart")
    private String timeStart;
    /**
     * 结束时间
     */
    @ApiModelProperty(value="结束时间",name="timeEnd")
    private String timeEnd;
}
