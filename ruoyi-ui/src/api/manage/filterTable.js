import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listFilterTable(query) {
  return request({
    url: '/manage/FilterTable/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getFilterTable(id) {
  return request({
    url: '/manage/FilterTable/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增用户
export function addFilterTable(data) {
  return request({
    url: '/manage/FilterTable',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateFilterTable(data) {
  return request({
    url: '/manage/FilterTable',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delFilterTable(id) {
  return request({
    url: '/manage/FilterTable/' + id,
    method: 'delete'
  })
}




