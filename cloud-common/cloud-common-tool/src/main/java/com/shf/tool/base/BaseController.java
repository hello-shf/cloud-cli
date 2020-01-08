package com.shf.tool.base;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.shf.tool.param.CommParam;
import com.shf.tool.utils.Rs;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * @author:shf
 * @date: 2018/1/3 0003
 */
public class BaseController<S extends IService<T>, T extends BaseModel<T>> {
	@Autowired
	protected S service;

	/**
	 * 条件查询数据
	 * @param t
	 * @return
	 */
	@ApiOperation("多条查询")
	@RequestMapping("/list")
	public Rs baseGetAllData(T t, CommParam param) {
		EntityWrapper<T> wrapper = new EntityWrapper<T>();
		Field[] fields = t.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				fields[i].setAccessible(true);
				Object value = fields[i].get(t);
				if (null != value && !value.equals("")) {
					String fieldName = StrUtil.toUnderlineCase(fields[i].getName());
					wrapper.eq(fieldName, value.toString());
				}
				fields[i].setAccessible(false);
			} catch (Exception e) {
				return Rs.error();
			}
		}
		if(!StrUtil.isEmpty(param.getOrderField())){
			wrapper.orderBy(param.getOrderField(), param.isAsc());
		}
		return Rs.ok().setData(service.selectList(wrapper));
	}


	/**
	 * 条件查询数据
	 * @param t
	 * @return
	 */
	@ApiOperation("单条查询")
	@RequestMapping("/single")
	public Rs baseQuerySingle(T t) {
		EntityWrapper<T> wrapper = new EntityWrapper<T>();
		Field[] fields = t.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				fields[i].setAccessible(true);
				Object value = fields[i].get(t);
				if (null != value && !value.equals("")) {
					String fieldName = StrUtil.toUnderlineCase(fields[i].getName());
					wrapper.eq(fieldName, value.toString());
				}
				fields[i].setAccessible(false);
			} catch (Exception e) {
				return Rs.error();
			}
		}
		return Rs.ok().setData(service.selectOne(wrapper));
	}

	/**
	 * 分页查询
	 */
	@ApiOperation("分页")
	@RequestMapping("/page")
	public Rs baseQueryByPage(T t, CommParam param){
		Map<String, Object> map = new HashMap<String, Object>();
		Page<T> page = new Page<>(param.getPageIndex(), param.getPageSize());
		EntityWrapper<T> wrapper = new EntityWrapper<T>();
		Field[] fields = t.getClass().getDeclaredFields();
		try {
			for(Field field:fields){
				field.setAccessible(true);
				Object value = field.get(t);
				if (null != value && !value.equals("")) {
					String fieldName = StrUtil.toUnderlineCase(field.getName());
					wrapper.like(fieldName, value.toString());
				}
			}
		} catch (IllegalAccessException e) {
			return Rs.error();
		}
		//排序
		if(!StrUtil.isEmpty(param.getOrderField())){
			wrapper.orderBy(param.getOrderField(), param.isAsc());
		}
		//范围查询
		if(StrUtil.isNotEmpty(param.getTimeStart())){
			wrapper.ge("create_time", param.getTimeStart());
		}
		if(StrUtil.isNotEmpty(param.getTimeEnd())){
			wrapper.le("create_time", param.getTimeEnd());
		}
		page = service.selectPage(page, wrapper);
		List<T> list = page.getRecords();
		map.put("list", list);
		map.put("total", page.getTotal());
		return Rs.ok().setData(map);
	}
	/**
	 * 新增
	 * @param t
	 * @return
	 */
	@ApiOperation("新增")
	@RequestMapping("/add")
	@Transactional
	public Rs baseCreate(T t) {
		service.insert(t);
		return Rs.ok();
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ApiOperation("删除")
	@RequestMapping("/delete")
	public Rs baseDelete(String id) {
		if(NumberUtil.isNumber(id)){
			service.deleteById(Integer.valueOf(id));
		}else{
			service.deleteById(id);
		}
		return Rs.ok();
	}
	/**
	 * 更新
	 * @param t
	 * @return
	 */
	@ApiOperation("更新")
	@RequestMapping("/update")
	@Transactional
	public Rs baseUpdate(T t) {
		service.updateById(t);
		return Rs.ok();
	}
}
