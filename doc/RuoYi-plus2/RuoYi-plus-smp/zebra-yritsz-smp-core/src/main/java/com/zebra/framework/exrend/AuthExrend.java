package com.zebra.framework.exrend;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zebra.bussiness.domain.Merchaninfo;
import com.zebra.bussiness.mapper.MerchaninfoMapper;
import com.zebra.common.utils.StringUtils;
import com.zebra.framework.util.ShiroUtils;
import com.zebra.system.domain.SysRole;
import com.zebra.system.domain.SysUser;
import com.zebra.system.domain.page.SysUserPage;
import com.zebra.system.domain.page.SysUserPage.ADMIN_STATUS;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * Title: 权限扩展类<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年4月21日
 *
 */
@Component
@Slf4j
public class AuthExrend {
	/**
	 * 全部数据权限
	 */
	public static final String DATA_SCOPE_ALL = "1";

	/**
	 * 自定数据权限
	 */
	public static final String DATA_SCOPE_CUSTOM = "2";

	/**
	 * 部门数据权限
	 */
	public static final String DATA_SCOPE_DEPT = "3";

	/**
	 * 部门及以下数据权限
	 */
	public static final String DATA_SCOPE_DEPT_AND_CHILD = "4";

	/**
	 * 数据权限过滤关键字
	 */
	public static final String DATA_SCOPE = "dataScope";

	@Autowired
	private MerchaninfoMapper merchaninfoMapper;

	protected void Auth(SysUser sysUser) {
		String alias = "d";
		String condition = " ";
		StringBuilder sqlString = new StringBuilder();
		SysUserPage page = new SysUserPage();
		BeanUtils.copyProperties(sysUser, page);
		us: if (sysUser.getUserId() != 1L) {
			page.setAdminStatus(ADMIN_STATUS.NO_ADMIN.getCode());
			int i = 0;
			for (SysRole role : sysUser.getRoles()) {

				String dataScope = role.getDataScope();
				if (DATA_SCOPE_ALL.equals(dataScope)) {
					page.setObjs(null);
					break us;
				} else if (DATA_SCOPE_CUSTOM.equals(dataScope)) {
					if (i != 0) {
						sqlString.append(" OR ");
					}
					sqlString.append(StringUtils.format(
							" {}.dept_id IN ( SELECT dept_id FROM sys_role_dept WHERE role_id = {} ) ", alias,
							role.getRoleId()));
				} else if (DATA_SCOPE_DEPT.equals(dataScope)) {
					if (i != 0) {
						sqlString.append(" OR ");
					}
					sqlString.append(StringUtils.format("   {}.dept_id = {} ", alias, sysUser.getDeptId()));
				} else if (DATA_SCOPE_DEPT_AND_CHILD.equals(dataScope)) {
					if (i != 0) {
						sqlString.append(" OR ");
					}
					String deptChild = sysUser.getDept().getParentId() + "," + sysUser.getDeptId();
					sqlString.append(StringUtils.format(
							" {}.dept_id IN ( SELECT dept_id FROM sys_dept WHERE dept_id = {} or ancestors LIKE '%{}%' )",
							alias, sysUser.getDeptId(), deptChild));
				}
				i++;
			}
			if (i == 0) {
				condition = " and 1=2 ";
			}
			if (sqlString.length() > 0) {
				condition += " and (" + sqlString.toString() + ")";
			}
			Merchaninfo bMerchant = new Merchaninfo();
			bMerchant.getParams().put(DATA_SCOPE, condition);
			List<Merchaninfo> bMerchants = merchaninfoMapper.selectMerchantByauto(bMerchant);
			List<Object> list = new ArrayList<>();
			bMerchants.forEach(e -> {
				list.add(e.getMerchantId());
			});
			List<Object> objs = list.stream().distinct().collect(Collectors.toList());
			if (objs.size() == 0) {
				objs.add(-1);
			}
			page.setObjs(objs);
			log.info("[信息]-【普通账号】-商户权限：" + objs.toString());
		} else {
			page.setAdminStatus(ADMIN_STATUS.IS_ADMIN.getCode());
			log.info("[信息]-【系统账号】-商户权限：全部");
		}
		ShiroUtils.setSysUserPage(page);
	}
}
