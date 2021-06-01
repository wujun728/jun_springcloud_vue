package com.zebra.api.bussiness.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zebra.api.commons.bean.Json;
/**
 * Title: 公告管理<br/>
 * Description:<br/>
 * @author zebra
 * @Date 2020年3月25日
 *
 */
public interface NoticeService {
	/**
	 * 获取公告信息
	 *
	 * @param noticeId
	 * @return
	 */
	public Json getNotice(@PathVariable(value = "noticeId") Long noticeId);

	/**
	 * 获取公告列表
	 *
	 * @return
	 */
	@RequestMapping(value = "/getNoticeList", method = RequestMethod.POST)
	public Json getNoticeList();
}
