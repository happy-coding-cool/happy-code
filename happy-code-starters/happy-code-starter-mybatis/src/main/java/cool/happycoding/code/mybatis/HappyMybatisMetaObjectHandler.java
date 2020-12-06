package cool.happycoding.code.mybatis;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 11:25 上午
 */
public class HappyMybatisMetaObjectHandler implements MetaObjectHandler {

    private final AutoFieldFillHandler autoFieldFillHandler;

    public HappyMybatisMetaObjectHandler(AutoFieldFillHandler autoFieldFillHandler){
        this.autoFieldFillHandler = autoFieldFillHandler;
    }

    @Override
    public void insertFill(MetaObject metaObject) {

        if (!checkField(metaObject, AutoFieldFillHandler.CREATED_TIME)) {
            this.strictInsertFill(metaObject, AutoFieldFillHandler.CREATED_TIME, Date::new, Date.class);
        }

        if (!checkField(metaObject, AutoFieldFillHandler.CREATED_BY)){
            this.strictInsertFill(metaObject, AutoFieldFillHandler.CREATED_BY, autoFieldFillHandler::createdBy, String.class);
        }

        if (!checkField(metaObject, AutoFieldFillHandler.CREATED_BY_ID)){
            this.strictInsertFill(metaObject, AutoFieldFillHandler.CREATED_BY_ID, autoFieldFillHandler::createdById, String.class);
        }

        if (!checkField(metaObject, AutoFieldFillHandler.UPDATED_TIME)){
            this.strictInsertFill(metaObject, AutoFieldFillHandler.UPDATED_TIME, Date::new, Date.class);
        }

        if (!checkField(metaObject, AutoFieldFillHandler.UPDATED_BY)){
            this.strictInsertFill(metaObject, AutoFieldFillHandler.UPDATED_BY, autoFieldFillHandler::updatedBy, String.class);
        }

        if (!checkField(metaObject, AutoFieldFillHandler.UPDATED_BY_ID)){
            this.strictInsertFill(metaObject, AutoFieldFillHandler.UPDATED_BY_ID, autoFieldFillHandler::updatedById, String.class);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {

        if (!checkField(metaObject, AutoFieldFillHandler.UPDATED_TIME)){
            this.strictUpdateFill(metaObject, AutoFieldFillHandler.UPDATED_TIME, Date::new, Date.class);
        }

        if (!checkField(metaObject, AutoFieldFillHandler.UPDATED_BY)){
            this.strictUpdateFill(metaObject, AutoFieldFillHandler.UPDATED_BY, autoFieldFillHandler::updatedBy, String.class);
        }

        if (!checkField(metaObject, AutoFieldFillHandler.UPDATED_BY_ID)){
            this.strictUpdateFill(metaObject, AutoFieldFillHandler.UPDATED_BY_ID, autoFieldFillHandler::updatedById, String.class);
        }

    }

    /**
     * 当不存在该字段或该字段有值的时候不做自动填充处理
     * @param metaObject
     * @param fieldName
     * @return
     */
    protected boolean checkField(MetaObject metaObject, String fieldName){
        return !metaObject.hasSetter(fieldName) || ObjectUtil.isNotNull(metaObject.getValue(fieldName));
    }

}