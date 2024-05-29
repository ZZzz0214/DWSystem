import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listInventoryRecord(query) {
  return request({
    url: '/manage/InventoryRecord/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getInventoryRecord(id) {
  return request({
    url: '/manage/InventoryRecord/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增用户
export function addInventoryRecord(data) {
  return request({
    url: '/manage/InventoryRecord',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateInventoryRecord(data) {
  return request({
    url: '/manage/InventoryRecord',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delInventoryRecord(id) {
  return request({
    url: '/manage/InventoryRecord/' + id,
    method: 'delete'
  })
}




