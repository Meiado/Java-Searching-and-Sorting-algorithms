public class State {

	private String name;

	private CityList cities;

	
	private State next;

	public State(String name, CityList cities, State next) {
		setName(name);
		setCities(cities);
		setNext(next);		
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getNext() {
		return this.next;
	}

	public void setNext(State next) {
		this.next = next;
	}

	public CityList getCities() {
		return cities;
	}

	public void setCities(CityList cities) {
		this.cities = cities;
	}
}