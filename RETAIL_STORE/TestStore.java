package RETAIL_STORE;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestStore {

    public static void main(String[] args) throws NegativeUnitsonhand {
        Scanner input = new Scanner(System.in);
        int pur=0;
        boolean flag=true;
        System.out.println("Enter No of retail items:");
        int n = input.nextInt();
        RetailItem [] obj = new RetailItem[10];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter description of item " + (i + 1) + ":");
            input.nextLine();
            String des = input.nextLine();
            double itmpr = 0;
            int uoh = 0;
            boolean correctval=false;
            do{
                try {
                    System.out.println("Enter price of item " + (i + 1) + ":");
                    itmpr = input.nextDouble();
                    if (itmpr < 0) {
                        throw new Exception();
                    }
                    correctval = true;
                }catch (Exception e) {
                    System.out.println("Price cant be negative\n Enter valid price");
                }
            }while (!correctval);
            System.out.println("Enter number of item " + (i + 1) + ":");
            uoh = input.nextInt();
            obj[i] = new RetailItem(des, itmpr, uoh);
        }

        while(flag){
            System.out.println("\nRetailItem Available in store:\nDescription\tItemprice\tUnitsOnHand");
            for(int i=0;i<n;i++){
                System.out.println(obj[i]);
            }
            System.out.println("1.To purchase 0.Exit");
            int ch=input.nextInt();
            if(ch==1) {
                CashRegister[] purobj = new CashRegister[n];
                for (int i = 0; i < n; i++) {
                    boolean purunits = false;
                    do{
                        try {
                            System.out.println("Enter number of " + obj[i].getDescription() + " to purchase:");
                            pur = input.nextInt();
                            if (pur > obj[i].unitsonhand) {
                                throw new NegativeUnitsonhand("No Stock Available! only " + obj[i].unitsonhand + " Stocks are available\nplease enter purchase items under the limit:");
                            } else
                               purunits = true;
                        }catch (NegativeUnitsonhand e){
                            System.out.println(e);
                        }
                    }while(!purunits);
                    obj[i].unitsonhand -= pur;
                    purobj[i] = new CashRegister(obj[i], pur);
                }
                    System.out.println("Your purchase:\nDescription\t\tNo of units\t\tSubTotal\tTAX\t\tTotal");
                    for (int i = 0; i < n; i++) {
                        System.out.println(purobj[i]);
                    }
                }
            else{
                break;
                }
            }
    }
}
