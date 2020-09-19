import request from '@/utils/request'

export function getInfo(username) {
  return request({
    url: '/profile/info/' + username,
    method: 'get',
    params: username
  })
}

/**
 * 更新个人信息
 * @param data
 */
export function updateInfo(data) {
  return request({
    url: '/profile/update/',
    method: 'post',
    data: data
  })
}

/**
 * 更新密码
 * @param data
 */
export function modifyPassword(data) {
  return request({
    url: '/profile/modify/password',
    method: 'post',
    data
  })
}

/**
 * 更新头像
 * @param data
 */
export function modifyIcon(data) {
  return request({
    url: '/profile/modify/icon',
    method: 'post',
    data
  })
}
