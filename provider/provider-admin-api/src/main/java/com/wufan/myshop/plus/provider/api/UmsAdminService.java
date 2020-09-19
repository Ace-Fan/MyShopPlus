package com.wufan.myshop.plus.provider.api;

import com.wufan.myshop.plus.provider.domain.UmsAdmin;

/**
 * 用户管理服务
 * @author songw
 * @date 2020/4/27
 */
public interface UmsAdminService {

    /**
     * 新增用户
     * @param umsAdmin {@link UmsAdmin}
     * @return 大于0 则表示添加成功
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 获取用户
     * @param username 用户名
     * @return {@link UmsAdmin}
     */
    UmsAdmin get(String username);

    /**
     * 获取用户
     * @param umsAdmin {@link UmsAdmin}
     * @return {@link UmsAdmin}
     */
    UmsAdmin get(UmsAdmin umsAdmin);

    /**
     * 更新用户
     * @param umsAdmin
     * @return
     */
    int update(UmsAdmin umsAdmin);

    /**
     * 修改密码
     * @param username
     * @param password
     * @return
     */
    int modifyPassword(String username, String password);
    /**
     * 修改头像
     * @param username 用户名
     * @param path 头像路径
     * @return
     */
    int modifyIcon(String username,String path);
}
