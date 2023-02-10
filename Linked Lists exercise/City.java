public class City {

	private String name;

	private City prox;

	public City(String name, City prox) {
		setName(name);
		setProx(prox);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getProx() {
		return this.prox;
	}

	public void setProx(City prox) {
		this.prox = prox;
	}

}
