package pl.edu.wszib.jwd.print3dcontrol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Printers", schema = "printerUnits")
public class Printer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String model;
    private String location;
    private  String status = "Completed";
    private long printingTime;

    public long getPrintingTime() {
        return printingTime;
    }

    public void setPrintingTime(long printingTime) {
        this.printingTime = printingTime;
    }

    public String getStatus() {
        return status != null ? status : "Completed";
    }

    public Printer(Long id, String location, String model, String name, long printingTime, String status) {
        this.id = id;
        this.location = location;
        this.model = model;
        this.name = name;
        this.printingTime = printingTime;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Printer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
