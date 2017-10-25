package com.example.polly.enty;

import java.io.Serializable;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class Permission implements Serializable {
    private Long id;
    private String permission; //Ȩ�ޱ�ʶ �������ж�ʹ��,��"user:create"
    private String description; //Ȩ������,UI������ʾʹ��
    private String available; //�Ƿ����,��������ý�������Ӹ��û�
    private Long parentId;
    private String parentIds;//����id���ϣ���ʽΪ1-2-3
    private String parentIdsAndId; //�������ټ��ϱ����id������treeչʾ
    public Permission() {
    }

    public Permission(String permission, String description, String available) {
        this.permission = permission;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
    

    public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}	

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	public String getParentIdsAndId() {
		return parentIdsAndId;
	}

	public void setParentIdsAndId(String parentIdsAndId) {
		this.parentIdsAndId = parentIdsAndId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission role = (Permission) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
