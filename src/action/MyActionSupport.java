package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 自定义的一些通用的变量和方法
 * @author 周灿桢
 *
 */
public class MyActionSupport extends ActionSupport{
	/**
	 * 返回首页
	 */
	public static String INDEX="index";
	/**
	 * 当前时间段没有课
	 */
	public static String NOCURRENTCLASS="no_current_class";
	public static String INFO="info";
	public static String CLASSINFO="classinfo";
	protected ActionContext context = ActionContext.getContext();
	
	/**
	 * 直接返回显示主界面
	 */
	public String index(){
		return SUCCESS;
	}
	
	/**
	 * 以map的获取structs2官方封装的session
	 */
	protected Map getSession(){
		return context.getSession();
	}
	
	/**
	 * 以map的获取structs2官方封装的request
	 */
	protected Map getRequest(){
		return (Map)context.get("request");
	}
	
	/**
	 * 以map的获取structs2官方封装的application
	 */
	protected Map getApplication(){
		return context.getApplication();
	}
}
