package hobup.core.db.access.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MsAccessCategory extends MsAccessMainCategory {

	@Id
	private int mainCategoryId;

	public int getMainCategoryId() {
		return mainCategoryId;
	}

	public void setMainCategoryId(int mainCategoryId) {
		this.mainCategoryId = mainCategoryId;
	}

	@Override
	public String toString() {
		return "MsAccessCategory [getMainCategoryId()=" + getMainCategoryId()
				+ ", getId()=" + getId() + ", getCategory()=" + getCategory()
				+ ", getPriority()=" + getPriority() + ", getDescription()="
				+ getDescription() + ", toString()=" + super.toString() + "]";
	}

}
