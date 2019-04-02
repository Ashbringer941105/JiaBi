package com.example.fw.main.c;

import com.example.fw.base.BaseController;
import com.example.fw.base.RequestType;
import com.example.fw.main.Annotation.AuthToken;
import com.example.fw.main.b.Qiandai;
import com.example.fw.main.s.QiandaiService;
import com.myjar.Stringutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Qiandai")
public class QiandaiController extends BaseController {
    @Autowired
    protected QiandaiService mQiandaiService;

    @RequestMapping(value ="/save", method = RequestMethod.POST)
    @AuthToken
    public RequestType save(Qiandai mQiandai) throws Exception {

    	if(mQiandai.getShu_l()<1)return sendFalse("数量错误");	
        if(Stringutil.isBlank(mQiandai.getId())){
        	if(!mQiandai.getJie_srzh().equals(getUser(mQiandai.getTi_jrzh()).getQiandai_suname())){
        		if(mQiandai.getShu_l()>mQiandaiService.getQiandaiSize(mQiandai.getTi_jrzh(), mQiandai.getJie_srzh()))
            		return sendFalse("可领取数量不足");	
        	}
        	mQiandaiService.add(mQiandai);
            return sendTrueMsg("提交成功");
        }else{
            mQiandaiService.updateBySelect(mQiandai);
            return sendTrueMsg("更新成功");
        }

    }
    @RequestMapping(value ="/list", method = RequestMethod.POST)
    public RequestType list(Qiandai mQiandai,Integer page,Integer rows) throws Exception {
        return sendTrueData(mQiandaiService.getALL(mQiandai,page,rows));
    }

    @RequestMapping(value ="/getByid", method = RequestMethod.POST)
    public RequestType getByid(String id) throws Exception {
        if(Stringutil.isBlank(id)) return sendFalse("编号不可为空");
        return sendTrueData(mQiandaiService.getById(id));
    }

}
