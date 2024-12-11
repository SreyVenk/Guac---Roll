package Guac.N.Roll.Provider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/all")
    public List<Provider> getAllProviders(){
        return providerService.getAllProviders();
    }
    @GetMapping("/{providerId}")
    public Provider getOneProvider(@PathVariable int providerId){
        return providerService.getProviderById(providerId);
    }
    @PostMapping("/new")
    public List<Provider> addNewProvider(@RequestBody Provider provider){
        providerService.addNewProvider(provider);
        return providerService.getAllProviders();
    }
    @PutMapping("/update/{providerId}")
    public Provider updateProvider(@PathVariable int providerId, @RequestBody Provider provider) {
        providerService.updateProvider(providerId, provider);
        return providerService.getProviderById(providerId);
    }
    @DeleteMapping("/fire/{providerId}")
    public List<Provider> fireProviderById(@PathVariable int providerId) {
        providerService.fireProviderById(providerId);
        return providerService.getAllProviders();
    }
}
