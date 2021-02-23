public class Dato{

    private double ph;
    private double soil_temperature;
    private double soil_moisture;
    private double illuminance;
    private double env_temperature;
    private double env_humidity;
    private String label;

    Dato( double ph, double soil_temperature, double soil_moisture, double illuminance, double env_temperature, double env_humidity, String label){
        this.ph=ph;
        this.soil_temperature=soil_temperature;
        this.soil_moisture=soil_moisture;
        this.illuminance=illuminance;
        this.env_temperature=env_temperature;
        this.env_humidity=env_humidity;
        this.label=label;
    }

    public  double getPh(){
        return this.ph;
    }

    public  double getSoil_temperature(){
        return this.soil_temperature;
    }

    public  double getSoil_moisture(){
        return this.soil_moisture;
    }

    public  double getIlluminance(){
        return this.illuminance;
    }

    public  double getEnv_temperature(){
        return this.env_temperature;
    }

    public  double getEnv_humity(){
        return this.env_humidity;
    }

    public String getLabel(){
        return this.label;
    }

}