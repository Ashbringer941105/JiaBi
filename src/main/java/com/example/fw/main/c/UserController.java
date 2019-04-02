package com.example.fw.main.c;

import com.example.fw.base.BaseController;
import com.example.fw.base.RequestType;
import com.example.fw.main.b.User;
import com.myjar.Stringutil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public RequestType save(User mUser) throws Exception {
        if(mUser.getId()==null){
            if(Stringutil.isBlank(mUser.getUname()))
                return  sendFalse("账号不可为空");
            if(Stringutil.isBlank(mUser.getPwd()))
                return  sendFalse("密码不可为空");
            if(Stringutil.isBlank(mUser.getNickname()))
                mUser.setNickname(mUser.getUname());
            if(Stringutil.isBlank(mUser.getEx()))
                mUser.setEx("0");

            if(mJiabiService.getByparameter("uname",mUser.getUname())!=null)
                return  sendFalse("账号已存在");
            mJiabiService.add(mUser);
            return  sendTrueMsg("添加成功");
        }else{
            mJiabiService.updateBySelect(mUser);
            return  sendTrueMsg("更新成功");
        }

    }
    @RequestMapping(value ="/list", method = RequestMethod.POST)
    public RequestType list(User User,Integer page,Integer rows) throws Exception {

        List<User> dd = (List<com.example.fw.main.b.User>) mJiabiService.getALL(User,page,rows);
        return sendTrueData(mJiabiService.getALL(User,page,rows));
    }


//    @RequestMapping(value ="/login", method = RequestMethod.POST)
//    public RequestType login(@RequestParam("uname") String uname,
//                             @RequestParam("pwd") String pwd) throws Exception {
//        if (uname == null | uname.equals("") ){
//            return  sendFalse("账号不能为空");
//        }
//        Map ddd = mJiabiService.getByparameter("uname",uname);
//        if (mJiabiService.getByparameter("uname",uname)==null){
//            return  sendFalse("用户名不存在");
//        }
//        return  sendTrueMsg("更新成功");
//    }


}
