/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.model;

import java.util.Date;

/**
 *
 * @author <Paula>
 */
public class UpdatedAt {
    
    private int id;
    private Date datum;
    private int timezone_type;
    private String timezone;

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
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the timezone_type
     */
    public int getTimezone_type() {
        return timezone_type;
    }

    /**
     * @param timezone_type the timezone_type to set
     */
    public void setTimezone_type(int timezone_type) {
        this.timezone_type = timezone_type;
    }

    /**
     * @return the timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * @param timezone the timezone to set
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    
}
