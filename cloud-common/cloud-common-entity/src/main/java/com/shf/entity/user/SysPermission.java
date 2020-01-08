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
@TableName(value="sys_permission")
@Data
public class SysPermission extends BaseModel<SysPermission> {

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="",name="id")
	private Integer id;
	/**
	 * 父ID
	 */
	@ApiModelProperty(value="父ID",name="pid")
	private Integer pid;
	/**
	 * 资源类型（1：菜单，2：按钮，3：操作）
	 */
	@ApiModelProperty(value="资源类型（1：菜单，2：按钮，3：操作）",name="type")
	private Integer type;
	/**
	 * 资源名称
	 */
	@ApiModelProperty(value="资源名称",name="name")
	private String name;
	/**
	 * 资源标识（或者叫权限字符串）
	 */
	@ApiModelProperty(value="资源标识（或者叫权限字符串）",name="code")
	private String code;
	/**
	 * 资源URI
	 */
	@ApiModelProperty(value="资源URI",name="uri")
	private String uri;
	/**
	 * 序号
	 */
	@ApiModelProperty(value="序号",name="seq")
	private Integer seq;
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
