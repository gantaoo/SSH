package com.gt.action;


import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gt.entity.UserEntity;
import com.gt.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

@Controller
@Scope(value="prototype")
public class UserAction extends ActionSupport implements ModelDriven<UserEntity> {  

//	private static final long serialVersionUID = 1L;
	private UserEntity user;

	@Autowired
	private UserService userService;

    /**
     * 增加
     * @return
     * @throws Exception
     */
    @Action(value="addUser", results={
    		@Result(location="/home.jsp"),
    		@Result(name="error",location="/error.jsp")
    })
    public String login() throws Exception{
    	if(userService.add(user)){
    		return SUCCESS;
    	}else {
    		return ERROR;
    	}
    }

    /**
     * 查询全部
     * @return
     * @throws Exception
     */
    @Action(value="selectUser", results={
            @Result(location="/select.jsp"),
            @Result(name="error",location="/error.jsp")
    })
    public String selectAll() throws Exception{
        List<UserEntity> list = userService.selectAll();
        if(list.isEmpty()){
            return ERROR;
        }
        ActionContext.getContext().put("list", list);
        return SUCCESS;
    }


    /***
     * 修改（暂时没有做数据效验，必须填写数据库已有id）
     * @return
     * @throws Exception
     */
    @Action(value="updatetUser", results={
            @Result(location="/home.jsp"),
            @Result(name="error",location="/error.jsp")
    })
    public String update() throws Exception{
        if(userService.update(user)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }


    /***
     * 删除（暂时没有做数据效验，必须填写数据库已有id）
     * @return
     * @throws Exception
     */
    @Action(value="deltUser", results={
            @Result(location="/home.jsp"),
            @Result(name="error",location="/error.jsp")
    })
    public String del() throws Exception{
        if(userService.del(user.getSid())){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }


	@Override
	public UserEntity getModel() {
		if(user == null){  
	           user = new UserEntity();  
       }  
       return user;  
	}

}