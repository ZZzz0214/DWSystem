import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listKttShipment(query) {
  return request({
    url: '/manage/KttShipment/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getKttShipment(id) {
  return request({
    url: '/manage/KttShipment/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增用户
export function addKttShipment(data) {
  return request({
    url: '/manage/KttShipment',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateKttShipment(data) {
  return request({
    url: '/manage/KttShipment',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delKttShipment(id) {
  return request({
    url: '/manage/KttShipment/' + id,
    method: 'delete'
  })
}




