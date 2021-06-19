package com.ruoyi.activiti.mapper;

import java.util.List;

import com.ruoyi.activiti.vo.HiProcInsVo;

public interface HistoryMapper
{
    List<HiProcInsVo> getHiProcInsListDone(HiProcInsVo hiProcInsVo);
}