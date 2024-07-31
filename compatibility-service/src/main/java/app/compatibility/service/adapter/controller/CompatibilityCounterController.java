package app.compatibility.service.adapter.controller;

import app.compatibility.service.port.facade.CompatibilityCounterFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compatibility-rate")
@RequiredArgsConstructor
public class CompatibilityCounterController {
    private final CompatibilityCounterFacade facade;

    @GetMapping("/{user1}/{user2}")
    public Double countCompatibilityRate(@PathVariable Long user1, @PathVariable Long user2) {
        return facade.countCompatibilityRate(user1, user2);
    }

}
