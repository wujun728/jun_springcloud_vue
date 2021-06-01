package com.zebra.framework.aspectj;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zebra.bussiness.domain.Merchant;
import com.zebra.bussiness.mapper.MerchantMapper;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.utils.StringUtils;
import com.zebra.framework.util.ShiroUtils;
import com.zebra.system.domain.SysRole;
import com.zebra.system.domain.SysUser;
import com.zebra.system.domain.page.SysUserPage;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Scope(value = "prototype")
@Slf4j
public class AuthExrendAspcet {
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
	public static final String DATA_SCOPE = "dataMerchantAuth";

	@Autowired
	private MerchantMapper merchantMapper;

	@Pointcut("@annotation(com.zebra.common.annotation.AuthExrendAnnotaion)")
	public void logAspect() {
	}

	@AfterReturning(pointcut = "logAspect()", returning = "j")
	public void doAfterReturning(JoinPoint joinPoint, Object j) {
		AjaxResult ajaxResult = AjaxResult.error();
		if (j instanceof AjaxResult) {
			ajaxResult = (AjaxResult) j;
		}

		String alias = "d";
		String condition = " ";
		if (ajaxResult.getCode() == 0) {
			SysUser sysUser = ShiroUtils.getSysUser();
			if (sysUser != null) {
				StringBuilder sqlString = new StringBuilder();
				if (sysUser.getUserId() != 1L) {
					int i = 0;
					for (SysRole role : sysUser.getRoles()) {

						String dataScope = role.getDataScope();
						if (DATA_SCOPE_ALL.equals(dataScope)) {
							sqlString = new StringBuilder();
							break;
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

					Merchant merchant = new Merchant();
					merchant.getParams().put(DATA_SCOPE, condition);
					List<Merchant> activities = merchantMapper.selectMerchantListByauto(merchant);
					List<Object> list = new ArrayList<>();
					activities.forEach(e -> {
						list.add(e.getMerchantId());
					});
					List<Object> objs = list.stream().distinct().collect(Collectors.toList());
					if (objs.size() == 0) {
						objs.add(-1);
					}
					SysUserPage page = new SysUserPage();
					BeanUtils.copyProperties(sysUser, page);
					page.setObjs(objs);
					ShiroUtils.setSysUserPage(page);
					log.info("[信息]账号权限：" + objs.toString());
				}
			}
		}

	}
}
