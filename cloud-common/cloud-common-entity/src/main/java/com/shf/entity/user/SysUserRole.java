package com.shf.entity.user;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.shf.tool.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 描述：实体
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@ApiModel(value = "查询参数",description = "查询参数")
@TableName(value="sys_user_role")
@Data
public class SysUserRole extends BaseModel<SysUserRole> {

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="",name="id")
	private Integer id;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value="用户ID",name="userId")
	private Integer userId;
	/**
	 * 角色ID
	 */
	@ApiModelProperty(value="角色ID",name="roleId")
	private Integer roleId;
}
