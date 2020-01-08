package com.shf.tool.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/11/28 16:29
 * @Version V1.0
 **/
@Data
@ApiModel(value = "通用查询参数",description = "通用查询参数")
public class PageParam {
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
}
