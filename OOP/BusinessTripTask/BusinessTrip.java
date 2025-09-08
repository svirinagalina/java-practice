class BusinessTrip {
    private String surname;
    private int days;
    private int transport;

    public BusinessTrip() {
        this.surname = "";
        this.days = 0;
        this.transport = 0;
    }

    public BusinessTrip(String surname) {
        this.surname = surname;
    }

    public BusinessTrip(String surname, int days, int transport) {
        this.surname = surname;
        this.days = days;
        this.transport = transport;
    }

    public BusinessTrip(BusinessTrip other) {
        this.surname = other.surname;
        this.days = other.days;
        this.transport = other.transport;
    }

    public int getTotal() {
        return days * 25 + transport;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }

    public int getTransport() {
        return transport;
    }
    public void setTransport(int transport) {
        this.transport = transport;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;

        BusinessTrip other = (BusinessTrip) otherObject;
        return this.getTotal() == other.getTotal();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getTotal());
    }

    @Override
    public String toString() {
        return surname + ";" + days + ";" + transport + ";" + getTotal();
    }
    //put your code here
}