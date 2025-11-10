//p3220829 - Sotiriou Konstantinos
//p3220059 - Pierros Kalakonas

public class LargeDepositor {
    private int AFM;
    private String firstName;
    private String lastName;
    private double savings;
    private double taxedIncome;
    int key() {return AFM;}

    public LargeDepositor(int AFM, String firstName, String lastName, double savings, double taxedIncome) {
        this.AFM = AFM;
        this.firstName = firstName;
        this.lastName = lastName;
        this.savings = savings;
        this.taxedIncome = taxedIncome;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSavings() {
        return savings;
    }

    public double getTaxedIncome() {
        return taxedIncome;
    }

    public void setAFM(int AFM) {
        this.AFM = AFM;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public void setTaxedIncome(double taxedIncome) {
        this.taxedIncome = taxedIncome;
    }

    public double calculateSupicion() {
        return (this.taxedIncome < 8000) ? Double.MAX_VALUE : this.savings - this.taxedIncome;
    }

    public int compareTo(LargeDepositor target) {

        double suspicion1 = this.calculateSupicion();
        double suspicion2 = target.calculateSupicion();

        if (suspicion1 < suspicion2) {
            return -1;

        } else if (suspicion1 > suspicion2) {
            return 1;

        } else {
            return (int) Math.round(this.taxedIncome - target.getTaxedIncome());

        }
    }

    public String toString(){
        return "Depositor: " + this.firstName + " " + this.lastName + ". AFM: " + this.AFM + ". Savings: " + this.savings + ". TI: " + this.taxedIncome;
    }

}