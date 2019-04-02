package com.example.fw.main.c;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.example.fw.main.Annotation.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.fw.base.BaseController;
import com.example.fw.base.RequestType;
import com.example.fw.base.Sql;
import com.example.fw.base.Util.ExportExcel;
import com.example.fw.main.b.Jiabichacuo;
import com.example.fw.main.s.JiabichacuoService;
import com.myjar.Stringutil;

@RestController
@RequestMapping("/Jiabichacuo")
public class JiabichacuoController extends BaseController {
    @Autowired
    protected JiabichacuoService mJiabichacuoService;

    @RequestMapping(value ="/save", method = RequestMethod.POST)
    @AuthToken
    public RequestType save(Jiabichacuo mJiabichacuo) throws Exception {


        if(Stringutil.isBlank(mJiabichacuo.getId())){
            if(Stringutil.isBlank( mJiabichacuo.getZhap_p()))
                return sendFalse("图片不可为空");
            mJiabichacuoService.add(mJiabichacuo);
            return sendTrueMsg("添加成功");
        }else{
            mJiabichacuoService.updateBySelect(mJiabichacuo);
            return sendTrueMsg("更新成功");
        }

    }
    @RequestMapping(value ="/list", method = RequestMethod.POST)
    @AuthToken
    public RequestType list(Jiabichacuo mJiabichacuo,Integer page,Integer rows) throws Exception {
        return sendTrueData(mJiabichacuoService.getALL(mJiabichacuo,page,rows));
    }

    @RequestMapping(value ="/getByid", method = RequestMethod.POST)
    @AuthToken
    public RequestType getByid(String id) throws Exception {
        if(Stringutil.isBlank(id)) return sendFalse("编号不可为空");
        return sendTrueData(mJiabichacuoService.getById(id));
    }

    @RequestMapping(value ="/ExportExcel", method = RequestMethod.GET)
    @AuthToken
    public void ExportExcel(Jiabichacuo mJiabichacuo, Long star, Long end, HttpServletResponse response) throws Exception {
       if(star==null)star=0L;
       if(end==null)end=System.currentTimeMillis();
        Sql msql = new Sql();
        msql.setSql("select * from Jiabichacuo "+mJiabichacuoService.getWhere(mJiabichacuo)+" and id<"+end+" and id>"+star);
        List<Map<String,Object>> listmap = mJiabichacuoService.exeSelectSql(msql);
        List<String> title = new ArrayList<String>();
        List<String> key = new ArrayList<String>();
        title.add("编号");        key.add("id");
        title.add("面值");        key.add("bi_zmz");
        title.add("差错");        key.add("cha_clx");
        title.add("上报人账号");  key.add("shang_brzh");
        title.add("审批人");      key.add("shen_pr");
        title.add("是否同意");    key.add("shi_fty");
        title.add("是否修改");    key.add("shi_fxg");
        title.add("描述");        key.add("wen_z");
        title.add("图片");        key.add("zhap_p");
        ExportExcel.ImagePathKey(listmap,"ZHAP_P");
        ExportExcel.Export("报表",title,key,listmap,response);
    }


}
