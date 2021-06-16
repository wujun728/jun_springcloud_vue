package com.zebra.api.bussiness.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zebra.api.bussiness.aop.LogAnnotation;
import com.zebra.api.bussiness.aop.LogAnnotation.OPERTYPE;
import com.zebra.api.bussiness.service.NoticeService;
import com.zebra.api.commons.bean.Json;

/**
 *
 * Title: 公告<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 *
 */
@RestController
@RequestMapping("/noticeServer")
public class NoticeServer {
	@Autowired
	private NoticeService demoService;

	@RequestMapping(value = "/getNotice/{noticeId}")
	@ResponseBody
	@LogAnnotation(oper = OPERTYPE.getNotice)
	public Json getNotice(@PathVariable(value = "noticeId") Long noticeId) {
		return demoService.getNotice(noticeId);
	}

	@RequestMapping(value = "/getNoticeList", method = RequestMethod.POST)
	@ResponseBody
	@LogAnnotation(oper = OPERTYPE.getNotice)
	public Json getNoticeList() {
		return demoService.getNoticeList();
	}

}
