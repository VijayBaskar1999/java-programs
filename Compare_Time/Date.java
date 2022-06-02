package Compare_Time;

import java.util.Scanner;

public class Date implements Compare{
    int day,month,year;
    public Date(int d,int m,int y){
        setDate(d);
        setMonth(m);
        setYear(y);
    }

    public int getDate() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public void setDate(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day +"/"+month+"/"+year;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int d=0,m=0,y=0;
        boolean correctval=false;
        do{
            try{
                System.out.println("Enter the Date(dd/mm/yyyy):");
                d=input.nextInt();
                if(d<=0||d>31){
                    throw new Exception();
                }
                m=input.nextInt();
                if(m<=0||m>12){
                    throw new Exception();
                }
                y=input.nextInt();
                if(y<1000||y>10000){
                    throw new Exception();
                }
                correctval=true;
            }catch (Exception e){
                System.out.println("! Invalid Date !\nTry Again");
            }
        }while(!correctval);

        Date d1=new Date(d,m,y);
        System.out.println("Date 1:"+d1);

        System.out.println("Enter date 2:");
        correctval=false;
        do{
            try{
                System.out.println("Enter the Date(dd/mm/yyyy):");
                d=input.nextInt();
                if(d<=0||d>31){
                    throw new Exception();
                }
                m=input.nextInt();
                if(m<=0||m>12){
                    throw new Exception();
                }
                y=input.nextInt();
                if(y<1000||y>10000){
                    throw new Exception();
                }
                correctval=true;
            }catch (Exception e){
                System.out.println("! Invalid Date !\nTry Again");
            }
        }while(!correctval);

        Date d2=new Date(d,m,y);
        System.out.println("Date 2:"+d2);

        String s1,s2;
        s1=d1.toString();
        s2=d2.toString();
        boolean equals = s1.equals(s2);  //objects convert into strings and compared
        if(equals==true){
            System.out.println("same Date");
        }
        else
            System.out.println("Different Date");
        boolean ans=d1.compare(d1,d2);        //objects compared using interface
        if(ans==true){
            System.out.println("same Date");
        }
        else
            System.out.println("Different Date");



    }


    @Override
    public boolean compare(Date d1, Date d2) {
        if(d1.getDate()==d2.getDate() && d1.getMonth()==d2.getMonth() && d1.getYear()==d2.getYear()){
            return true;
        }
        else
            return false;
    }
}
