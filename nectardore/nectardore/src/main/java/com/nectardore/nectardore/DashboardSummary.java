package com.nectardore.nectardore;

public class DashboardSummary {

    private double totalRevenue;
    private double totalProfit;
    private double totalExpenses;
    private double netProfit;

    public DashboardSummary() {
    }

    public DashboardSummary(double totalRevenue,
                            double totalProfit,
                            double totalExpenses,
                            double netProfit) {

        this.totalRevenue = totalRevenue;
        this.totalProfit = totalProfit;
        this.totalExpenses = totalExpenses;
        this.netProfit = netProfit;
    }

    public void setTotalRevenue(double totalRevenue){this.totalRevenue=totalRevenue;}
    public void setTotalProfit(double totalProfit){this.totalProfit=totalProfit;}
    public void setTotalExpenses(double totalExpenses){this.totalExpenses=totalExpenses;}
    public void setNetProfit(double netProfit){this.netProfit=netProfit;}

    public double getTotalRevenue(){return totalRevenue;}
    public double getTotalProfit(){return totalProfit;}
    public double getTotalExpenses(){return totalExpenses;}
    public double getNetProfit(){return netProfit;}
}