package com.gasstudio.projek;

public class UserModel {
    private String nama,emailre;

    public UserModel(){

    }

    public UserModel(String nama, String emailre){
        this.nama = nama;
        this.emailre = emailre;
    }

    public String getNama(){

        return nama;
    }
    public void setNama(String nama)
    {
        this.nama = nama;
    }

    public String getEmailre(){

        return  emailre;
    }

    public void setEmailre(String emailre) {

        this.emailre = emailre;
    }


}
