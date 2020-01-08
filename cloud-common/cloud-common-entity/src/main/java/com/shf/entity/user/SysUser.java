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
@TableName(value="sys_user")
@Data
public class SysUser extends BaseModel<SysUser> {

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="",name="id")
	private Integer id;
	/**
	 * 账号
	 */
	@ApiModelProperty(value="账号",name="username")
	private String username;
	/**
	 * 密码
	 */
	@ApiModelProperty(value="密码",name="password")
	private String password;
	/**
	 * 昵称
	 */
	@ApiModelProperty(value="昵称",name="nickname")
	private String nickname;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(value="邮箱",name="email")
	private String email;
	/**
	 * 状态（0：锁定，1：解锁）
	 */
	@ApiModelProperty(value="状态（0：锁定，1：解锁）",name="status")
	private Integer status;
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
