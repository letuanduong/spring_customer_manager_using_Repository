package service.impl;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ProvinceRepository;
import service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Iterable<Province> findAllById(Iterable<Long> id) {
        return provinceRepository.findAll(id);
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findOne(id);
    }
//##################################################################33



    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.delete(id);
    }
}
