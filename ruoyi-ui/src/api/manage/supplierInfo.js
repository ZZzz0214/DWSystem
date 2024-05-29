import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listSupplierInfo(query) {
  return request({
    url: '/manage/SupplierInfo/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getSupplierInfo(id) {
  return request({
    url: '/manage/SupplierInfo/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增用户
export function addSupplierInfo(data) {
  return request({
    url: '/manage/SupplierInfo',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateSupplierInfo(data) {
  return request({
    url: '/manage/SupplierInfo',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delSupplierInfo(id) {
  return request({
    url: '/manage/SupplierInfo/' + id,
    method: 'delete'
  })
}




