import request from '@/utils/request'

export function Login(username, password) {
    const data = {
      username,
      password,
    }
    return request({
      url: '/user/login',
      method: 'post',
      params: data
    })
  }