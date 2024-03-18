package com.dmhashanmd.slpd.utils.db.model;

import com.google.firebase.firestore.Exclude;

public class User {

    @Exclude
    private String id;

    private String email;
    private String password;
    private String fullName;

    private String nameWithInitials;
    private int nic;
    private String passport;
    private String drivingLicense;
    private int age;
    private String maritalStatus;

    private String permanentAddress;

    private String residentialAddress;
    private String contactInformationHome;
    private String contactInformationPersonal;

    private String district;
    private String policeDomain;
    private String gramasewakaArea;

    private String nicCopy;
    private String birthCertificate;
    private String photograph;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNameWithInitials() {
        return nameWithInitials;
    }

    public void setNameWithInitials(String nameWithInitials) {
        this.nameWithInitials = nameWithInitials;
    }

    public int getNic() {
        return nic;
    }

    public void setNic(int nic) {
        this.nic = nic;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getContactInformationHome() {
        return contactInformationHome;
    }

    public void setContactInformationHome(String contactInformationHome) {
        this.contactInformationHome = contactInformationHome;
    }

    public String getContactInformationPersonal() {
        return contactInformationPersonal;
    }

    public void setContactInformationPersonal(String contactInformationPersonal) {
        this.contactInformationPersonal = contactInformationPersonal;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPoliceDomain() {
        return policeDomain;
    }

    public void setPoliceDomain(String policeDomain) {
        this.policeDomain = policeDomain;
    }

    public String getGramasewakaArea() {
        return gramasewakaArea;
    }

    public void setGramasewakaArea(String gramasewakaArea) {
        this.gramasewakaArea = gramasewakaArea;
    }

    public String getNicCopy() {
        return nicCopy;
    }

    public void setNicCopy(String nicCopy) {
        this.nicCopy = nicCopy;
    }

    public String getBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(String birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }
}
