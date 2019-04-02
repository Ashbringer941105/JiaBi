
package com.example.fw.base;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.fw.main.Annotation.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.fw.Application;
import com.example.fw.base.Util.FileUtil;
import com.example.fw.main.b.User;
import com.example.fw.main.s.JiabiService;
import com.myjar.Stringutil;
import com.myjar.desutil.RunException;

@RestController
public class BaseController {
	@Autowired
	protected JiabiService mJiabiService;
    @RequestMapping(value ="/ttt", method = RequestMethod.POST)
    @AuthToken
    public Object ttt(HttpSession httpSession){
        User dd = (User)httpSession.getAttribute("user");
        //System.out.println(dd);
        return dd;
    }

	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public RequestType login(User mUser,HttpServletRequest request, HttpSession httpSession) throws Exception {

		if(Stringutil.isBlank(mUser.getUname()))
			return  sendFalse("账号不可为空");
		if(Stringutil.isBlank(mUser.getPwd()))
			return  sendFalse("密码不可为空");
		User mUser1 = mJiabiService.getByparameter("uname",mUser.getUname(),User.class);
		if(mUser1==null)
			return  sendFalse("账号不存在");
		if(!mUser1.getPwd().equals(mUser.getPwd()))
			return  sendFalse("密码错误");

		mUser1.setPwd(null);
		// 将用户加入到Session中
        httpSession.setAttribute("user", mUser1);
        Map<String, Object> map = new HashMap<>();
        map.put("user", mUser1);
        map.put("sessionid", httpSession.getId());
        return sendTrueData(map);
	}


	@RequestMapping(value ="/uploadFile", method = RequestMethod.POST)
    @AuthToken
	public RequestType uploadFile(HttpServletRequest req) throws Exception {
		return sendTrueData(FileUtil.doFileUploadOne(req));
	}
	
	public User getUser(String uname) throws Exception {
		if(Stringutil.isBlank(uname))throw new RunException("账号错误");
		User mUser1 = mJiabiService.getByparameter("uname",uname,User.class);
		if(mUser1==null)
			throw new RunException("账号不存在");
		return mUser1;
	}
	public User getUser(Long id) throws Exception {
		if(Stringutil.isBlank(id))throw new RunException("编号错误");
		User mUser1 = mJiabiService.getById(id,User.class);
		if(mUser1==null)
			throw new RunException("账号不存在");
		return mUser1;
	}


	/**
	 * 成功，只返回提示信息
	 * */
	protected RequestType sendTrueMsg(String msg){
		return getRequestType(null, msg, null);
	}
	/**
	 * 成功，只返回数据
	 * */
	protected RequestType sendTrueData(Object obj){
		return getRequestType(null, null, obj);
	}
	/**
	 * 失败，返回提示信息
	 * */
	protected RequestType sendFalse(String msg){
		return getRequestType(-1, msg, null);
	}
	/**
	 * 失败，返回提示信息，带着stat
	 * */
	protected RequestType sendFalse(String msg,int status){
		return getRequestType(status, msg, null);
	}

	private RequestType getRequestType(Integer code,String msg,Object data){
		RequestType reqt = new RequestType();
		//状态码
		if(code!=null)reqt.setStatus(code);
		else reqt.setStatus(200);
		//提示信息
		if(msg!=null)reqt.setMessage(msg);
		//数据
		reqt.setData(data);
		//时间
		reqt.setTimestamp(System.currentTimeMillis());
		//运行时间，测试使用
//		reqt.setRuntime(System.currentTimeMillis()-InterceptorConfig.time);
		Application.out(reqt);
		return reqt;		
	}

/**
 * 输出一张图片
 * */    
    public void sendImage( HttpServletResponse response,BufferedImage image) throws Exception {
        ServletOutputStream out = response.getOutputStream();  
        ImageIO.write(image, "jpg", out);
	      out.flush();  
	      out.close();
        
    }



}
