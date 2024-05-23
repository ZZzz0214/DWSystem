import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listFinancialRecords(query) {
  return request({
    url: '/manage/FinancialRecord/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getFinancialRecords(id) {
  return request({
    url: '/manage/FinancialRecord/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增用户
export function addFinancialRecords(data) {
  return request({
    url: '/manage/FinancialRecord',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateFinancialRecords(data) {
  return request({
    url: '/manage/FinancialRecord',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delFinancialRecords(id) {
  return request({
    url: '/manage/FinancialRecord/' + id,
    method: 'delete'
  })
}




