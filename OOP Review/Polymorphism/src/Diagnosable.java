public interface Diagnosable {
    double getTemperature();
    boolean hasFever();
    int getSystolic();
    int getDiastolic();
    void setTemperature(double t);
    void setSystolic(int s);
    void setDiastolic(int d);

}
