package com.company;

public class WineCatalog {
    private String wineName;
    private String country;
    private String date;
    private int dayOfDate;
    private int monthOfDate;
    private int yearOfDate;

    public WineCatalog(String wineName, String country, String date) {
        this.wineName = wineName;
        this.country = country;
        this.date = date;
        this.dayOfDate = Integer.parseInt(date.substring(6));
        this.monthOfDate = Integer.parseInt(date.substring(3,5));
        this.yearOfDate = Integer.parseInt(date.substring(0,2));
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear(String userDate){
            int userDayOfDate = Integer.parseInt(userDate.substring(6));
            int userMonthOfDate = Integer.parseInt(userDate.substring(3, 5));
            int userYearOfDate = Integer.parseInt(userDate.substring(0, 2));
            int fullYears;
            if(userYearOfDate>this.yearOfDate){
                fullYears = userYearOfDate - this.yearOfDate;
                if(userMonthOfDate>this.monthOfDate){
                    if(userDayOfDate<this.dayOfDate){
                        --userMonthOfDate;
                        if(userMonthOfDate<this.monthOfDate){
                            --fullYears;
                        }else{
                            //System.out.println(fullYears);
                            return Integer.toString(fullYears);
                        }
                    }else{
                        //System.out.println(fullYears);
                        return Integer.toString(fullYears);
                    }
                }else {
                    //System.out.println(--fullYears);
                    return Integer.toString(--fullYears);
                }
            }else{
                //System.out.println("Error");
                return "Error";
            }
            return "Error";
    }
}
