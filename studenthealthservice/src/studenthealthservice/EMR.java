package studenthealthservice;

public class EMR { 
   public static int counter = 0;
    private String name;
    private String dob;
    private String rfv;
    private double bodyt;
    private double hr;
    private String diag;
    private String pmeds;
    

   public EMR(String pname, String pdob) {
       name = pname;
       dob = pdob;
       counter++; //keeping count of the user input
               }
    
    public void setName(String pname) { //intializes first data field
        name = pname;
    }

    public static int getCounter(){ 
   
        return counter;
    }
   
    public String getName() {
        return name;
    }

    public EMR(String pname, String pdob, String prfv, double pbodyt, double phr, String pdiag, String ppmeds) { //intializes all data fields
        name = pname;
        dob = pdob;
        rfv = prfv;
        bodyt = pbodyt;
        hr = phr;
        diag = pdiag;
        pmeds = ppmeds;
        counter++;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String pdob) {
        dob = pdob;
    }

    public String getRfv() {
        return rfv;
    }

    public void setRfv(String prfv) {
        rfv = prfv;
    }

    public double getBodyt() {
        return bodyt;
    }

    public void setBodyt(double pbodyt) {
        bodyt = pbodyt;
    }

    public double getHr() {
        return hr;
    }

    public void setHr(double phr) {
        hr = phr;
    }

    public String getDiag() {
        return diag;
    }

    public void setDiag(String pdiag) {
        diag = pdiag;
    }

    public String getPmeds() {
        return pmeds;
    }

    public void setPmeds(String ppmeds) {
        pmeds = ppmeds;
    }

    public void redFlags(double pbodyt, double phr) { //making sure vitals are correctly input 
        String help = "get help!";
        if (bodyt >= 97.3 && bodyt <= 99.1)
            bodyt = pbodyt;
        if (hr >= 60 && hr <= 100)
            hr = phr;
        else {
            System.out.printf(help);
        }
    }
   


       @Override
    public String toString() { //returns string object representing above
        return "\nname : " + name
            + "\nDate of Birth: " + dob
            + "\nReason for visit: " + rfv
            + "\nBody Temperature: " + bodyt
            + "\nHeart Rate " + hr
            + "\nDiagnosis: " + diag
            + "\nPrescribed Meds: " + pmeds;
    }
    
   }
