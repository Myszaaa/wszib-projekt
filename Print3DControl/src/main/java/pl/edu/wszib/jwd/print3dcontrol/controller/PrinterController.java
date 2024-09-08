package pl.edu.wszib.jwd.print3dcontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.jwd.print3dcontrol.model.Printer;
import pl.edu.wszib.jwd.print3dcontrol.security.CustomUserDetails;
import pl.edu.wszib.jwd.print3dcontrol.service.PrinterService;
import org.springframework.security.core.Authentication;
import java.util.List;
import java.util.Optional;

@Controller
public class PrinterController {

    @Autowired
    private PrinterService printerService;

    @GetMapping("/list_printers")
    public String listPrinters(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            model.addAttribute("firstName", userDetails.getFirstName());
            model.addAttribute("lastName", userDetails.getLastName());
        }
        List<Printer> printerList = printerService.findAll();
        model.addAttribute("printers", printerList);

        return "list_printers";
    }

    @GetMapping("/add_printer")
    public String showAddPrinterForm(Model model) {
        Printer printer = new Printer();
        printer.setStatus("Complete");
        model.addAttribute("printer", new Printer());
         return "add_printer";
    }

    @PostMapping("/save_printer")
    public String savePrinter(@ModelAttribute("printer") Printer printer) {
        printerService.save(printer);
        return "redirect:/list_printers";
    }

    @GetMapping("/printers/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Printer> printer = printerService.getPrinterById(id);
        if (printer.isPresent()) {
            model.addAttribute("printer", printer.get());
            return "edit_printer";
        }
        return "redirect:/list_printers";
    }

    @PostMapping("/update_printer")
    public String updatePrinter(@ModelAttribute Printer printer) {
        printer.setStatus("Completed");
        printerService.updatePrinter(printer);
        return "redirect:/list_printers";
    }

    @GetMapping("/api/printers")
    public ResponseEntity<List<Printer>> getAllPrinters() {
        List<Printer> printers = printerService.getAllPrinters();
        return ResponseEntity.ok(printers);
    }
    @PostMapping("/printers/delete/{id}")
    public String deletePrinter(@PathVariable("id") Long id) {
        printerService.deletePrinterById(id);
        return "redirect:/list_printers";
    }
}




