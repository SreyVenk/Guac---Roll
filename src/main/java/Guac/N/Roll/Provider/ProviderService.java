package Guac.N.Roll.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getAllProviders(){
        return providerRepository.findAll();
    }
    public Provider getProviderById(int providerId){
        return providerRepository.findById(providerId).orElse(null);
    }
    public void addNewProvider(Provider provider) {
        providerRepository.save(provider);
    }
    public void updateProvider(int providerId, Provider provider){
        Provider existing = getProviderById(providerId);
        existing.setName(provider.getName());
        existing.setEmail(provider.getEmail());
        existing.setPassword(provider.getPassword());

        providerRepository.save(existing);
    }
    public void fireProviderById(int providerId) {
        providerRepository.deleteById(providerId);
    }
}
