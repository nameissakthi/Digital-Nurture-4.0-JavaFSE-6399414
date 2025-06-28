package com.sakthivel;

import java.util.List;

public class MyService {

    private ExternalAPI externalAPI;

    public MyService(ExternalAPI externalAPI){
        this.externalAPI = externalAPI;
    }

    public String fetchData(){
        return externalAPI.getData();
    }

}
