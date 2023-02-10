public class State {

	private String name;

	private City cities;

	private State next;

	public State(String name, City cities, State next) {
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

	public City getCities() {
		return this.cities;
	}

	public void setCities(City cities){
		this.cities = cities;
	}

	public void orderedCityInsertion(City city){
		if(this.getCities()!=null)
		{
			City aux = this.getCities();
			while(aux.getNext()!=null && aux.getName().compareToIgnoreCase(city.getName())>0)
				aux = aux.getNext();
			if(aux.getNext()!=null)
				city.setNext(aux.getNext());
			aux.setNext(city);
		}
		else
			setCities(city);
	}

	public City searchCity(String name)
	{
		City city = this.getCities();
		while(city!=null && city.getName()!=name)
			city = city.getNext();
		return city;
	}
}
