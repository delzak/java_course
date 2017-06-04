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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationData that = (OrganizationData) o;

        return organizationName != null ? organizationName.equals(that.organizationName) : that.organizationName == null;
    }

    @Override
    public int hashCode() {
        return organizationName != null ? organizationName.hashCode() : 0;
    }
}
