package com.example.fw.main.b;

import com.example.fw.base.BaseEN;

public class Qiandai extends BaseEN {

	private Long id;	//id
	private Integer shu_l;	//数量
	private String ti_jrzh;	//提交人账号
	private String jie_srzh;	//接收人人账号
	private Integer ying_tjsl;	//应提交数量
	private Integer shi_tjsl;	//实际提交数量


	 public Long getId(){
	 return this.id;
	}
	 public void setId(Long id){
	  this.id=id;
	}

	 public Integer getShu_l(){
	 return this.shu_l;
	}
	 public void setShu_l(Integer shu_l){
	  this.shu_l=shu_l;
	}

	 public String getTi_jrzh(){
	 return this.ti_jrzh;
	}
	 public void setTi_jrzh(String ti_jrzh){
	  this.ti_jrzh=ti_jrzh;
	}

	 public String getJie_srzh(){
	 return this.jie_srzh;
	}
	 public void setJie_srzh(String jie_srzh){
	  this.jie_srzh=jie_srzh;
	}

	 public Integer getYing_tjsl(){
	 return this.ying_tjsl;
	}
	 public void setYing_tjsl(Integer ying_tjsl){
	  this.ying_tjsl=ying_tjsl;
	}

	 public Integer getShi_tjsl(){
	 return this.shi_tjsl;
	}
	 public void setShi_tjsl(Integer shi_tjsl){
	  this.shi_tjsl=shi_tjsl;
	}
}
