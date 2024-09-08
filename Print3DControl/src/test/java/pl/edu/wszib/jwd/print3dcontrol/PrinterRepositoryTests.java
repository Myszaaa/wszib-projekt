package pl.edu.wszib.jwd.print3dcontrol;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import pl.edu.wszib.jwd.print3dcontrol.model.Printer;
import pl.edu.wszib.jwd.print3dcontrol.repository.PrinterRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PrinterRepositoryTests {

    @Autowired
    private PrinterRepository printerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testSavePrinter() {

        Printer printer = new Printer();
        printer.getId();
        printer.setName("Drukarka1");
        printer.setModel("LisaX");
        printer.setLocation("A01");

        Printer savedPrinter = printerRepository.save(printer);

        Printer existPrinter = entityManager.find(Printer.class, savedPrinter.getId());
    }

    @Test
    public void testDeletePrinter() {
        Printer printer = new Printer();
        printer.setName("Drukarka1");
        printer.setModel("LisaX");
        printer.setLocation("A01");

        Printer savedPrinter = printerRepository.save(printer);
        Long printerId = savedPrinter.getId();

        printerRepository.deleteById(printerId);

        Optional<Printer> deletedPrinter = printerRepository.findById(printerId);
        assertFalse(deletedPrinter.isPresent());
    }

}
