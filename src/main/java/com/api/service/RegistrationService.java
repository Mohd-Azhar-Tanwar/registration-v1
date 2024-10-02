package com.api.service;

import com.api.entity.Registration;
import com.api.exception.ResourceNotFoundException;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;

    }

    public List<RegistrationDto> getRegistration(){
        List<Registration> registrations = registrationRepository.findAll();
        List<RegistrationDto> dtos = registrations.stream().map(r -> mapToDto(r)).collect(Collectors.toList());
        return dtos;
    }

    public RegistrationDto createRegistration(RegistrationDto registrationDto) {

        //Copy Dto to Entity
        Registration registration = mapToEntity(registrationDto);
        Registration savedEntity = registrationRepository.save(registration);

        //Copy Entity to Dto
        RegistrationDto dto = mapToDto(savedEntity);
        return dto;
    }

    public void deleteRegistration(long id) {
        registrationRepository.deleteById(id);

    }

    public Registration updateRegistration(long id, Registration registration) {
        Registration r = registrationRepository.findById(id).get();
        r.setName(registration.getName());
        r.setEmail(registration.getEmail());
        r.setMobile(registration.getMobile());

        Registration savedEntity = registrationRepository.save(r);
        return  savedEntity;
    }

   Registration mapToEntity(RegistrationDto registrationDto){
       Registration registration = modelMapper.map(registrationDto, Registration.class);
//       Registration registration = new Registration();
//       registration.setName(registrationDto.getName());
//       registration.setEmail(registrationDto.getEmail());
//       registration.setMobile(registrationDto.getMobile());

       return registration;
    }

    RegistrationDto mapToDto(Registration registration){

        RegistrationDto dto = modelMapper.map(registration, RegistrationDto.class);
//        RegistrationDto registrationDto = new RegistrationDto();
//        registrationDto.setName(registration.getName());
//        registrationDto.setEmail(registration.getEmail());
//        registrationDto.setMobile(registration.getMobile());

        return dto;
    }

    public RegistrationDto getRegistrationById(long id) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(
                        ()->new ResourceNotFoundException("Record not found")
        );
        return mapToDto(registration);
    }
}
