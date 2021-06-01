package com.zebra.system.domain.page;

import java.util.List;

import com.zebra.system.domain.SysUser;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * Title:用户信息扩展类<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月2日
 *
 */
@Getter
@Setter
public class SysUserPage extends SysUser {
	private static final long serialVersionUID = -7932133541511131460L;

	private List<Object> objs;

}
