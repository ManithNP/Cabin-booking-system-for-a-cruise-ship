public  class cabin {
    int cabinNumber;
    String cabinName;

    private passenger[] Passenger;


    public cabin() {
        cabinNumber = 0;

    }

    public cabin(int cabinNumber, String cabinName, passenger[] Passenger) {
        this.cabinNumber = cabinNumber;
        this.cabinName = cabinName;
        this.Passenger = Passenger;
    }

    public String getCabinName() {
        return cabinName;
    }

    public void setCabinName(String cabinName) {
        this.cabinName = cabinName;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }

    public void setCabinNumber(int cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public passenger[] getPassenger() {
        return Passenger;
    }

    public void setPassenger(passenger[] Passenger) {
        this.Passenger = Passenger;
    }
}
