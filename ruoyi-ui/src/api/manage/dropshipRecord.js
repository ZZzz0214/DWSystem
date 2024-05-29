import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listDropshipRecord(query) {
  return request({
    url: '/manage/DropshipRecord/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getDropshipRecord(id) {
  return request({
    url: '/manage/DropshipRecord/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增用户
export function addDropshipRecord(data) {
  return request({
    url: '/manage/DropshipRecord',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateDropshipRecord(data) {
  return request({
    url: '/manage/DropshipRecord',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delDropshipRecord(id) {
  return request({
    url: '/manage/DropshipRecord/' + id,
    method: 'delete'
  })
}




