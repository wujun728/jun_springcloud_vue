package com.zebra.api.bussiness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zebra.api.bussiness.service.NoticeService;
import com.zebra.api.commons.bean.Json;
import com.zebra.api.commons.enums.ResultEnum;
import com.zebra.system.domain.SysNotice;
import com.zebra.system.mapper.SysNoticeMapper;

/**
 * Title: 公告管理实现<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 *
 */
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private SysNoticeMapper sysNoticeMapper;

	@Override
	public Json getNotice(Long noticeId) {
		if (StringUtils.isEmpty(noticeId)) {
			return Json.other(ResultEnum.PARAMERROR);
		}
		SysNotice notice = sysNoticeMapper.selectNoticeById(noticeId);
		if (notice == null) {
			return Json.other(ResultEnum.PARAMNULL);
		}
		return Json.success(notice);
	}

	@Override
	public Json getNoticeList() {
		return Json.success(sysNoticeMapper.selectNoticeList(null));
	}

}
