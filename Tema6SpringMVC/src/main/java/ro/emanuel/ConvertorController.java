package ro.emanuel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertorController {

    @GetMapping("/convert")
    public String convertCurrency(
        @RequestParam("suma") double suma,
        @RequestParam("from") String from,
        @RequestParam("to") String to,
        @RequestParam("rate") double rate,
        Model model) {

        double result;
        String currency;

        if (from.equalsIgnoreCase("RON") && to.equalsIgnoreCase("EUR")) {
            result = suma / rate;
            currency = "EURO";
        } else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("RON")) {
            result = suma * rate;
            currency = "RON";
        } else {
            result = suma;
            currency = from; // În caz că `from` și `to` nu sunt RON sau EUR
        }

        model.addAttribute("result", result);
        model.addAttribute("currency", currency);

        return "convertPage";
    }
}
