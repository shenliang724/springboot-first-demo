package com.oyo.shen.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;

public abstract class BaseController {

    @Autowired
    protected Validator validator;


    /**
     *
     * 服务端参数的有效性验证
     * @param object 验证的实体对象
     * @params groups 验证组
     * @return 验证成功：返回true :严重失败：将失败信息添加到message中
     *
     */

    protected boolean beanValidator(Model model ,Object object ,Class<?>... groups){

        try{
            BeanValidators.validateWithException(validator,object,groups);

        }catch (ConstraintViolationException ex){

            List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex,":");
            list.add(0,"数据验证失败：");
            addMessage(model,list.toArray(new String[]{}));
            return false;
        }
        return true;
    }

    protected void addMessage(Model model,String... messages){
        StringBuilder sb = new StringBuilder();
        for(String message : messages){

            sb.append(message).append(message.length()>1?"<br/>":"");

        }
        model.addAttribute("message",sb.toString());

    }


}
