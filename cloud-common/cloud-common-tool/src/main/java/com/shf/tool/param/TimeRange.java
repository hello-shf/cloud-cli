package com.shf.tool.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/11/28 16:32
 * @Version V1.0
 **/
@Data
@ApiModel(value = "通用查询参数",description = "通用查询参数")
public class TimeRange {
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
