package ecom.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vendor_name", nullable = false)
    @NotNull
    private String vendor_name;

    @Column(name = "vendor_address", nullable = false)
    @NotNull
    private String vendor_address;

    @Column(name = "created_on")
    private LocalDate createdOn;

    public Vendor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getvendor_name() {
        return vendor_name;
    }

    public void setvendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getvendor_address() {
        return vendor_address;
    }

    public void setvendor_address(String vendor_address) {
        this.vendor_address = vendor_address;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
