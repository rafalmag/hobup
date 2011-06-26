package hobup.core.db.access.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MsAccessSubCategory implements MsAccessData {

	@Id
	private int id;
	private int categoryId;
	private String name;
	private int priority;
	private boolean done = false;
	private Double priceMin;
	private Double priceMax;
	private Double priceExpected;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}

	public Double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Double priceMax) {
		this.priceMax = priceMax;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPriceExpected() {
		return priceExpected;
	}

	public void setPriceExpected(Double priceExpected) {
		this.priceExpected = priceExpected;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "MsAccessSubCategory [id=" + id + ", categoryId=" + categoryId
				+ ", name=" + name + ", priority=" + priority + ", done="
				+ done + ", priceMin=" + priceMin + ", priceMax=" + priceMax
				+ ", priceExpected=" + priceExpected + ", description="
				+ description + "]";
	}

}
