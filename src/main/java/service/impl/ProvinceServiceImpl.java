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

//    @Override
//    public Iterable<Province> testMethodOfSpring() {
//        return null;
//    }


    @Override
    public Province findById(Long id) {
        return provinceRepository.findOne(id);
    }
//##################################################################

    @Override
    public Iterable<Province> testMethodOfSpring() {
        return provinceRepository.findAllByIdIsNotNull();
    }

        @Override
    public Iterable<Province> testMethodOfSpring(String name) {
        return provinceRepository.findProvinceByNameEquals(name);
    }



//################################################################

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.delete(id);
    }
}
