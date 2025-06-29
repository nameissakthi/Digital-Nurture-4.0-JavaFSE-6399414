package Service;

import Repository.Repository;

public class Service {

    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public String getData(){
        return repository.getData();
    }
}
