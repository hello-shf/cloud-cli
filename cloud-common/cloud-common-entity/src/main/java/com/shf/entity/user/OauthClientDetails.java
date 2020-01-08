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
@TableName(value="oauth_client_details")
@Data
public class OauthClientDetails extends BaseModel<OauthClientDetails> {

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(value="",name="clientId")
	private String clientId;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="resourceIds")
	private String resourceIds;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="clientSecret")
	private String clientSecret;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="scope")
	private String scope;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="authorizedGrantTypes")
	private String authorizedGrantTypes;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="webServerRedirectUri")
	private String webServerRedirectUri;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="authorities")
	private String authorities;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="accessTokenValidity")
	private Integer accessTokenValidity;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="refreshTokenValidity")
	private Integer refreshTokenValidity;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="additionalInformation")
	private String additionalInformation;
	/**
	 * 
	 */
	@ApiModelProperty(value="",name="autoapprove")
	private String autoapprove;
}
