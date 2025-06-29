package Service;

import Repository.RestClient;

public class ClientService {
    private final RestClient repository;

    public ClientService(RestClient repository) {
        this.repository = repository;
    }

    public String fetchResponse(){
        return repository.getResponse();
    }
}
