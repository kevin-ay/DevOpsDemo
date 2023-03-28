package ch.zhaw.iwi.devops.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GelatoController {

    private Map<Integer, Gelato> gelatos = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.gelatos.put(1, new Gelato(1, "Chocolate", "Africa"));
        this.gelatos.put(2, new Gelato(2, "Macha", "Japan"));
        this.gelatos.put(3, new Gelato(3, "Caramel"));
        this.gelatos.put(4, new Gelato(4, "Vanilla", "Italy"));
        System.out.println("Init Data");
    }

    @GetMapping("/greetings/")
    public String test() {
        return "Hello everyone, Enjoy our dellicious Gelato!!";
    }

    @GetMapping("/gelato/{id}")
    public Gelato getGelato(@PathVariable Integer id) {
        return this.gelatos.get(id);
    }

    @PostMapping("/gelato")
    public void createGelato(@RequestBody Gelato todo) {
        var newId = this.gelatos.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        todo.setId(newId);
        this.gelatos.put(newId, todo);
    }

    @PutMapping("/gelato/{id}")
    public void updateGelato(@PathVariable Integer key, @PathVariable String flavor, @PathVariable String origin,
            @RequestBody Gelato gelato) {
        gelato.setId(key);
        gelato.setFlavor(flavor);
        gelato.setOrigin(origin);
        this.gelatos.put(key, gelato);
    }

    @DeleteMapping("/gelato/{id}")
    public Gelato deleteGelato(@PathVariable Integer id) {
        return this.gelatos.remove(id);
    }

}