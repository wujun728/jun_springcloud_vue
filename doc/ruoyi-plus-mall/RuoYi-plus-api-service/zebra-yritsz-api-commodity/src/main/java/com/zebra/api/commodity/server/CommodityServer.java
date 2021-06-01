package com.zebra.api.commodity.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zebra.api.commodity.aop.LogAnnotation;
import com.zebra.api.commodity.aop.LogAnnotation.OPERTYPE;
import com.zebra.api.commodity.service.CommodityService;
import com.zebra.api.commons.bean.Json;
import com.zebra.api.commons.bean.RequestTestBean;

/**
 *
 * Title: 产品<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 *
 */
@RestController
@RequestMapping("/commodityServer")
public class CommodityServer {
	@Autowired
	private CommodityService demoService;

	/**
	 * 修改库存
	 *
	 * @param commodityId
	 *            商品id
	 * @param isRollback
	 *            是否需要回滚 否：正常业务 是：直接响应失败
	 * @return
	 */
	@RequestMapping(value = "/editStock/{commodityId}")
	@ResponseBody
	@LogAnnotation(oper = OPERTYPE.editStock)
	public Json editStock(@PathVariable(value = "commodityId") String commodityId,@RequestBody RequestTestBean requestTestBean) {
		return demoService.editStock(commodityId, requestTestBean.getIsRollback());
	}
}
