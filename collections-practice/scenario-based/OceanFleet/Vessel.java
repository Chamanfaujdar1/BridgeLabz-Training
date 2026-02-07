public class Vessel {
    String vesselId;
    String vesselName;
    double averageSpeed;
    String vesselType;

    public Vessel(){
        
    }

    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    public String getVesselId(){
        return vesselId;
    }

    public String getVesselName(){
        return vesselName;
    }

    public double getAverageSpeed(){
        return averageSpeed;
    }

    public String getVesselType(){
        return vesselType;
    }

    public void setVesselId(String vesselId){
        this.vesselId = vesselId;
    }

    public void setVesselName(String vesselName){
        this.vesselName = vesselName;
    }

    public void setAverageSpeed(double averageSpeed){
        this.averageSpeed = averageSpeed;
    }

    public void setVesselType(String vesselType){
        this.vesselType = vesselType;
    }
}
