package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Customer customer){
        customerServiceImpl.signUp(customer);
        return  ResponseEntity.ok("Sign Up Successfully");
    }

    @GetMapping("/signin/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmailId,@PathVariable String custPassword){
        ;
        return ResponseEntity.ok(customerServiceImpl.signIn(custEmailId, custPassword));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>> getAllData(){
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyid/{custId}")
    public ResponseEntity<Customer> getDataById(@PathVariable int custId){
        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }

    @GetMapping("/getdatabyname/{custName}")
    public ResponseEntity<List<Customer>> getDataByName(@PathVariable String custName){
        return ResponseEntity.ok(customerServiceImpl.getDataByName(custName));
    }

    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<String> updateData(@PathVariable int custId,@RequestBody Customer customer ){
        customerServiceImpl.updateData(custId, customer);
        return ResponseEntity.ok("Record Updated Successfully");
    }

    @DeleteMapping("/deletedatabyid/{custId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int custId){
        customerServiceImpl.deleteDataById(custId);
        return ResponseEntity.ok("Record Deleted Sucessfully");
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData( @RequestBody Customer customer){
        customerServiceImpl.deleteAllData();
        return ResponseEntity.ok("All Record Deleted Sucessfully");
    }
}
