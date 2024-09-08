package pl.edu.wszib.jwd.print3dcontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.jwd.print3dcontrol.model.Printer;
import pl.edu.wszib.jwd.print3dcontrol.repository.PrinterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrinterService {

    @Autowired
    private PrinterRepository printerRepository;

    public List<Printer> findAll() {
        return printerRepository.findAll();
    }

    public Printer save(Printer printer) {
        return printerRepository.save(printer);
    }

    public Optional<Printer> getPrinterById(Long id) {
        return printerRepository.findById(id);
    }

    public void updatePrinter(Printer printer) {
        printerRepository.save(printer);
    }

    public void deletePrinterById(Long id) {
        printerRepository.deleteById(id);
    }


    public List<Printer> getAllPrinters() {
        return printerRepository.findAll();
    }
}
