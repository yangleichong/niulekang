package com.zrkc.util;

import java.util.List;
import java.util.Map;
import java.util.Set;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.zrkc.crm.model.DataModel;

public class ModelAndViewUtil {
	/**
	 * 返回view
	 * @param path
	 * @return
	 */
	public static ModelAndView view(String path){
		return new ModelAndView( path );
	}
	/**
	 * 返回view(携带提示信息)
	 * @param path
	 * @param mess
	 * @return
	 */
	public static ModelAndView view(String path,String mess){
		ModelAndView mav = new ModelAndView(path);
		mav.addObject("mess", mess);
		return mav;
	}
	/**
	 * 返回view(携带列表数据)
	 * @param path
	 * @param dm
	 * @return
	 */
	public static ModelAndView view(String path,DataModel<?> dm ){
		ModelAndView mav = new ModelAndView(path);
		mav.addObject("pager", dm.getPager());
		mav.addObject("rows", dm.getRows());
		return mav;
	}
	/**
	 * 返回view(携带数据)
	 * @param path
	 * @param map
	 * @return
	 */
	public static ModelAndView view( String path,Map<String ,Object> map ){
		ModelAndView mav = new ModelAndView(path);
		Set<String> keySet = map.keySet();
		for( String key : keySet){
			mav.addObject(key, map.get(key));
		}
		return mav ;
	}
	/**
	 * result = 1 为正确结果
	 * result = 0 错误结果
	 * */
	public static ModelAndView Json_ok(){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "1");
		return mav ;
	}
	
	public static ModelAndView Json_ok( String message ){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "1");
		mav.addObject("mess", message);
		return mav ;
	}
	
	public static ModelAndView Json_ok(String key , Object obj){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "1");
		mav.addObject(key, obj);
		return mav ;
	}
	
	public static ModelAndView Json_ok( List<?> list ){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "1");
		mav.addObject("list", list);
		return mav ;
	}

	public static ModelAndView Json_ok( Map<String ,Object> map ){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "1");
		Set<String> keySet = map.keySet();
		for( String key : keySet){
			mav.addObject(key, map.get(key));
		}
		return mav ;
	}
	
	public static ModelAndView Json_ok( DataModel<?> dm ){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "1");
		mav.addObject("pager", dm.getPager());
		mav.addObject("rows", dm.getRows());
		return mav ;
	}
	
	public static ModelAndView Json_error(){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "0");
		return mav ;
	}
	
	public static ModelAndView Json_error( String message ){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "0");
		mav.addObject("mess", message);
		return mav ;
	}
	public static ModelAndView Json_error( String message,Integer result ){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", result);
		mav.addObject("mess", message);
		return mav ;
	}
	public static ModelAndView Json_error2( String message ){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "2");
		mav.addObject("mess", message);
		return mav ;
	}
	
	// 返回错误状态2
	public static ModelAndView Json_error2(){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "2");
		return mav ;
	}
	
	public static ModelAndView Json_error(String key , Object obj){
		ModelAndView mav = new ModelAndView( new MappingJacksonJsonView());
		mav.addObject("result", "0");
		mav.addObject(key, obj);
		return mav ;
	}

	
}
