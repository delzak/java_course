package ru.web.moysklad.model;

public class OrganizationData {
    private String organizationName;

    public String getOrganizationName() {
        return organizationName;
    }

    public OrganizationData withOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }
}
