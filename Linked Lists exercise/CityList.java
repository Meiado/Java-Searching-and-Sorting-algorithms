public class CityList {
    private City city;

    public CityList(){
        setCities(null);
    }
    public City getCities() {
        return city;
    }

    public void setCities(City city) {
        this.city = city;
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