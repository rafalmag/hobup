package hobup.core.db.access.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MsAccessMainCategory implements MsAccessData {

	@Id
	private int id;
	private String category;
	private int priority;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MsAccessMainCategory [id=" + id + ", category=" + category
				+ ", priority=" + priority + ", description=" + description
				+ "]";
	}

}
