package com.github.lyd.base.producer.service;

import com.github.lyd.base.client.entity.SystemGrantAccess;
import com.github.lyd.common.model.PageList;
import com.github.lyd.common.model.PageParams;

import java.util.List;

/**
 * 访问授权
 *
 * @author liuyadu
 */
public interface SystemGrantAccessService {
    /**
     * 获取已授权访问列表
     *
     * @param pageParams
     * @param keyword
     * @return
     */
    PageList<SystemGrantAccess> findListPage(PageParams pageParams, String keyword);

    /**
     * 获取系统用户已授权列表(包含个人特殊权限和所拥有角色的所以权限)
     *
     * @param userId       系统用户ID
     * @param resourceType 资源类型
     * @return
     */
    List<SystemGrantAccess> getUserGrantAccess(Long userId, String resourceType);

    /**
     * 获取系统用户已授权私有列表(不包含角色权限)
     *
     * @param userId
     * @return
     */
    List<SystemGrantAccess> getUserPrivateGrantAccess(Long userId);

    /**
     * 获取所有已授权访问列表
     *
     * @return
     */
    List<SystemGrantAccess> getGrantAccessList();

    /**
     * 添加授权
     *
     * @param authorityOwner  权限所有者ID
     * @param authorityPrefix 权限前缀:用户(USER_) 、角色(ROLE_)、APP(APP_)
     * @param resourceType    资源类型
     * @param resourceIds     资源ID
     * @return
     */
    Boolean addGrantAccess(String authorityOwner, String authorityPrefix, String resourceType, Long... resourceIds);

    /**
     * 更新授权信息
     * 支持更新name,url,resourcePid,serviceId
     * 不允许修改权限标识
     *
     * @param resourceType
     * @param resourceId
     * @return
     */
    Boolean updateGrantAccess(String resourceType, Long resourceId);

    /**
     * 检查资源是否已授权
     *
     * @param resourceId
     * @param resourceType
     * @return
     */
    Boolean isExist(Long resourceId, String resourceType);
}
