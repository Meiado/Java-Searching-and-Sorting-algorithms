public class State {

	private String name;

	private City cities;

	private State prox;

	public State(String name, City cities, State prox) {
		setName(name);
		setCities(cities);
		setProx(prox);		
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getProx() {
		return this.prox;
	}

	public void setProx(State prox) {
		this.prox = prox;
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
			while(aux.getProx()!=null && aux.getName().compareToIgnoreCase(city.getName())>0)
				aux = aux.getProx();
			if(aux.getProx()!=null)
				city.setProx(aux.getProx());
			aux.setProx(city);
		}
		else
			setCities(city);
	}

	public City searchCity(String name)
	{
		City city = this.getCities();
		while(city!=null && city.getName()!=name)
			city = city.getProx();
		return city;
	}
}
