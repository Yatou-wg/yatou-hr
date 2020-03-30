import request from '@/utils/request'

  export function listUser() {
    return request({
      url: '/user/list',
      method: 'get',
    })
  }