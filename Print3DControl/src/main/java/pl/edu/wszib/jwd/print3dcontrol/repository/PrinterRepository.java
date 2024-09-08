package pl.edu.wszib.jwd.print3dcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.print3dcontrol.model.Printer;

import java.util.List;

@Repository
public interface PrinterRepository extends JpaRepository<Printer, Long> {

}
