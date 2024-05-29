import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listProduct(query) {
  return request({
    url: '/manage/Product/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getProduct(id) {
  return request({
    url: '/manage/Product/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增用户
export function addProduct(data) {
  return request({
    url: '/manage/Product',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateProduct(data) {
  return request({
    url: '/manage/Product',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delProduct(id) {
  return request({
    url: '/manage/Product/' + id,
    method: 'delete'
  })
}




