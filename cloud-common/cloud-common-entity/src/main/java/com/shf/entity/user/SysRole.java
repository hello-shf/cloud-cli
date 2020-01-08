package com.shf.entity.user;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.shf.tool.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 描述：实体
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@ApiModel(value = "查询参数",description = "查询参数")
@TableName(value="sys_role")
@Data
public class SysRole extends BaseModel<SysRole> {

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="",name="id")
	private Integer id;
	/**
	 * 角色名称
	 */
	@ApiModelProperty(value="角色名称",name="roleName")
	private String roleName;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="roleCode")
	private String roleCode;
	/**
	 * 角色描述
	 */
	@ApiModelProperty(value="角色描述",name="roleDescription")
	private String roleDescription;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="createUser")
	private String createUser;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="createTime")
	private Date createTime;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="updateUser")
	private String updateUser;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="updateTime")
	private Date updateTime;
}
