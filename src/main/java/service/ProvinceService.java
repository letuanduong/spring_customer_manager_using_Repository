package service;

import model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();
    Iterable<Province> findAllById(Iterable<Long> id);

//    ################################
    Iterable<Province> testMethodOfSpring();
    Iterable<Province> testMethodOfSpring(String name);
//    ##################################
    Province findById(Long id);

    void save(Province province);

    void remove(Long id);

}
