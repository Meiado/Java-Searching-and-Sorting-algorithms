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
            City aux = this.getCities(), prev = null;
            while(aux!=null && aux.getName().compareTo(city.getName())<0){
                prev = aux;
                aux = aux.getNext();
            } 
            if(aux!=null){
                if(prev==null)
                    setCities(city);
                else
                    prev.setNext(city);
                city.setNext(aux);
            }
            else
                prev.setNext(city);
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
