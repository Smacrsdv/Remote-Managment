package com.smacrs.timemanagment.core.entities;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	//
	// public static final int NONE_PRESISTED_ENTITY_ID = -1;
	//
	// //public abstract Integer getId();
	//
	// public abstract void setId(Integer Id);
	//
	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (!(obj instanceof BaseEntity))
	// return false;
	// BaseEntity other = (BaseEntity) obj;
	// if (getId() == null) {
	// if (other.getId() != null)
	// return false;
	// } else if (!getId().equals(other.getId()))
	// return false;
	// return true;
	// }
	//
	// public void loadLazyLists(Integer eagerLevel) {
	// }
	//
	// /* (non-Javadoc)
	// * @see java.lang.Comparable#compareTo(java.lang.Object)
	// */
	// @Override
	// public int compareTo(BaseEntity o) {
	//
	// if(o!=null && o.getId() !=null && getId() !=null)
	// {
	// return o.getId().compareTo(getId());
	// }
	// return 0;
	// }
	//
	//
	// /**
	// * @return
	// */
	// public boolean isNotInsertableEntity() {
	//
	//
	// return getId() !=null && getId().intValue()!=NONE_PRESISTED_ENTITY_ID;
	// }
	//
	// public void NullEntityId()
	// {
	// setId(null);
	// }
	//
	// public boolean isPersistedEntity()
	// {
	// return getId()!=null && getId().intValue()!=NONE_PRESISTED_ENTITY_ID;
	// }
	//
	// public boolean isTransientEntity()
	// {
	// return getId()== null || getId()== NONE_PRESISTED_ENTITY_ID;
	// }
}
