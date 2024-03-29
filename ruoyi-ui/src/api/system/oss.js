import request from '@/utils/request'

// 查询OSS对象存储列表
export function listOss(query) {
  return request({
    url: '/resource/oss/list',
    method: 'get',
    params: query
  })
}

// 删除OSS对象存储
export function delOss(ossId) {
  return request({
    url: '/resource/oss/' + ossId,
    method: 'delete'
  })
}

