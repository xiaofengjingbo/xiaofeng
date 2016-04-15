package com.shxt.base.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware,ServletContextAware{
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext servletContext;
	protected Map<String, Object> session ;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	// 定义几个常量 SUCCESS NONE
	/** 针对于JSP的请求转发的常量 */
	protected final String DISPATCHER = "dispatcher";

	/** 针对于JSP的重定向的常量 */
	protected final String REDIRECT = "redirect";

	/** 针对于Action的请求转发的常量 */
	protected final String CHAIN = "chain";

	/** 针对于Action的重定向的常量 */
	protected final String REDIRECTACTION = "redirectAction";
	
	/** 针对于Ajax返回JSON数据的结果 */
	protected final String JSON = "json";
	/**接收传递JSON的数据转换*/
	protected Object jsonResult;
	
	/**
	 * 针对于JSP跳转的时候使用的变量
	 */
	protected String toJsp;

	/**
	 * 针对于Action跳转的时候使用变量
	 */
	protected String toAction;
	
	/**
	 * flag用于标识是否成功:
	 * 	success:成功
	 *  error:失败
	 */
	protected String flag ;
	/**
	 * 提示信息
	 */
	protected String message;
	

	public String getToJsp() {
		return toJsp;
	}

	public void setToJsp(String toJsp) {
		this.toJsp = toJsp;
	}

	public String getToAction() {
		return toAction;
	}

	public void setToAction(String toAction) {
		this.toAction = toAction;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	//--------------------------------------下载操作封装--------------------------------------------
	protected  boolean download(String fileName,String filePath,String old) throws Exception{
		boolean flag = false;
		File file = new File(filePath+"\\"+fileName);
		if(file.exists()){
				String agent=request.getHeader("User-Agent");
				
			    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			    byte[] buffer = new byte[1];
			    response.reset();
			    response.setCharacterEncoding("UTF-8");
			    response.setContentType("application/x-rar-compressed");
			    if(agent.indexOf("MSIE 7")>0){
			    	old=URLEncoder.encode(old, "UTF-8").replace("+", "%20").length()>100?URLEncoder.encode(old, "UTF-8").replace("+", "%20").substring(0,100)+"."+old.substring(old.lastIndexOf(".")+1):URLEncoder.encode(old, "UTF-8").replace("+", "%20");
				    response.setHeader("Content-disposition", "attachment;filename="+old);}
				else if(agent.indexOf("Firefox")>0){
					response.setHeader("Content-disposition", "attachment;filename*="+URLEncoder.encode(old, "utf-8").replace("+", "%20"));
				}else{
					response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(old, "utf-8").replace("+", "%20"));
				}
			    OutputStream os = response.getOutputStream();
			    while(bis.read(buffer) > 0){
			     os.write(buffer);
			    }
			    bis.close();
			    os.close();
			    flag = true;
		}
		return flag;
	}

	public Object getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(Object jsonResult) {
		this.jsonResult = jsonResult;
	}

}
