package ru.stqa.pft.soap;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        GeoIp geoIp = new GeoIpService().getGeoIpServiceSoap12().getGeoIp("185.150.154.26");
        assertEquals(geoIp.getCountryCode(), "RUS");
    }

    @Test
    public void testInvalidIp() {
        GeoIp geoIp = new GeoIpService().getGeoIpServiceSoap12().getGeoIp("185.150.154.xxx");
        assertEquals(geoIp.getCountryCode(), "RUS");
    }
}
