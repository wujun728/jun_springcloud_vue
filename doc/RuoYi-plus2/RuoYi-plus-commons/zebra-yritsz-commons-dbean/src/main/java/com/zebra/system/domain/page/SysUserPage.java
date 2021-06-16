package com.zebra.system.domain.page;

import java.util.List;

import com.zebra.system.domain.SysUser;

import lombok.AllArgsConstructor;
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

	/**
	 * 是否为管理员 <br/>
	 * 1：是 0：否
	 */
	private Integer adminStatus;

	@Getter
	@AllArgsConstructor
	public enum ADMIN_STATUS {
		IS_ADMIN(1), NO_ADMIN(0);
		private Integer code;
	}
}
