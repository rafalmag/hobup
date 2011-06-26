package hobup.core.data;

public class Item {
	private Category category;
	private Double priority;
	private String name;
	private String description;
	private Double priceMin, priceMax, priceExpected;
	private boolean isDone;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getPriority() {
		return priority;
	}

	public void setPriority(Double priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Double getPriceExpected() {
		return priceExpected;
	}

	public void setPriceExpected(Double priceExpected) {
		this.priceExpected = priceExpected;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
