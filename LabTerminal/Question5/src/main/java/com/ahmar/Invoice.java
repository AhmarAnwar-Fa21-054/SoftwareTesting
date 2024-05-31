package com.ahmar;

import java.util.Objects;

public class Invoice {

    private String freelancerName;
    private String companyName;
    private String numberOfHours;
    private int hourlyRate;

    public Invoice(String freelancerName, String companyName, String numberOfHours, int hourlyRate) {
        this.freelancerName = freelancerName;
        this.companyName = companyName;
        this.numberOfHours = numberOfHours;
        this.hourlyRate = hourlyRate;
    }

    public String getFreelancerName() {
        return freelancerName;
    }

    public void setFreelancerName(String freelancerName) {
        this.freelancerName = freelancerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(String numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return hourlyRate == invoice.hourlyRate && Objects.equals(freelancerName, invoice.freelancerName) && Objects.equals(companyName, invoice.companyName) && Objects.equals(numberOfHours, invoice.numberOfHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freelancerName, companyName, numberOfHours, hourlyRate);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "freelancerName='" + freelancerName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", numberOfHours='" + numberOfHours + '\'' +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
