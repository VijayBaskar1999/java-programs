package RETAIL_STORE;

public class CashRegister {
//    double tax;
//    double subtotal;
//    double total;
    RetailItem objref;
    int nounitspurchase;

    public CashRegister(RetailItem objref,int noup){
        this.objref=objref;
        nounitspurchase=noup;
    }

    public int getNounitspurchase() {
        return nounitspurchase;
    }

    public double getSubtotal() {
        return objref.getItemprice()*getNounitspurchase();
    }

    public double getTax() {
        return 0.06*getSubtotal();
    }

    public double getTotal() {
        return getSubtotal()+getTax();
    }

    @Override
    public String toString() {
        return String.format("%-16s%d%20.2f%10.2f%10.2f",objref.getDescription(),getNounitspurchase(),getSubtotal(),getTax(),getTotal());
    }
}
