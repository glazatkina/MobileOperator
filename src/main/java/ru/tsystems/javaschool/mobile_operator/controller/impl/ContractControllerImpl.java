//package ru.tsystems.javaschool.mobile_operator.controller.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ru.tsystems.javaschool.mobile_operator.controller.ContractController;
//import ru.tsystems.javaschool.mobile_operator.entity.Contract;
//import ru.tsystems.javaschool.mobile_operator.service.ContractService;
//
//import javax.persistence.EntityExistsException;
//import javax.persistence.EntityNotFoundException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/contract")
//public class ContractControllerImpl implements ContractController {
//
//    private ContractService service;
//
//    @Autowired
//    public ContractControllerImpl(ContractService contractService) {
//        this.service = contractService;
//    }
//
//    @Override
//    @GetMapping
//    public ResponseEntity<List<Contract>> findAll() {
//        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
//    }
//
//    @Override
//    @GetMapping("/find_contract")
//    public ResponseEntity<Contract> find(@RequestParam String phoneNumber) {
//        try {
//            return new ResponseEntity<>(service.find(phoneNumber), HttpStatus.OK);
//        } catch (EntityNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//    }
//
//    @Override
//    @PostMapping
//    public ResponseEntity<Void> save(@RequestBody Contract contract) {
//        try {
//            service.save(contract);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (EntityExistsException e) {
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//    }
//
//    @Override
//    @PutMapping
//    public ResponseEntity<Void> closeContract(Contract contract) {
//        try {
//            service.closeContract(contract.getPhoneNumber());
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (EntityNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    @GetMapping("/{phoneNumber}/balance")
//    //spring security
//    //power mockito
//    public ResponseEntity<Void> getBalance(@PathVariable String phoneNumber) {
//        try {
////            service.getBalance()
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (EntityNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}
