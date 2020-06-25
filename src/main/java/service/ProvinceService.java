package service;

import model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Iterable<Province> findAllById(Iterable<Long> id);


    Province findById(Long id);

    void save(Province province);

    void remove(Long id);

}
