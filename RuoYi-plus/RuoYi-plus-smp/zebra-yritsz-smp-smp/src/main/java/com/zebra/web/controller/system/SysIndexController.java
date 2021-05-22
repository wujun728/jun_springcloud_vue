package com.zebra.web.controller.system;

import com.zebra.common.annotation.Log;
import com.zebra.common.config.ConfigServerApplication;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.enums.BusinessType;
import com.zebra.common.utils.CookieUtils;
import com.zebra.common.utils.ServletUtils;
import com.zebra.common.utils.StringUtils;
import com.zebra.common.utils.http.HttpUtil;
import com.zebra.framework.util.ShiroUtils;
import com.zebra.system.domain.SysMenu;
import com.zebra.system.domain.SysUser;
import com.zebra.system.service.ISysConfigService;
import com.zebra.system.service.ISysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 首页 业务处理
 *
 * @author ruoyi
 */
@Controller
@Slf4j
public class SysIndexController extends BaseController {
	@Autowired
	private ISysMenuService menuService;
	@Autowired
	private ISysConfigService configService;
	@Autowired
	private ConfigServerApplication configServerApplication;

	// 系统首页
	@GetMapping("/index")
	public String index(ModelMap mmap,String name) {
		// 取身份信息
		SysUser user = ShiroUtils.getSysUser();
		// 根据用户id取出菜单
		List<SysMenu> menus = menuService.selectMenusByUser(user);
		mmap.put("menus", menus);
		mmap.put("user", user);
		mmap.put("copyrightYear", configServerApplication.getCopyrightYear());
		mmap.put("demoEnabled", configServerApplication.getDemoEnabled());

		mmap.put("sideTheme", configService.selectConfigByKey("sys.index.sideTheme"));
		mmap.put("skinName", configService.selectConfigByKey("sys.index.skinName"));
		mmap.put("ignoreFooter", configService.selectConfigByKey("sys.index.ignoreFooter"));
		String menuStyle = configService.selectConfigByKey("sys.index.menuStyle");
		// 移动端，默认使左侧导航菜单，否则取默认配置
		String indexStyle = ServletUtils.checkAgentIsMobile(ServletUtils.getRequest().getHeader("User-Agent")) ? "index" : menuStyle;
		// 优先Cookie配置导航菜单
		Cookie[] cookies = ServletUtils.getRequest().getCookies();
		for (Cookie cookie : cookies)
		{
			if (StringUtils.isNotEmpty(cookie.getName()) && "nav-style".equalsIgnoreCase(cookie.getName()))
			{
				indexStyle = cookie.getValue();
				break;
			}
		}
		String webIndex = "topnav".equalsIgnoreCase(indexStyle) ? "index-topnav" : "index";
 		return webIndex;
	}

	// 系统介绍
	@GetMapping("/system/main")
	public String main(ModelMap mmap) {
		mmap.put("version", configServerApplication.getVersion());
		return "main";
	}

	// 同步配置中心
	@Log(title = "同步配置中心", businessType = BusinessType.SYNC)
	@PostMapping("/system/syncConfig")
	@ResponseBody
	public AjaxResult syncConfig() {
		HttpUtil httpUtil = HttpUtil.getInstance("utf-8", 20000, 20000);
		String reString = httpUtil.sendHttpPost(configServerApplication.getRefresh(), null, null, null,
				MimeTypeUtils.APPLICATION_JSON);
		logger.info("[信息]刷新配置信息返回：" + reString);
		return toAjax(1);
	}

	// 切换主题
	@GetMapping("/system/switchSkin")
	public String switchSkin()
	{
		return "skin";
	}

	// 切换菜单
	@GetMapping("/system/menuStyle/{style}")
	public void menuStyle(@PathVariable String style, HttpServletResponse response)
	{
		CookieUtils.setCookie(response, "nav-style", style);
	}
}
