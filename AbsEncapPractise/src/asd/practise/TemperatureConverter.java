package asd.practise;

public class TemperatureConverter {
	//Discuss why this improves design and how it protects the object’s internal state.
	//Answer: Doing this makes it so outside classes cant access  
	
	private double lastResult;
	

	public double toCelsius(double fahrenheit) {
		double celsius = (fahrenheit - 32) / 1.8;	
		setLastResult(celsius);
		return getLastResult();
	}

	public double toFahrenheit(double celsius) {
		double fahrenheit = (celsius * 1.8) + 32;
		setLastResult(fahrenheit);
		return getLastResult();
	}

	public double toKelvin(double celsius) {
		double kelvin = (celsius + 273.15);
		setLastResult(kelvin);
		return getLastResult();
	}

	private double getLastResult() {
		return lastResult;
	}

	private void setLastResult(double lastResult) {
		this.lastResult = lastResult;
	}

}
