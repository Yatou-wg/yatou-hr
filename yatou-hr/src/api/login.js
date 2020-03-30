import request from '@/utils/request'

export function Login(username, password) {
    const data = {
      username,
      password,
    }
    return request({
      url: '/doLogin',
      method: 'post',
      params: data
    })
  }

  export function logout() {
    return request({
      url: '/logout',
      method: 'get',
    })
  }