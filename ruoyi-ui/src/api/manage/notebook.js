import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listNotebook(query) {
  return request({
    url: '/manage/Notebook/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getNotebook(id) {
  return request({
    url: '/manage/Notebook/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增用户
export function addNotebook(data) {
  return request({
    url: '/manage/Notebook',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateNotebook(data) {
  return request({
    url: '/manage/Notebook',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delNotebook(id) {
  return request({
    url: '/manage/Notebook/' + id,
    method: 'delete'
  })
}




