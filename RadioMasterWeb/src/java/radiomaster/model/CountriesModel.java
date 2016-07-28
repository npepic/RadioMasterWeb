/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.model;

/**
 *
 * @author <Paula>
 */
public class CountriesModel {

    private int id;
    private String name;
    private String country_code;
    private String region;
    private String subregion;
    private String flag_img_url;

    public CountriesModel() {

    }

    public CountriesModel(int id, String name, String country_code, String region, String subregion, String flag_img_url) {

        this.id = id;
        this.country_code = country_code;
        this.region = region;
        this.subregion = subregion;
        this.flag_img_url = flag_img_url;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the country_code
     */
    public String getCountry_code() {
        return country_code;
    }

    /**
     * @param country_code the country_code to set
     */
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the subregion
     */
    public String getSubregion() {
        return subregion;
    }

    /**
     * @param subregion the subregion to set
     */
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    /**
     * @return the flag_img_url
     */
    public String getFlag_img_url() {
        return flag_img_url;
    }

    /**
     * @param flag_img_url the flag_img_url to set
     */
    public void setFlag_img_url(String flag_img_url) {
        this.flag_img_url = flag_img_url;
    }

}
