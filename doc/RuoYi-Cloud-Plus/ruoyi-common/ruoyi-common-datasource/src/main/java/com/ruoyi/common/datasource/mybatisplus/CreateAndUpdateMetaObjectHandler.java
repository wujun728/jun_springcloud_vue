package com.ruoyi.common.datasource.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ruoyi.common.core.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * MP注入处理器
 *
 * @author fanglei
 * @date 2021/05/28 14:24
 **/
public class CreateAndUpdateMetaObjectHandler implements MetaObjectHandler {
    
    @Override
    public void insertFill(MetaObject metaObject) {
        //根据属性名字设置要填充的值
        if (metaObject.hasGetter("createTime")) {
            if (metaObject.getValue("createTime") == null) {
                this.setFieldValByName("createTime", new Date(), metaObject);
            }
        }
        if (metaObject.hasGetter("createBy")) {
            if (metaObject.getValue("createBy") == null) {
                this.setFieldValByName("createBy", SecurityUtils.getUsername(), metaObject);
            }
        }
    }
    
    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter("updateBy")) {
            if (metaObject.getValue("updateBy") == null) {
                this.setFieldValByName("updateBy", SecurityUtils.getUsername(), metaObject);
            }
        }
        if (metaObject.hasGetter("updateTime")) {
            if (metaObject.getValue("updateTime") == null) {
                this.setFieldValByName("updateTime", new Date(), metaObject);
            }
        }
    }
}
