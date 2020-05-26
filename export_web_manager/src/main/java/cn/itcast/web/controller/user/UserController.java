package cn.itcast.web.controller.user;

import cn.itcast.domain.Dept;
import cn.itcast.domain.User;
import cn.itcast.service.DeptService;
import cn.itcast.service.UserService;
import cn.itcast.utils.UtilFuns;
import cn.itcast.web.controller.basecontroller.BaseController;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/system/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/list",name = "用户查询")
    public String findPageAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "4")int pageSize){
        PageInfo page = userService.findPageAll(pageNum, pageSize, companyId);
        request.setAttribute("page",page);
        //到展示页面
        return "system/user/user-list";
    }


    @RequestMapping(value = "/toAdd",name = "用户新建页面")
    public String toAdd(){
        List<Dept> deptList = deptService.findAllDept(companyId);
        request.setAttribute("deptList",deptList);
        //带着所有部门到页面
        return "system/user/user-add";
    }

    @RequestMapping(value = "/edit",name = "用户新增")
    public String edit(User user){

        user.setCompanyId(companyId);
        user.setCompanyName(companyName);
        if(UtilFuns.isEmpty(user.getId())){
            user.setId(UUID.randomUUID().toString().replace("-",""));
            userService.save(user);
        }else{
            userService.update(user);
        }

        //到查询
        return "redirect:/system/user/list.do";
    }


    @RequestMapping(value = "/toUpdate",name = "用户修改页面")
    public String toUpdate(String id){
        //根据id查用户
        User user=userService.findById(id);
        //查询所有用户
        request.setAttribute("user",user);
        List<Dept> deptList = deptService.findAllDept(companyId);
        request.setAttribute("deptList",deptList);
        //到查询
        return "system/user/user-update";
    }

    //根据id删除用户
    @RequestMapping(value = "/delete",name = "删除用户")
    public String delete(String id){

        userService.delete(id);
        //到查询
        return "redirect:/system/user/list.do";
    }


}
