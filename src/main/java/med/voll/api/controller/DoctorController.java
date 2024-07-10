package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.address.Address;
import med.voll.api.doctor.DataListDoctor;
import med.voll.api.doctor.DataRegisterDoctor;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterDoctor data) {
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DataListDoctor> getDoctors(@PageableDefault(size = 10, sort= {"name"}) Pageable pagination) {
        return repository.findAll(pagination).map(DataListDoctor::new);
    }
}
