package com.shf.jdbc.user.controller;

import com.shf.entity.user.OauthClientDetails;
import com.shf.jdbc.user.service.OauthClientDetailsService;
import com.shf.tool.base.BaseController;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 * @author: shf
 * @date: 2020-01-04 22:13:00
 * @version: V1.0
 */
@RestController
@RequestMapping("/oauthClientDetails")
public class OauthClientDetailsController extends BaseController<OauthClientDetailsService, OauthClientDetails> {

}
