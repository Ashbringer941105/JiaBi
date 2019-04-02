package com.example.fw.main.s;

import com.example.fw.base.BaseService;
import com.example.fw.base.Sql;

import org.springframework.stereotype.Service;

@Service
public class QiandaiService extends BaseService {
    @Override
    protected String getTabName() {
        return "Qiandai";
    }
    
   public Integer getQiandaiSize(String A,String B) throws  Exception{
	   Sql msql = new Sql();
	   msql.setSql("select nvl((select sum(shu_l) shu_l where ti_jrzh='"+A+"' and jie_srzh='"+B+"')-"
	   		+ "(select sum(shu_l) shu_l where ti_jrzh='"+B+"' and jie_srzh='"+A+"'),0) shu_l from Qiandai where rownum=1");
	return Integer.parseInt(exeSelectSql(msql).get(0).get("SHU_L").toString());
    	
    }
}
