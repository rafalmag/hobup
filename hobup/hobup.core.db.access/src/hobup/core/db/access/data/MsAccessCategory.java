package hobup.core.db.access.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MsAccessCategory implements MsAccessData {

	@Id
	private Integer id;

	private Integer mainCategoryId;
	private String category;
	private Integer priority;
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMainCategoryId() {
		return mainCategoryId;
	}

	public void setMainCategoryId(Integer mainCategoryId) {
		this.mainCategoryId = mainCategoryId;
	}

	@Override
	public String toString() {
		return "MsAccessCategory [id=" + id + ", mainCategoryId="
				+ mainCategoryId + ", category=" + category + ", priority="
				+ priority + ", description=" + description + "]";
	}

}
