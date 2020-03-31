import request from '@/utils/request'

export function listUser() {
  return request({
    url: '/user/list',
    method: 'get'
  })
}

// 查询用户详细
export function getUserInfo(userId) {
  return request({
    url: '/user/' + userId,
    method: 'get'
  })
}

// 用户密码重置
export function updateUserPwd(oldPassword, newPassword) {
  const data = {
    oldPassword,
    newPassword
  }
  return request({
    url: '/user/updatePwd',
    method: 'put',
    params: data
  })
}