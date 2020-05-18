package com.example.covidlive;

public class CountryModel {

    private String flag, country, cases, todayCases, recovered, deaths, todayDeaths, active, criticla;

    public CountryModel() {
    }

    public CountryModel(String flag, String country, String cases, String todayCases, String recovered, String deaths, String todayDeaths, String active, String criticla) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.recovered = recovered;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.active = active;
        this.criticla = criticla;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCriticla() {
        return criticla;
    }

    public void setCriticla(String criticla) {
        this.criticla = criticla;
    }
}