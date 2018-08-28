package RETAIL_STORE;

public class RetailItem {
    String description;
    double itemprice;
    int unitsonhand;

    public RetailItem(String des,double itmpr,int uoh){
        description=des;
        itemprice=itmpr;
        unitsonhand=uoh;
    }

    public String getDescription() {
        return description;
    }

    public double getItemprice() {
        return itemprice;
    }

    public int getUnitsonhand() {
        return unitsonhand;
    }

    @Override
    public String toString() {
        return String.format("%-12s%.2f%10d",getDescription() , getItemprice(), getUnitsonhand());
    }

}
