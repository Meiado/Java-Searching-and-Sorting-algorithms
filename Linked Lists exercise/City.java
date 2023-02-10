public class City {

	private String name;

	private City next;

	public City(String name, City next) {
		setName(name);
		setNext(next);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getNext() {
		return this.next;
	}

	public void setNext(City next) {
		this.next = next;
	}

}
