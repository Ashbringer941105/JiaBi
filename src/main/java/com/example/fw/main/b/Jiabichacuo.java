package com.example.fw.main.b;

import com.example.fw.base.BaseEN;

public class Jiabichacuo extends BaseEN {

	private Long id;	//id
	private String bi_zmz;	//币种面值
	private String cha_clx;	//差错类型
	private String shang_brzh;	//上报人账号
	private String shen_pr;	//审批人
	private String shi_fty;	//是否同意
	private String shi_fxg;	//是否修改
	private String zhap_p;	//照片
	private String wen_z;	//文字描述


	 public Long getId(){
	 return this.id;
	}
	 public void setId(Long id){
	  this.id=id;
	}

	 public String getBi_zmz(){
	 return this.bi_zmz;
	}
	 public void setBi_zmz(String bi_zmz){
	  this.bi_zmz=bi_zmz;
	}

	 public String getCha_clx(){
	 return this.cha_clx;
	}
	 public void setCha_clx(String cha_clx){
	  this.cha_clx=cha_clx;
	}

	 public String getShang_brzh(){
	 return this.shang_brzh;
	}
	 public void setShang_brzh(String shang_brzh){
	  this.shang_brzh=shang_brzh;
	}

	 public String getShen_pr(){
	 return this.shen_pr;
	}
	 public void setShen_pr(String shen_pr){
	  this.shen_pr=shen_pr;
	}

	 public String getShi_fty(){
	 return this.shi_fty;
	}
	 public void setShi_fty(String shi_fty){
	  this.shi_fty=shi_fty;
	}

	 public String getShi_fxg(){
	 return this.shi_fxg;
	}
	 public void setShi_fxg(String shi_fxg){
	  this.shi_fxg=shi_fxg;
	}

	 public String getZhap_p(){
	 return this.zhap_p;
	}
	 public void setZhap_p(String zhap_p){
	  this.zhap_p=zhap_p;
	}

	 public String getWen_z(){
	 return this.wen_z;
	}
	 public void setWen_z(String wen_z){
	  this.wen_z=wen_z;
	}
}
