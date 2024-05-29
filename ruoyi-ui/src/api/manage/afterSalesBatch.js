import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listAfterSalesBatch(query) {
  return request({
    url: '/manage/AfterSalesBatch/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getAfterSalesBatch(id) {
  return request({
    url: '/manage/AfterSalesBatch/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增用户
export function addAfterSalesBatch(data) {
  return request({
    url: '/manage/AfterSalesBatch',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateAfterSalesBatch(data) {
  return request({
    url: '/manage/AfterSalesBatch',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delAfterSalesBatch(id) {
  return request({
    url: '/manage/AfterSalesBatch/' + id,
    method: 'delete'
  })
}




