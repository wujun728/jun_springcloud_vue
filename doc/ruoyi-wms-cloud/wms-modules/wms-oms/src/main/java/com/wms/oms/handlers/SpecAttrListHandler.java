package com.wms.oms.handlers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wms.common.core.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 数组字符串转换字符存储
 */
@MappedJdbcTypes({JdbcType.VARCHAR})
public class SpecAttrListHandler extends BaseTypeHandler<List>{

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List parameter, JdbcType jdbcType) throws SQLException {
        if (parameter != null) {
            ps.setString(i, JsonUtils.toJson(parameter));
        }
    }

    @Override
    public List getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String dbData = rs.getString(columnName);
        if (StringUtils.isEmpty(dbData)) {
            return null;
        }
        return JsonUtils.toObject(dbData, new TypeReference<List>() { });
    }

    @Override
    public List getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String dbData = rs.getString(columnIndex);
        if (StringUtils.isEmpty(dbData)) {
            return null;
        }
        return JsonUtils.toObject(dbData, new TypeReference<List>() { });
    }

    @Override
    public List getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String dbData = cs.getString(columnIndex);
        if (StringUtils.isEmpty(dbData)) {
            return null;
        }
        return JsonUtils.toObject(dbData, new TypeReference<List>() { });
    }

}
