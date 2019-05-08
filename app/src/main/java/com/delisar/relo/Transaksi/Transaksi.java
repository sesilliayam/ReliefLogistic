package com.delisar.relo.Transaksi;

public class Transaksi {
    //this is a model class of Transaksi
    public String nameDonatur;
    public String phoneDonatur;
    public String emailDonatur;
    public String addressDonatur;
    public String toDonationWho;
    public String itemCategory;
    public String donationDescription;
    public String dateTransaction;

    //blank constructor
    public Transaksi(){

    }

    //constructor
    public Transaksi(String name, String phone, String email, String address, String toDonation,
                     String item, String desc, String dateTransaction){
        this.nameDonatur = name;
        this.phoneDonatur = phone;
        this.emailDonatur = email;
        this.addressDonatur = address;
        this.toDonationWho = toDonation;
        this.itemCategory = item;
        this.donationDescription = desc;
        this.dateTransaction = dateTransaction;
    }

    //setter
    public void setNameDonatur(String nameDonatur) {
        this.nameDonatur = nameDonatur;
    }

    public void setPhoneDonatur(String phoneDonatur) {
        this.phoneDonatur = phoneDonatur;
    }

    public void setEmailDonatur(String emailDonatur) {
        this.emailDonatur = emailDonatur;
    }

    public void setAddressDonatur(String addressDonatur) {
        this.addressDonatur = addressDonatur;
    }

    public void setToDonationWho(String toDonationWho) {
        this.toDonationWho = toDonationWho;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setDonationDescription(String donationDescription) {
        this.donationDescription = donationDescription;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    //getter
    public String getNameDonatur(){
        return nameDonatur;
    }

    public String getPhoneDonatur(){
        return phoneDonatur;
    }

    public String getEmailDonatur(){
        return emailDonatur;
    }

    public String getAddressDonatur(){
        return addressDonatur;
    }

    public String getToDonationWho(){
        return toDonationWho;
    }

    public String getItemCategory(){
        return itemCategory;
    }

    public String getDonationDescription(){
        return donationDescription;
    }

    public String getDateTransaction(){
        return dateTransaction;
    }
}
